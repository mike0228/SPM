package cn.edu.njust.dev.ses.main.controller.student;

import cn.edu.njust.dev.ses.main.dto.ResultDTO;
import cn.edu.njust.dev.ses.main.mapper.ApplicationMapper;
import cn.edu.njust.dev.ses.main.mapper.CCFEventMapper;
import cn.edu.njust.dev.ses.main.mapper.GradesEntryMapper;
import cn.edu.njust.dev.ses.main.mapper.StudentMapper;
import cn.edu.njust.dev.ses.main.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class StudentQueryController {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CCFEventMapper ccfEventMapper;
    @Autowired
    ApplicationMapper applicationMapper;
    @Autowired
    GradesEntryMapper gradesEntryMapper;

    @ResponseBody
    @RequestMapping("/api/json/all_apps")
    public ResultDTO getAllApplication(HttpSession session){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Student studentInfo = (Student) session.getAttribute("student_info");
        if(sessionUser == null|| studentInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andUidEqualTo(sessionUser.getUid());
        List<Application> result = applicationMapper.selectByExample(applicationExample);

        return ResultDTO.okOf(result);
    }

    @ResponseBody
    @RequestMapping("/api/json/all_grades")
    public ResultDTO<List<GradesEntry>> getAllGradesEntries(HttpSession session, @RequestParam Boolean isOnHold){
        //TODO 获取学生所有成绩
        //注：应用studentInfo内的学号获取。
        return null;
    }

    @ResponseBody
    @RequestMapping("/api/json/delete_onhold_grades")
    public ResultDTO<?> deleteOnHoldEntry(HttpSession session, @RequestParam Integer entryID){
        //TODO 删除待审核成绩
        //注：应确认该成绩确实是待审核状态再删除，若不是待审核则不能删除。
        return null;
    }

    @ResponseBody
    @PostMapping("/api/json/submit_app")
    public ResultDTO submitApplication(HttpSession session, @RequestParam Integer eid/*CCF ID*/){
        //TODO 创建申请
        //注：应判断该次 CCF 考试是否已开放申请且当前还可以申请（使用 appli_deadline，appli_starts_on 和 can_apply）
        return null;
    }
    @ResponseBody
    @PostMapping("/api/json/submit_app")
    public ResultDTO deleteApplication(HttpSession session, @RequestParam Integer aid/*CCF ID*/){
        //TODO 删除申请
        return null;
    }
}
