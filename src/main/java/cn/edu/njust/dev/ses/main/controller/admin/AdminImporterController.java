package cn.edu.njust.dev.ses.main.controller.admin;

import cn.edu.njust.dev.ses.main.dto.GradesEntryDTO;
import cn.edu.njust.dev.ses.main.dto.ResultDTO;
import cn.edu.njust.dev.ses.main.dto.StudentDTO;
import cn.edu.njust.dev.ses.main.mapper.ApplicationMapper;
import cn.edu.njust.dev.ses.main.mapper.CCFEventMapper;
import cn.edu.njust.dev.ses.main.mapper.GradesEntryMapper;
import cn.edu.njust.dev.ses.main.mapper.StudentMapper;
import cn.edu.njust.dev.ses.main.model.*;
import cn.edu.njust.dev.ses.main.service.StudentService;
import cn.edu.njust.dev.ses.main.util.TempStorageObject;
import cn.edu.njust.dev.ses.main.util.excelparser.ExcelUniversalParser;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Controller
public class AdminImporterController {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CCFEventMapper ccfEventMapper;
    @Autowired
    ApplicationMapper applicationMapper;
    @Autowired
    GradesEntryMapper gradesEntryMapper;
    @Autowired
    StudentService studentService;

    @ResponseBody
    @RequestMapping("/api/json/import_student_via_excel")
    public ResultDTO importStudentThroughExcel(HttpSession session, @RequestParam MultipartFile file){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        List<StudentDTO> result = null;
        try{
            InputStream in = file.getInputStream();
            ExcelUniversalParser<StudentDTO> eup = new ExcelUniversalParser<>();
            result = eup.parseFrom(in, StudentDTO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResultDTO.errorOf(0, String.format("发生异常（%s）", ex.getClass()), ex.getLocalizedMessage());
        }
        TempStorageObject<List<StudentDTO>> tempStorageObject = new TempStorageObject<>();
        tempStorageObject.setData(result);

        tempStorageObject.setId(RandomUtils.nextInt());
        session.setAttribute("last_result_student_import", tempStorageObject);
        return ResultDTO.okOf(result);
    }

    @ResponseBody
    @RequestMapping("/api/json/import_grades_via_excel")
    public ResultDTO importGradesEntriesThroughExcel(HttpSession session, @RequestParam MultipartFile file){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        List<GradesEntryDTO> result = null;
        try{
            InputStream in = file.getInputStream();
            ExcelUniversalParser<GradesEntryDTO> eup = new ExcelUniversalParser<>();
            result = eup.parseFrom(in, GradesEntryDTO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResultDTO.errorOf(0, String.format("发生异常（%s）", ex.getClass()), ex.getLocalizedMessage());
        }

        for(GradesEntryDTO gradesEntryDTO: result){
            StudentExample studentExample = new StudentExample();
            studentExample.createCriteria().andIdNoEqualTo(gradesEntryDTO.getIdNo());
            List<Student> students = studentMapper.selectByExample(studentExample);
            if(!students.isEmpty())
                gradesEntryDTO.setStudentId(students.get(0).getStudentId());
        }


        TempStorageObject<List<GradesEntryDTO>> tempStorageObject = new TempStorageObject<>();
        tempStorageObject.setData(result);

        tempStorageObject.setId(RandomUtils.nextInt());
        session.setAttribute("last_result_grades_import", tempStorageObject);
        return ResultDTO.okOf(result);
    }

    @ResponseBody
    @RequestMapping("/api/json/confirm_grades_import")
    public ResultDTO confirmGradesImport(HttpSession session, @RequestParam Integer confirmId){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        TempStorageObject<List<GradesEntryDTO>> tempStorageObject = (TempStorageObject<List<GradesEntryDTO>>) session.getAttribute("last_result_grades_import");
        if(tempStorageObject == null){
            return ResultDTO.errorOf(0, "上次上传的文件已经过期，请重新上传。");
        }
        if(!tempStorageObject.getId().equals(confirmId)){
            return ResultDTO.errorOf(0, "确认 ID 不正确，请重新上传文件。");
        }
        long count = 0;
        for(GradesEntryDTO gradesEntryDTO : tempStorageObject.getData()){
            GradesEntry gradesEntry = new GradesEntry();
            BeanUtils.copyProperties(gradesEntryDTO, gradesEntry);
            count += gradesEntryMapper.insertSelective(gradesEntry);
        }
        return ResultDTO.okOf(count);
    }



    @ResponseBody
    @RequestMapping("/api/json/confirm_student_import")
    public ResultDTO confirmStudentImport(HttpSession session, @RequestParam Integer confirmId){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        TempStorageObject<List<StudentDTO>> tempStorageObject = (TempStorageObject<List<StudentDTO>>) session.getAttribute("last_result_student_import");
        if(tempStorageObject == null){
            return ResultDTO.errorOf(0, "上次上传的文件已经过期，请重新上传。");
        }
        if(!tempStorageObject.getId().equals(confirmId)){
            return ResultDTO.errorOf(0, "确认 ID 不正确，请重新上传文件。");
        }
        long count = 0;
        for(StudentDTO studentDTO : tempStorageObject.getData()){
            Student student = new Student();
            BeanUtils.copyProperties(studentDTO, student);
            studentService.insertStudentRecordAndUpdateGradesEntry(student);
            count ++;
        }
        return ResultDTO.okOf(count);
    }
}
