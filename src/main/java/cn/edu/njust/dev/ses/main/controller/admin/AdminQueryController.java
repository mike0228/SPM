package cn.edu.njust.dev.ses.main.controller.admin;

import cn.edu.njust.dev.ses.main.dto.ResultDTO;
import cn.edu.njust.dev.ses.main.mapper.ApplicationMapper;
import cn.edu.njust.dev.ses.main.mapper.CCFEventMapper;
import cn.edu.njust.dev.ses.main.mapper.GradesEntryMapper;
import cn.edu.njust.dev.ses.main.mapper.StudentMapper;
import com.sun.org.apache.xpath.internal.objects.XNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminQueryController {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CCFEventMapper ccfEventMapper;
    @Autowired
    ApplicationMapper applicationMapper;
    @Autowired
    GradesEntryMapper gradesEntryMapper;

    @ResponseBody
    @RequestMapping("/api/json/create_ccf_event")
    public ResultDTO createCCFEvent(HttpSession session, @RequestParam Integer number, @RequestParam String examTime, @RequestParam String selectExamTime, @RequestParam String appliDeadline, @RequestParam String appliStartsOn){
        //TODO 创建 CCF 考试记录
        //注：默认需将 can_apply 设为 1.
        return null;
    }

    @ResponseBody
    @RequestMapping("/api/json/delete_ccf_event")
    public ResultDTO deleteCCFEvent(HttpSession session, @RequestParam Integer eid){
        //TODO
        return null;
    }
    @ResponseBody
    @RequestMapping("/api/json/approve_grades_entry")
    public ResultDTO approveGradesEntry(HttpSession session, @RequestParam List<Integer> gids){
        //TODO 同意成绩
        return null;
    }
    @ResponseBody
    @RequestMapping("/api/json/disapprove_grades_entry")
    public ResultDTO disapproveGradesEntryAndDelete(HttpSession session, @RequestParam List<Integer> gids){
        //TODO 不同意成绩并删除
        return null;
    }
    @ResponseBody
    @RequestMapping("/api/json/add_grades_entry")
    public ResultDTO addGradesEntry(HttpSession session, @RequestParam Integer eid, @RequestParam Integer grades, @RequestParam String studentID){
        //TODO 手动添加成绩
        return null;
    }
    @ResponseBody
    @RequestMapping("/api/json/add_student")
    public ResultDTO addStudent(HttpSession session, @RequestParam String studentID, @RequestParam String gender, @RequestParam String idNo, @RequestParam Integer admissionYear, @RequestParam String institute, @RequestParam(required = false) String profession, @RequestParam String classNo, @RequestParam String phoneNo){
        //TODO 手动添加学生
        return null;
    }
    @ResponseBody
    @RequestMapping("/api/json/delete_student")
    public ResultDTO deleteStudent(HttpSession session, @RequestParam List<String> studentIds){
        //TODO 删除学生
        //注：也要删除与其相关联的学生用户（如果有）。
        return null;
    }
    @ResponseBody
    @RequestMapping("/api/json/obtain_grades")
    public ResultDTO obtainGradesEntries(HttpSession session, @RequestParam(required = false) List<Integer> eids, @RequestParam(required = false) Integer minPoint, @RequestParam(required = false) Integer maxPoint){
        //TODO 列出成绩
        //注：不显示未验证的成绩
        return null;
    }
}