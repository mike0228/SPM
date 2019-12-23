package cn.edu.njust.dev.ses.main.controller.admin;

import cn.edu.njust.dev.ses.main.dto.ResultDTO;
import cn.edu.njust.dev.ses.main.dto.StudentDTO;
import cn.edu.njust.dev.ses.main.mapper.*;
import cn.edu.njust.dev.ses.main.model.*;
import cn.edu.njust.dev.ses.main.service.ExportExcelService;
import cn.edu.njust.dev.ses.main.service.GlobalSettingsService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
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
    @Autowired
    GlobalSettingsService globalSettingsService;
    @Autowired
    SelectRankEntryMapper selectRankEntryMapper;

    @RequestMapping(value = "/api/export_qualified_persons_list", method = RequestMethod.GET)
    public void exportQualifiedPersons(HttpSession session, HttpServletResponse response, @RequestParam Integer eid) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sheet1");


        ApplicationExample applicationExample  = new ApplicationExample();
        applicationExample.createCriteria().andEidEqualTo(eid).andAppStatusIn(Arrays.asList("auto-approved", "approved", "manually-approved"));
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

        String fileName = String.format("name_list_%d.xls", ccfEventMapper.selectByPrimaryKey(eid).getExamNo());
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

    @ResponseBody
    @RequestMapping("/api/json/generate_red_list")
    public ResultDTO generateRedList(HttpSession session, @RequestParam Integer eid){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0,"用户未登录或用户类型不正确。");
        }
        SelectRankEntryExample selectRankEntryExample = new SelectRankEntryExample();
        selectRankEntryExample.createCriteria().andEidEqualTo(eid);
        selectRankEntryExample.setOrderByClause("rank_no ASC");
        List<SelectRankEntry> selectRankEntries = selectRankEntryMapper.selectByExample(selectRankEntryExample);
        ApplicationExample applicationExample2 = new ApplicationExample();
        applicationExample2.createCriteria().andEidEqualTo(eid).andAppStatusIn(Arrays.asList("auto-approved", "approved", "manually-approved"));
        long count = applicationMapper.countByExample(applicationExample2);
        for(SelectRankEntry selectRankEntry:selectRankEntries){
            if(count >= globalSettingsService.getMaxSponsoredParticipants())
                break;
            ApplicationExample applicationExample = new ApplicationExample();
            applicationExample.createCriteria().andUidEqualTo(selectRankEntry.getUid()).andEidEqualTo(eid);
            List <Application> applications = applicationMapper.selectByExample(applicationExample);
            if(applications.size() > 0){
                for(Application application:applications){
                    application.setAppStatus("approved");
                    applicationMapper.updateByPrimaryKey(application);
                }
                count++;
            }
        }
        return ResultDTO.okOf();
    }
}
