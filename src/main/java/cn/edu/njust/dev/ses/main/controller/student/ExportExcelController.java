package cn.edu.njust.dev.ses.main.controller.student;

import cn.edu.njust.dev.ses.main.dto.StudentDTO;
import cn.edu.njust.dev.ses.main.service.ExportExcelService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ExportExcelController {
    @Autowired
    private ExportExcelService exportExcelService;
    @RequestMapping(value = "/UserExcelDownloads", method = RequestMethod.GET)
    public void downloadAllClassmate(HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");

        List<StudentDTO> studentDTOS = exportExcelService.studentDTOS();

        String fileName = "userinf"  + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据

        int rowNum = 1;

        String[] headers = { "姓名", "身份证号"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (StudentDTO studentDTO : studentDTOS) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(studentDTO.getName());
            row1.createCell(1).setCellValue(studentDTO.getIdNo());
            rowNum++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }


}
