package cn.edu.njust.dev.ses.main.controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class StudentMainController {
    @RequestMapping("/student/main")
    public String displayMain(HttpSession session){
        return "student-main";
    }

    @RequestMapping("/student/apply")
    public String displayApply(HttpSession session){
        return "student-apply";
    }
}
