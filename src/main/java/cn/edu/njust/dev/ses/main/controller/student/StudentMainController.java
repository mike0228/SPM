package cn.edu.njust.dev.ses.main.controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class StudentMainController {
    @RequestMapping("/student/main")
    public String displayMain(HttpSession session){
        return "student/Student";
    }
    @RequestMapping("/student/CCFscore")
    public String displayCCFscore(HttpSession session){
        return "student/CCFscore";
    }
    @RequestMapping("/student/SelectionScore")
    public String displaySelectionScore(HttpSession session){
        return "student/SelectionScore";
    }
    @RequestMapping("/student/SubApplication")
    public String displaySubApplication(HttpSession session){
        return "student/SubApplication";
    }
    @RequestMapping("/student/SeeApplication")
    public String displaySeeApplication(HttpSession session){
        return "student/SeeApplication";
    }
    @RequestMapping("/student/ChangeImformation")
    public String displayChangeImformation(HttpSession session){
        return "student/ChangeImformation";
    }
    @RequestMapping("/student/SubScore")
    public String displaySubScore(HttpSession session){
        return "student/SubScore";
    }
    @RequestMapping("/student/SelectionScoreList")
    public String displaySelectionScoreList(HttpSession session){
        return "student/SelectionScoreList";
    }
    @RequestMapping("/student/SeeImformation")
    public String displaySeeImformation(HttpSession session){
        return "student/SeeImformation";
    }
    @RequestMapping("/student/apply")
    public String displayApply(HttpSession session){
        return "student-apply";
    }
}
