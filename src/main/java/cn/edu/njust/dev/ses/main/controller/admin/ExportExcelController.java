package cn.edu.njust.dev.ses.main.controller.admin;

import cn.edu.njust.dev.ses.main.dto.StudentDTO;
import cn.edu.njust.dev.ses.main.mapper.ApplicationExtendMapper;
import cn.edu.njust.dev.ses.main.mapper.ApplicationMapper;
import cn.edu.njust.dev.ses.main.mapper.CCFEventMapper;
import cn.edu.njust.dev.ses.main.mapper.StudentMapper;
import cn.edu.njust.dev.ses.main.model.ApplicationExample;
import cn.edu.njust.dev.ses.main.model.Student;
import cn.edu.njust.dev.ses.main.service.ExportExcelService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class ExportExcelController {
    @Autowired
    private ExportExcelService exportExcelService;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CCFEventMapper ccfEventMapper;
    @Autowired
    ApplicationMapper applicationMapper;
    @Autowired
    ApplicationExtendMapper applicationExtendMapper;

    @RequestMapping(value = "/api/export_qualified_persons_list", method = RequestMethod.GET)
    public void exportQualifiedPersons(HttpSession session, HttpServletResponse response, @RequestParam Integer eid) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sheet1");


        ApplicationExample applicationExample  = new ApplicationExample();
        applicationExample.createCriteria().andEidEqualTo(eid);
        List<Student> students = applicationExtendMapper.getStudentBasedOnApplicationExample(applicationExample);

        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue(new HSSFRichTextString("姓名"));
        row.createCell(1).setCellValue(new HSSFRichTextString("身份证号"));
        row.createCell(2).setCellValue(new HSSFRichTextString("金额（元）"));//TODO to be verified.
        //在excel表中添加表头

        int rowNum = 1;
        //在表中存放查询到的数据放入对应的列
        for (Student student : students) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(student.getName());
            row1.createCell(1).setCellValue(student.getIdNo());
            row1.createCell(2).setCellValue(0);
            rowNum++;
        }

        String fileName = "name_list.xls";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }


}
