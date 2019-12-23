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
    public String nameListImport(HttpSession session){ return "teacher/nameListImport"; }
    @RequestMapping("/teacher/studentImport")
    public String studentImport(HttpSession session){ return "teacher/studentImport"; }
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
    @RequestMapping("/teacher/studentEvent")
    public String studentEvent(HttpSession session){ return "teacher/studentEvent"; }
    @RequestMapping("/teacher/gradeEvent")
    public String gradeEvent(HttpSession session){ return "teacher/gradeEvent"; }
    @RequestMapping("/teacher/scoreAnalysis")
    public String scoreAnalysis(HttpSession session){ return "teacher/scoreAnalysis"; }
    @RequestMapping("/teacher/chart")
    public String chart(HttpSession session){ return "teacher/chart"; }
    @RequestMapping("/teacher/pan")
    public String pan(HttpSession session){ return "teacher/pan"; }
    @RequestMapping("/teacher/information")
    public String information(HttpSession session){ return "teacher/information"; }
    @RequestMapping("/teacher/studentCheck")
    public String studentCheck(HttpSession session){ return "teacher/studentCheck"; }
    @RequestMapping("/teacher/redList")
    public String redList(HttpSession session){ return "teacher/redList"; }
    @RequestMapping("/teacher/userManager")
    public String userManager(HttpSession session){ return "teacher/userManager"; }




    @RequestMapping("/associate/main")
    public String associateMain(HttpSession session){ return "association_main"; }
    @RequestMapping("/associate/association_change_filter")
    public String associateChangeFilter(HttpSession session){ return "association_change_filter"; }
    @RequestMapping("/associate/association_import_scores")
    public String associateImportScores(HttpSession session){ return "association_import_scores"; }
    @RequestMapping("/associate/association_change_password")
    public String associateChangePassword(HttpSession session){ return "association_change_password"; }

}
