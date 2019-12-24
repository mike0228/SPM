package cn.edu.njust.dev.ses.main.controller.student;

import cn.edu.njust.dev.ses.main.dto.ResultDTO;
import cn.edu.njust.dev.ses.main.dto.SelectRankItemDTO;
import cn.edu.njust.dev.ses.main.mapper.*;
import cn.edu.njust.dev.ses.main.model.*;
import cn.edu.njust.dev.ses.main.service.FileService;
import cn.edu.njust.dev.ses.main.service.GlobalSettingsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@SuppressWarnings("rawtypes")
@Controller
public class StudentQueryController {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CCFEventMapper ccfEventMapper;
    @Autowired
    ApplicationMapper applicationMapper;
    @Autowired
    DetailedApplicationMapper detailedApplicationMapper;
    @Autowired
    GradesEntryMapper gradesEntryMapper;
    @Autowired
    SelectRankEntryMapper selectRankEntryMapper;
    @Autowired
    GlobalSettingsService globalSettingsService;
    @Autowired
    GradesEntryProofMapper gradesEntryProofMapper;
    @Autowired
    FileService fileService;

    @ResponseBody
    @RequestMapping("/api/json/all_info")
    public ResultDTO getStudentAllInfo(HttpSession session){//获取学生所有个人信息
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Student studentInfo = (Student) session.getAttribute("student_info");
        if(sessionUser == null|| studentInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        StudentExample studentExample=new StudentExample();
        studentExample.createCriteria().andUidEqualTo(studentInfo.getUid());
        List<Student> result=studentMapper.selectByExample(studentExample);

        return ResultDTO.okOf(result);
    }


    @ResponseBody
    @RequestMapping("/api/json/all_apps")
    public ResultDTO getAllApplication(HttpSession session){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Student studentInfo = (Student) session.getAttribute("student_info");
        if(sessionUser == null|| studentInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        DetailedApplicationExample detailedApplicationExample = new DetailedApplicationExample();
        detailedApplicationExample.createCriteria().andUidEqualTo(sessionUser.getUid());
        List<DetailedApplication> result = detailedApplicationMapper.selectByExample(detailedApplicationExample);

        return ResultDTO.okOf(result);
    }

    @ResponseBody
    @RequestMapping("/api/json/all_grades")
    public ResultDTO getAllGradesEntries(HttpSession session){
        //isOnHold决定是否要获取待审核的成绩
        //TODO 获取学生所有CCF成绩
        //注：应用studentInfo内的学号获取。
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Student studentInfo = (Student) session.getAttribute("student_info");
        if(sessionUser == null|| studentInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        GradesEntryExample gradesEntryExample=new GradesEntryExample();
        gradesEntryExample.createCriteria().andStudentIdEqualTo(studentInfo.getStudentId());
        List<GradesEntry> result=gradesEntryMapper.selectByExample(gradesEntryExample);
        return ResultDTO.okOf(result);
    }


    @ResponseBody
    @RequestMapping("/api/json/all_select_rank")
    public ResultDTO getAllSelectRankEntries(HttpSession session){
        //TODO 获取学生所有rank排名
        //注：应用studentInfo内的学号获取。
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Student studentInfo = (Student) session.getAttribute("student_info");
        if(sessionUser == null|| studentInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        SelectRankEntryExample selectRankEntryExample=new SelectRankEntryExample();
        selectRankEntryExample.createCriteria().andUidEqualTo(studentInfo.getUid());
        selectRankEntryExample.or().andIdNoEqualTo(studentInfo.getIdNo());
        List<SelectRankEntry> result=selectRankEntryMapper.selectByExample(selectRankEntryExample);
        return ResultDTO.okOf(result);
    }


    @ResponseBody
    @RequestMapping("/api/json/delete_onhold_grades")
    public ResultDTO<?> deleteOnHoldEntry(HttpSession session, @RequestParam Integer entryID){
        //TODO 删除待审核成绩
        //注：应确认该成绩确实是待审核状态再删除，若不是待审核则不能删除。
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Student studentInfo = (Student) session.getAttribute("student_info");
        if(sessionUser == null|| studentInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        GradesEntryExample gradesEntryExample=new GradesEntryExample();
        gradesEntryExample.createCriteria().andIsApprovedEqualTo(false).andEidEqualTo(entryID).andStudentIdEqualTo(studentInfo.getStudentId());
        int items=gradesEntryMapper.deleteByExample(gradesEntryExample);//删除记录条数，判断是否删除成功
        return items > 0? ResultDTO.okOf() : ResultDTO.errorOf(0, "找不到该记录或者不能删除");
    }

    @ResponseBody
    @RequestMapping("/api/json/submit_app")
    public ResultDTO submitApplication(HttpSession session, @RequestParam Integer eid){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Student studentInfo = (Student) session.getAttribute("student_info");
        if(sessionUser == null|| studentInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        ApplicationExample applicationExample2 = new ApplicationExample();
        applicationExample2.createCriteria().andUidEqualTo(studentInfo.getUid()).andEidEqualTo(eid);
        if(applicationMapper.countByExample(applicationExample2) > 0)
            return ResultDTO.errorOf(0, "已经申请了该次考试。");

        CCFEvent ccfEvent = ccfEventMapper.selectByPrimaryKey(eid);
        if(ccfEvent == null)
            return ResultDTO.errorOf(0, "不存在该考试 ID。");
        if(ccfEvent.getCanApply() == 0)
            return ResultDTO.errorOf(0, "该次考试的申请已经关闭。");
        Date currentTime = new Date();

        if(currentTime.after(ccfEvent.getAppliDeadline()))
            return ResultDTO.errorOf(0, "该次考试的公费申请截止时间已过。");
        if(currentTime.before(ccfEvent.getAppliStartsOn()))
            return ResultDTO.errorOf(0, "该次考试的公费申请还未开放提交。");

        Application application = new Application();
        application.setUid(studentInfo.getUid());
        application.setEid(eid);
        application.setAppTime(currentTime);
        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andAppStatusEqualTo("auto-approved").andUidEqualTo(studentInfo.getUid());
        long autoApprovedChancesUsed = applicationMapper.countByExample(applicationExample);
        GradesEntryExample gradesEntryExample = new GradesEntryExample();
        gradesEntryExample.createCriteria().andStudentIdEqualTo(studentInfo.getStudentId()).andGradesGreaterThanOrEqualTo(globalSettingsService.getMidGradesForAutoApprovement()); //TODO Change so that it reflects the sitewide setting.
        long qualifiedEntries = gradesEntryMapper.countByExample(gradesEntryExample);
        if(qualifiedEntries > autoApprovedChancesUsed){
            application.setAppStatus("auto-approved");
        }
        applicationMapper.insertSelective(application);
        return ResultDTO.okOf();
    }
    @ResponseBody
    @RequestMapping("/api/json/delete_app")
    public ResultDTO deleteApplication(HttpSession session, @RequestParam Integer aid/*CCF ID*/){
        //TODO 删除申请
        //注：为了保留各种记录，只能删除状态为 pending 的记录。
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Student studentInfo = (Student) session.getAttribute("student_info");
        if(sessionUser == null|| studentInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        ApplicationExample applicationExample=new ApplicationExample();
        applicationExample.createCriteria().andAidEqualTo(aid).andAppStatusEqualTo("pending");
        int items=applicationMapper.deleteByExample(applicationExample);
        return items>0?ResultDTO.okOf():ResultDTO.errorOf(0,"找不到该记录或者不能删除");
    }
    @ResponseBody
    @RequestMapping("/api/json/add_grades_for_review")
    public ResultDTO addUnapprovedGradesEntry(HttpSession session,
                                              @RequestParam Integer eid,
                                              @RequestParam Integer grades,
                                              @RequestParam Integer gradesProblem1,
                                              @RequestParam Integer gradesProblem2,
                                              @RequestParam Integer gradesProblem3,
                                              @RequestParam Integer gradesProblem4,
                                              @RequestParam Integer gradesProblem5,
                                              @RequestParam MultipartFile file
                                              ) throws IOException {
        //TODO 添加待审核成绩
        //注：需将 is_approved 设成 false
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Student studentInfo = (Student) session.getAttribute("student_info");
        if(sessionUser == null|| studentInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        GradesEntryExample gradesEntryExample = new GradesEntryExample();
        gradesEntryExample.createCriteria().andEidEqualTo(eid).andStudentIdEqualTo(studentInfo.getStudentId());
        if(gradesEntryMapper.countByExample(gradesEntryExample) > 0){
            return ResultDTO.errorOf(0, "该用户该次考试已经有成绩，不能再提交。");
        }

        GradesEntry gradesEntry=new GradesEntry();
        gradesEntry.setEid(eid);
        gradesEntry.setStudentId(studentInfo.getStudentId());
        gradesEntry.setGrades(grades);
        gradesEntry.setIsApproved(false);
        gradesEntry.setGradesProblem1(gradesProblem1);
        gradesEntry.setGradesProblem2(gradesProblem2);
        gradesEntry.setGradesProblem3(gradesProblem3);
        gradesEntry.setGradesProblem4(gradesProblem4);
        gradesEntry.setGradesProblem5(gradesProblem5);
        int items = gradesEntryMapper.insertSelective(gradesEntry);
        GradesEntryProof gradesEntryProof = new GradesEntryProof();
        gradesEntryProof.setGid(gradesEntry.getGid());
        gradesEntryProof.setProofUrl(fileService.upload(file.getInputStream(), Objects.requireNonNull(file.getOriginalFilename())));
        int items2 = gradesEntryProofMapper.insertSelective(gradesEntryProof);
        return ResultDTO.okOf();
    }
    @ResponseBody
    @RequestMapping("/api/json/all_ranks_result")
    public ResultDTO obtainAllRankingResult(HttpSession session){
        //TODO 列出该考生的所有选拔考试 rank
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Student studentInfo = (Student) session.getAttribute("student_info");
        if(sessionUser == null|| studentInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        SelectRankEntryExample selectRankEntryExample=new SelectRankEntryExample();
        selectRankEntryExample.createCriteria().andUidEqualTo(studentInfo.getUid());
        List<SelectRankEntry> result=selectRankEntryMapper.selectByExample(selectRankEntryExample);
        return ResultDTO.okOf(result);
    }

    @ResponseBody
    @RequestMapping("/api/json/show_all_ranks")
    public ResultDTO showRankingResult(HttpSession session, @RequestParam Integer eid){
        //注：在之前的考试中 rank 信息是公开的，所以在网站上可以查询考试的 rank 状况
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Student studentInfo = (Student) session.getAttribute("student_info");
        if(sessionUser == null|| studentInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andUidEqualTo(studentInfo.getUid()).andEidEqualTo(eid).andAppStatusNotEqualTo("auto-approved");
        if(applicationMapper.countByExample(applicationExample) == 0)
            return ResultDTO.errorOf(0, "你没有参加该次选拔考试，不能查看该次考试的 rank 情况。");
        SelectRankEntryExample selectRankEntryExample = new SelectRankEntryExample();
        selectRankEntryExample.createCriteria().andEidEqualTo(eid);
        List<SelectRankEntry> selectRankEntries = selectRankEntryMapper.selectByExample(selectRankEntryExample);
        List<SelectRankItemDTO> selectRankItemDTOS = new ArrayList<>();
        for(SelectRankEntry entry: selectRankEntries){
            //将用户自己条目标出来，便于前端高亮显示
            SelectRankItemDTO selectRankItemDTO = new SelectRankItemDTO();
            BeanUtils.copyProperties(entry, selectRankItemDTO);
            selectRankItemDTO.setIsSelf(entry.getUid().equals(studentInfo.getUid()));
            selectRankItemDTOS.add(selectRankItemDTO);
        }
        return ResultDTO.okOf(selectRankItemDTOS);
    }
}
