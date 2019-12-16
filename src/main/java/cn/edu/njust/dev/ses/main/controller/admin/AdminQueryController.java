package cn.edu.njust.dev.ses.main.controller.admin;

import cn.edu.njust.dev.ses.main.dto.ResultDTO;
import cn.edu.njust.dev.ses.main.mapper.*;
import cn.edu.njust.dev.ses.main.model.*;
import com.sun.org.apache.xpath.internal.objects.XNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    UserMapper userMapper;

    @ResponseBody
    @RequestMapping(value = "/api/json/create_ccf_event")
    public ResultDTO createCCFEvent(HttpSession session,
                                    @RequestParam Integer number,
                                    @RequestParam String examTime,
                                    @RequestParam String selectExamTime,
                                    @RequestParam String appliDeadline,
                                    @RequestParam String appliStartsOn) throws ParseException {
        //TODO 创建 CCF 考试记录
        //注：默认需将 can_apply 设为 1.
        //eid 自动生成

        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }

        CCFEvent ccfEvent = new CCFEvent();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date exam_time = formatter.parse(examTime);
        Date select_exam_time = formatter.parse(selectExamTime);
        Date appli_deadline = formatter.parse(appliDeadline);
        Byte can_apply = 1;
        Date appli_starts_on = formatter.parse(appliStartsOn);

        ccfEvent.setExamNo(number);
        ccfEvent.setExamTime(exam_time);
        ccfEvent.setSelectExamTime(select_exam_time);
        ccfEvent.setAppliDeadline(appli_deadline);
        ccfEvent.setCanApply(can_apply);
        ccfEvent.setAppliStartsOn(appli_starts_on);

        ccfEventMapper.insertSelective(ccfEvent);
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping("/api/json/delete_ccf_event")
    public ResultDTO deleteCCFEvent(HttpSession session,
                                    @RequestParam Integer eid){
        //TODO

        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }

        ccfEventMapper.deleteByPrimaryKey(eid);
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping("/api/json/approve_grades_entry")
    public ResultDTO approveGradesEntry(HttpSession session,
                                        @RequestParam List<Integer> gids){
        //TODO 同意成绩

        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }

        for (Integer item: gids){
            GradesEntry gradesEntry = new GradesEntry();
            gradesEntry.setGid(item);
            gradesEntry.setIsApproved(true);
            gradesEntryMapper.updateByPrimaryKeySelective(gradesEntry);
        }
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping("/api/json/disapprove_grades_entry")
    public ResultDTO disapproveGradesEntryAndDelete(HttpSession session,
                                                    @RequestParam List<Integer> gids){
        //TODO 不同意成绩并删除
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }

        for (Integer item:gids){
            gradesEntryMapper.deleteByPrimaryKey(item);
        }
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping("/api/json/add_grades_entry")
    public ResultDTO addGradesEntry(HttpSession session,
                                    @RequestParam Integer eid,
                                    @RequestParam Integer grades,
                                    @RequestParam String studentID){
        //TODO 手动添加成绩
        //max_grade = 500
        //is_approved = true
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }

        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStudentIdEqualTo(studentID);
        if (studentMapper.selectByExample(studentExample).isEmpty()) {
            return ResultDTO.errorOf(0,"不存在该学生");
        }

        GradesEntry gradesEntry = new GradesEntry();
        gradesEntry.setIsApproved(true);
        gradesEntry.setEid(eid);
        gradesEntry.setGrades(grades);
        gradesEntry.setStudentId(studentID);

        gradesEntryMapper.insertSelective(gradesEntry);
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping("/api/json/add_student")
    public ResultDTO addStudent(HttpSession session,
                                @RequestParam String studentID,
                                @RequestParam String gender,
                                @RequestParam String idNo,
                                @RequestParam Integer admissionYear,
                                @RequestParam String institute,
                                @RequestParam(required = false) String profession,
                                @RequestParam String classNo,
                                @RequestParam(required = false) String phoneNo){
        //TODO 手动添加学生
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }

        Student student = new Student();
        student.setStudentId(studentID);
        student.setGender(gender);
        student.setIdNo(idNo);
        student.setAdmissionYear(admissionYear);
        student.setInstitute(institute);
        student.setProfession(profession);
        student.setClassNo(classNo);
        student.setPhoneNo(phoneNo);

        studentMapper.insertSelective(student);
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping("/api/json/delete_student")
    public ResultDTO deleteStudent(HttpSession session,
                                   @RequestParam List<String> studentIds){
        //TODO 删除学生
        //注：也要删除与其相关联的学生用户（如果有）。

        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }

        for (String item:studentIds){
            StudentExample studentExample = new StudentExample();
            studentExample.createCriteria().andStudentIdEqualTo(item);
            List<Student> students = studentMapper.selectByExample(studentExample);
            studentMapper.deleteByExample(studentExample);
            for (Student item1:students){
                Integer tmpuid = item1.getUid();
                if (tmpuid != null){
                    userMapper.deleteByPrimaryKey(tmpuid);
                }
            }
        }
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping("/api/json/obtain_grades")
    public ResultDTO obtainGradesEntries(HttpSession session,
                                         @RequestParam(required = false) List<Integer> eids,
                                         @RequestParam(required = false) Integer minPoint,
                                         @RequestParam(required = false) Integer maxPoint){
        //TODO 列出成绩
        //注：不显示未验证的成绩

        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }

        GradesEntryExample gradesEntryExample = new GradesEntryExample();
        if(!eids.isEmpty())
            for(Integer eid: eids){
                GradesEntryExample.Criteria criteria = gradesEntryExample.createCriteria().andEidEqualTo(eid).andIsApprovedEqualTo(true);

                if(minPoint != null) criteria.andGradesGreaterThanOrEqualTo(minPoint);
                if(maxPoint != null) criteria.andGradesLessThanOrEqualTo(maxPoint);
                gradesEntryExample.or(criteria);
            }
        else{
            GradesEntryExample.Criteria criteria = gradesEntryExample.createCriteria().andIsApprovedEqualTo(true);
            if(minPoint != null) criteria.andGradesGreaterThanOrEqualTo(minPoint);
            if(maxPoint != null) criteria.andGradesLessThanOrEqualTo(maxPoint);
        }
        List<GradesEntry> gradesEntries = gradesEntryMapper.selectByExample(gradesEntryExample);
        return ResultDTO.okOf(gradesEntries);
    }
}