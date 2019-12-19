package cn.edu.njust.dev.ses.main.controller;

import cn.edu.njust.dev.ses.main.mapper.GradesEntryMapper;
import cn.edu.njust.dev.ses.main.model.GradesEntry;
import cn.edu.njust.dev.ses.main.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


@Controller
public class StudentGradesUploadController {
    @Autowired
    StudentService studentService;

    private final GradesEntryMapper gradesEntryMapper;
    public StudentGradesUploadController(GradesEntryMapper gradesEntryMapper){this.gradesEntryMapper = gradesEntryMapper; }
    @RequestMapping("/test/student/upload")
    @ResponseBody
    public String uploadStudentGrades(HttpServletRequest request, @RequestParam("student_id") int student_id, @RequestParam("grades") int grades){
        //studentService.uploadEntryGrades(student_id,grades);
        return "AOK";
    }
    @GetMapping("/test/student_upload")
    String test(){return "test-student-grade-entry-upload";}
}
