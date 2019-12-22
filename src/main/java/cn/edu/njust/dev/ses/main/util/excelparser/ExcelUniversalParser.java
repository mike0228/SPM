package cn.edu.njust.dev.ses.main.util.excelparser;


import cn.edu.njust.dev.ses.main.dto.GenericDTO;
import cn.edu.njust.dev.ses.main.exception.RequiredExcelFieldNotFoundException;
import cn.edu.njust.dev.ses.main.exception.UnfitPropertyTypeException;
import cn.edu.njust.dev.ses.main.exception.UnsupportedExcelFormatException;
import cn.edu.njust.dev.ses.main.util.excelparser.annotation.ExcelField;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class ExcelUniversalParser<E extends GenericDTO> {
    public ExcelUniversalParser() {
    }

    private static class BoundField {
        Field field;
        List<String> targetStrings;
        boolean required;

        BoundField(Field field, List<String> targetStrings, boolean required) {
            this.field = field;
            this.targetStrings = targetStrings;
            this.required = required;
        }
    }

    private final static List<Class<?>> supportedFieldType = Arrays.asList(String.class, Integer.class, Long.class, Short.class, Double.class, Float.class, Byte.class, Boolean.class);

    public List<E> parseFrom(InputStream in, Class<E> classObject) throws UnsupportedExcelFormatException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        XSSFWorkbook wb = new XSSFWorkbook(in);
        List<E> result = new ArrayList<>();
        Field[] fields = classObject.getDeclaredFields();
        for (Iterator<Sheet> it = wb.sheetIterator(); it.hasNext(); ) {
            Sheet sheet = it.next();
            boolean done = false;
            int startFromRow = -1;
            HashMap<BoundField, Integer> itemToColumnMap = new HashMap<>();
            //E e = classObject.getConstructor().newInstance();
            for (Field field : fields) {
                ExcelField ef = field.getAnnotation(ExcelField.class);
                if(ef != null) {
                    boolean unsupported = true;
                    for (Class<?> item : supportedFieldType) {
                        if(field.getType().isAssignableFrom(item)) {
                            unsupported = false;
                            break;
                        }
                    }
                    if(unsupported) {
                        throw new UnsupportedOperationException(String.format("Type of field %s from %s (%s) not supported.", field.getName(), classObject, field.getType()));
                    }
                    itemToColumnMap.put(new BoundField(field, Arrays.asList(ef.value()), ef.required()), null);
                }
            }
            for (Row row : sheet) {
                for (Cell cell : row) {
                    if(cell.getCellTypeEnum() == CellType.NUMERIC) break;
                    String stringCellValue = cell.getStringCellValue();
                    for (BoundField bf : itemToColumnMap.keySet()) {
                        if(bf.targetStrings.contains(stringCellValue)) {
                            done = true;
                            startFromRow = cell.getRowIndex();
                            itemToColumnMap.put(bf, cell.getColumnIndex());
                        }
                    }
                }
                if(done) {
                    if(itemToColumnMap.containsValue(null)) {
                        final RequiredExcelFieldNotFoundException[] refnfe = {null};
                        itemToColumnMap.forEach((key, value) -> {
                            if(key.required && value == null) {
                                if(refnfe[0] == null)
                                    refnfe[0] = new RequiredExcelFieldNotFoundException("Cannot find required field.");
                                refnfe[0].getFieldsNotFound().addAll(key.targetStrings);
                            }
                        });
                        if(refnfe[0] != null) throw refnfe[0];
                    }
                    break;
                }
            }
            for (int cRow = startFromRow + 1; cRow <= sheet.getLastRowNum(); ++cRow) {
                final E item = classObject.getConstructor().newInstance();
                PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(item.getClass());
                Row row = sheet.getRow(cRow);
                if(row == null) continue;
                int pdsLength = propertyDescriptors.length;
                try {
                    itemToColumnMap.forEach((key, value) -> {
                        if(value == null) return;
                        Cell cell = row.getCell(value);
                        String originalString = "";
                        if(cell == null) originalString = "";
                        else if(cell.getCellTypeEnum() == CellType.NUMERIC)
                            originalString = String.valueOf(cell.getNumericCellValue());
                        else if(cell.getCellTypeEnum() == CellType.BOOLEAN)
                            originalString = String.valueOf(cell.getBooleanCellValue());
                        else if(cell.getCellTypeEnum() == CellType.FORMULA) {
                            switch (cell.getCachedFormulaResultTypeEnum()) {
                                case NUMERIC:
                                    originalString = String.valueOf(cell.getNumericCellValue());
                                    break;
                                case STRING:
                                    originalString = cell.getStringCellValue();
                                    break;
                                case BOOLEAN:
                                    originalString = String.valueOf(cell.getBooleanCellValue());
                                    break;
                            }
                        } else if(cell.getCellTypeEnum() == CellType.STRING)
                            originalString = cell.getStringCellValue();
                        else originalString = "";

                        PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(classObject, key.field.getName());
                        if(pd != null) {
                            Method writeMethod = pd.getWriteMethod();
                            if(writeMethod != null) {
                                if(!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                    writeMethod.setAccessible(true);
                                }
                                Object object = originalString;
                                Class<?> propertyType = pd.getPropertyType();
                                if(!propertyType.isAssignableFrom(String.class)) {
                                    if(cell == null || (cell.getCellTypeEnum() != CellType.STRING && cell.getCellTypeEnum() != CellType.NUMERIC && cell.getCellTypeEnum() != CellType.BOOLEAN && (cell.getCellTypeEnum() == CellType.FORMULA && cell.getCachedFormulaResultTypeEnum() != CellType.NUMERIC))) {
                                        UnfitPropertyTypeException unfitPropertyTypeException = new UnfitPropertyTypeException(String.format("Unsupported cell type at %d, %d for field %s of type %s from %s. The cell type was %s.", row.getRowNum(), value, pd.getName(), pd.getPropertyType(), classObject, cell == null ? "NULL" : cell.getCellTypeEnum().toString()));
                                        unfitPropertyTypeException.setColumn(value);
                                        unfitPropertyTypeException.setRow(row.getRowNum());
                                        throw unfitPropertyTypeException;
                                    }


                                    if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.BOOLEAN) {
                                        try {
                                            object = cell.getNumericCellValue();
                                            if(propertyType.isAssignableFrom(Long.class)) {
                                                object = (long) cell.getNumericCellValue();
                                            } else if(propertyType.isAssignableFrom(Integer.class)) {
                                                object = (int) cell.getNumericCellValue();
                                            } else if(propertyType.isAssignableFrom(Byte.class)) {
                                                object = (byte) cell.getNumericCellValue();
                                            } else if(propertyType.isAssignableFrom(Short.class)) {
                                                object = (short) cell.getNumericCellValue();
                                            } else if(propertyType.isAssignableFrom(Double.class)) {
                                                object = cell.getNumericCellValue();
                                            } else if(propertyType.isAssignableFrom(Float.class)) {
                                                object = (float) cell.getNumericCellValue();
                                            } else if(propertyType.isAssignableFrom(Boolean.class)) {
                                                object = cell.getBooleanCellValue();
                                            }
                                        } catch (Exception e) {
                                            UnfitPropertyTypeException unfitPropertyTypeException = new UnfitPropertyTypeException(String.format("String at (%d, %d) (%s) can't convert to type %s for bean type %s", row.getRowNum(), value, originalString, pd.getPropertyType(), classObject), e);
                                            unfitPropertyTypeException.setRow(row.getRowNum());
                                            unfitPropertyTypeException.setColumn(value);
                                            throw unfitPropertyTypeException;
                                        }
                                    } else if(cell.getCellTypeEnum() == CellType.STRING || cell.getCellTypeEnum() == CellType.BLANK) {
                                        if(cell.getCellTypeEnum() == CellType.BLANK|| StringUtils.isEmpty(cell.getStringCellValue())){
                                            originalString = "0";
                                        }
                                        try {
                                            if(propertyType.isAssignableFrom(Long.class)) {
                                                object = Long.parseLong(originalString);
                                            } else if(propertyType.isAssignableFrom(Integer.class)) {
                                                object = Integer.parseInt(originalString);
                                            } else if(propertyType.isAssignableFrom(Byte.class)) {
                                                object = Byte.parseByte(originalString);
                                            } else if(propertyType.isAssignableFrom(Short.class)) {
                                                object = Short.parseShort(originalString);
                                            } else if(propertyType.isAssignableFrom(Double.class)) {
                                                object = Double.parseDouble(originalString);
                                            } else if(propertyType.isAssignableFrom(Float.class)) {
                                                object = Float.parseFloat(originalString);
                                            } else if(propertyType.isAssignableFrom(Boolean.class)) {
                                                object = Boolean.parseBoolean(originalString);
                                            }
                                        } catch (NumberFormatException e) {
                                            UnfitPropertyTypeException unfitPropertyTypeException = new UnfitPropertyTypeException(String.format("String at (%d, %d) (%s) can't convert to type %s for bean type %s", row.getRowNum(), value, originalString, pd.getPropertyType(), classObject));
                                            unfitPropertyTypeException.setRow(row.getRowNum());
                                            unfitPropertyTypeException.setColumn(value);
                                            throw unfitPropertyTypeException;

                                        }
                                    }

                                }


                                try {
                                    writeMethod.invoke(item, object);
                                } catch (IllegalAccessException | InvocationTargetException e) {
                                    throw new UnsupportedOperationException(String.format("Cannot invoke write method for %s from %s.", pd.getName(), classObject), e);
                                }
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
                result.add(item);
            }
        }

        return result;
    }
}
