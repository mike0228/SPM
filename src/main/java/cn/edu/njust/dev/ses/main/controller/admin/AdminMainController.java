package cn.edu.njust.dev.ses.main.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminMainController {
    @RequestMapping("/teacher/admin")
    public String teacherAdmin(HttpSession session){
        return "teacher/admin";
    }

    @RequestMapping("/teacher/scoreCheck")
    public String scoreCheck(HttpSession session){
        return "teacher/scoreCheck";
    }
    @RequestMapping("/teacher/nameListImport")
    public String nameListImport(HttpSession session){
        return "teacher/nameListImport";
    }
    @RequestMapping("/teacher/Association")
    public String Association(HttpSession session){
        return "teacher/Association";
    }
    @RequestMapping("/teacher/changePassword")
    public String changePassword(HttpSession session){
        return "teacher/changePassword";
    }
    @RequestMapping("/teacher/scoreImport")
    public String scoreImport(HttpSession session){
        return "teacher/scoreImport";
    }
    @RequestMapping("/teacher/scoreList")
    public String scoreList(HttpSession session){
        return "teacher/scoreList";
    }
    @RequestMapping("/teacher/ccfEvent")
    public String ccfEvent(HttpSession session){
        return "teacher/ccfEvent";
    }



}
