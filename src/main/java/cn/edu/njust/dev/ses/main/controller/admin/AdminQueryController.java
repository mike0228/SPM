package cn.edu.njust.dev.ses.main.controller.admin;

import cn.edu.njust.dev.ses.main.dto.ApplicationDTO;
import cn.edu.njust.dev.ses.main.dto.ResultDTO;
import cn.edu.njust.dev.ses.main.mapper.*;
import cn.edu.njust.dev.ses.main.model.*;
import cn.edu.njust.dev.ses.main.service.AccountManagementService;
import cn.edu.njust.dev.ses.main.service.FileService;
import com.aliyun.oss.OSSException;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SuppressWarnings("rawtypes")
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
    @Autowired
    GradesEntryProofMapper gradesEntryProofMapper;
    @Autowired
    DetailedGradesEntryMapper detailedGradesEntryMapper;
    @Autowired
    FileService fileService;
    @Autowired
    SelectRankEntryMapper selectRankEntryMapper;
    @Autowired
    DetailedSelectRankEntryMapper detailedSelectRankEntryMapper;
    @Autowired
    GlobalParameterMapper globalParameterMapper;
    @Autowired
    AccountManagementService accountManagementService;

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //TODO correspond with front-end
    @ResponseBody
    @RequestMapping(value = "/api/json/create_ccf_event")
    public ResultDTO createCCFEvent(HttpSession session,
                                    @RequestParam Integer number,
                                    @RequestParam String examTime,
                                    @RequestParam String selectExamTime,
                                    @RequestParam String appliDeadline,
                                    @RequestParam String appliStartsOn,
                                    @RequestParam(required = false) String canApply) throws ParseException {

        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }

        CCFEvent ccfEvent = new CCFEvent();


        Date examTimeD = null;
        Date selectExamTimeD = null;
        Date appliDeadlineD = null;
        Date appliStartsOnD = null;
        try {
            examTimeD = new Date(formatter.parse(examTime).getTime() + 8 * 60 * 60 * 1000);
            selectExamTimeD = new Date(formatter.parse(selectExamTime).getTime() + 8 * 60 * 60 * 1000);
            appliDeadlineD = new Date(formatter.parse(appliDeadline).getTime() + 8 * 60 * 60 * 1000);
            appliStartsOnD = new Date(formatter.parse(appliStartsOn).getTime() + 8 * 60 * 60 * 1000);
        } catch (ParseException e) {
            e.printStackTrace();
            return ResultDTO.errorOf(0, "日期格式不正确。");
        }
        if(examTimeD.before(selectExamTimeD))
            return ResultDTO.errorOf(0, "正式考试早于选拔考试时间。");
        if(selectExamTimeD.before(appliDeadlineD))
            return ResultDTO.errorOf(0, "选拔考试时间早于申请截止时间。");
        if(appliDeadlineD.before(appliStartsOnD))
            return ResultDTO.errorOf(0, "申请截止时间早于开放申请时间。");

        ccfEvent.setExamNo(number);
        ccfEvent.setExamTime(examTimeD);
        ccfEvent.setSelectExamTime(selectExamTimeD);
        ccfEvent.setAppliDeadline(appliDeadlineD);
        ccfEvent.setCanApply((byte) (StringUtils.isBlank(canApply)? 0: 1));
        ccfEvent.setAppliStartsOn(appliStartsOnD);
        try {
            ccfEventMapper.insertSelective(ccfEvent);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultDTO.errorOf(0, "创建失败。请检查考试批次是否重复。");
        }
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping("/api/json/get_my_teacher_info")
    public ResultDTO getMyInfo(HttpSession session) {
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if (sessionUser == null || teacherInfo == null) {
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        return ResultDTO.okOf(teacherInfo);
    }
    @ResponseBody
    @RequestMapping("/api/json/delete_ccf_event")
    public ResultDTO deleteCCFEvent(HttpSession session, @RequestParam List<Integer> eid){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        if(eid.isEmpty())
            return ResultDTO.errorOf(0, "指定要删除的考试编号。");
        CCFEventExample ccfEventExample = new CCFEventExample();
        ccfEventExample.createCriteria().andEidIn(eid);

        return ResultDTO.okOf(ccfEventMapper.deleteByExample(ccfEventExample));
    }

    @ResponseBody
    @RequestMapping("/api/json/modify_ccf_event")
    public ResultDTO modifyCCFEvent(HttpSession session,
                                    @RequestParam Integer eid,
                                    @RequestParam(required = false) Integer number,
                                    @RequestParam(required = false) String examTime,
                                    @RequestParam(required = false) String selectExamTime,
                                    @RequestParam(required = false) String appliDeadline,
                                    @RequestParam(required = false) String appliStartsOn,
                                    @RequestParam(required = false) String canApply) throws ParseException {

        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        CCFEvent ccfEvent = new CCFEvent();

        Date examTimeD = null;
        Date selectExamTimeD = null;
        Date appliDeadlineD = null;
        Date appliStartsOnD = null;
        try {
            examTimeD = new Date(formatter.parse(examTime).getTime() + 8 * 60 * 60 * 1000);
            selectExamTimeD = new Date(formatter.parse(selectExamTime).getTime() + 8 * 60 * 60 * 1000);
            appliDeadlineD = new Date(formatter.parse(appliDeadline).getTime() + 8 * 60 * 60 * 1000);
            appliStartsOnD = new Date(formatter.parse(appliStartsOn).getTime() + 8 * 60 * 60 * 1000);
        } catch (ParseException e) {
            e.printStackTrace();
            return ResultDTO.errorOf(0, "日期格式不正确。");
        }
        if(examTimeD.before(selectExamTimeD))
            return ResultDTO.errorOf(0, "正式考试早于选拔考试时间。");
        if(selectExamTimeD.before(appliDeadlineD))
            return ResultDTO.errorOf(0, "选拔考试时间早于申请截止时间。");
        if(appliDeadlineD.before(appliStartsOnD))
            return ResultDTO.errorOf(0, "申请截止时间早于开放申请时间。");

        ccfEvent.setEid(eid);
        ccfEvent.setExamNo(number);
        ccfEvent.setExamTime(examTimeD);
        ccfEvent.setSelectExamTime(selectExamTimeD);
        ccfEvent.setAppliDeadline(appliDeadlineD);
        ccfEvent.setCanApply((byte) (StringUtils.isBlank(canApply)? 0: 1));
        ccfEvent.setAppliStartsOn(appliStartsOnD);

        int result = ccfEventMapper.updateByPrimaryKey(ccfEvent);

        return result > 0? ResultDTO.okOf(): ResultDTO.errorOf(0, "找不到要修改的项目。");
    }


    @ResponseBody
    @RequestMapping("/api/json/approve_grades_entry")
    public ResultDTO approveGradesEntry(HttpSession session,
                                        @RequestParam List<Integer> gid){

        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        if(gid.isEmpty())
            return ResultDTO.errorOf(0, "指定要批准的成绩条目编号。");
        GradesEntry gradesEntry = new GradesEntry();
        gradesEntry.setIsApproved(true);
        GradesEntryExample gradesEntryExample = new GradesEntryExample();
        gradesEntryExample.createCriteria().andGidIn(gid);
        gradesEntryMapper.updateByExampleSelective(gradesEntry, gradesEntryExample);
        deleteGradesEntryProofs(gid);
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping("/api/json/disapprove_grades_entry")
    public ResultDTO disapproveGradesEntryAndDelete(HttpSession session,
                                                    @RequestParam List<Integer> gid){
        //TODO 可要求学生更改凭证
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        if(gid.isEmpty())
            return ResultDTO.errorOf(0, "指定要拒绝的成绩条目编号。");
        deleteGradesEntryProofs(gid);

        GradesEntryExample gradesEntryExample = new GradesEntryExample();
        gradesEntryExample.createCriteria().andGidIn(gid);
        return ResultDTO.okOf(gradesEntryMapper.deleteByExample(gradesEntryExample));
    }

    private void deleteGradesEntryProofs(List<Integer> gid) {
        GradesEntryProofExample gradesEntryProofExample = new GradesEntryProofExample();
        gradesEntryProofExample.createCriteria().andGidIn(gid);
        List<GradesEntryProof> gradesEntryProofs = gradesEntryProofMapper.selectByExample(gradesEntryProofExample);
        for(GradesEntryProof gradesEntryProof: gradesEntryProofs){
            fileService.deleteFileFromAliyun(gradesEntryProof.getProofUrl());
            gradesEntryProofMapper.deleteByPrimaryKey(gradesEntryProof.getGid());
        }
    }

    @ResponseBody
    @RequestMapping("/api/json/add_grades_entry")
    public ResultDTO addGradesEntry(HttpSession session,
                                    @RequestParam Integer eid,
                                    @RequestParam Integer grades,
                                    @RequestParam Integer gradesProblem1,
                                    @RequestParam Integer gradesProblem2,
                                    @RequestParam Integer gradesProblem3,
                                    @RequestParam Integer gradesProblem4,
                                    @RequestParam Integer gradesProblem5,
                                    @RequestParam String studentId){

        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }

        GradesEntry gradesEntry = new GradesEntry();
        gradesEntry.setIsApproved(true);
        gradesEntry.setEid(eid);
        gradesEntry.setGrades(grades);
        gradesEntry.setStudentId(studentId);
        gradesEntry.setGradesProblem1(gradesProblem1);
        gradesEntry.setGradesProblem2(gradesProblem2);
        gradesEntry.setGradesProblem3(gradesProblem3);
        gradesEntry.setGradesProblem4(gradesProblem4);
        gradesEntry.setGradesProblem5(gradesProblem5);

        try {
            gradesEntryMapper.insertSelective(gradesEntry);
        } catch (DuplicateKeyException e) {
            return ResultDTO.errorOf(0, String.format("同一批次下已经有该生的成绩，请直接修改或删除后再添加"));
        }
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping("/api/json/modify_grades_entry")
    public ResultDTO modifyGradesEntry(HttpSession session,
                                       @RequestParam(required = false) Integer eid,
                                        @RequestParam Integer gid,
                                        @RequestParam(required = false) Integer grades,
                                        @RequestParam(required = false) Integer gradesProblem1,
                                        @RequestParam(required = false) Integer gradesProblem2,
                                        @RequestParam(required = false) Integer gradesProblem3,
                                        @RequestParam(required = false) Integer gradesProblem4,
                                        @RequestParam(required = false) Integer gradesProblem5){
        //TODO 修改成绩项
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        GradesEntry gradesEntry = new GradesEntry();
        gradesEntry.setGrades(grades);
        gradesEntry.setEid(eid);
        gradesEntry.setGid(gid);
        gradesEntry.setGradesProblem1(gradesProblem1);
        gradesEntry.setGradesProblem2(gradesProblem2);
        gradesEntry.setGradesProblem3(gradesProblem3);
        gradesEntry.setGradesProblem4(gradesProblem4);
        gradesEntry.setGradesProblem5(gradesProblem5);
        int items = gradesEntryMapper.updateByPrimaryKeySelective(gradesEntry);
        return items > 0 ?  ResultDTO.okOf():ResultDTO.errorOf(0, "找不到要修改的记录");
    }

    @ResponseBody
    @RequestMapping("/api/json/delete_grades_entry")
    public ResultDTO deleteGradesEntry(HttpSession session, @RequestParam List<Integer> gid){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        GradesEntryExample gradesEntryExample = new GradesEntryExample();
        gradesEntryExample.createCriteria().andGidIn(gid);

        return gradesEntryMapper.deleteByExample(gradesEntryExample) > 0? ResultDTO.okOf(): ResultDTO.errorOf(0, "找不到要删除的记录");
    }

    @ResponseBody
    @RequestMapping("/api/json/list_students")
    public ResultDTO obtainStudents(HttpSession session,
                                    @RequestParam(required = false) List<String> institute,
                                    @RequestParam(required = false) Integer admissionYear,
                                    @RequestParam(required = false) List<String> classNo,
                                    @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();

        if(institute != null &&!institute.isEmpty()) criteria.andInstituteIn(institute);
        if(admissionYear != null) criteria.andAdmissionYearEqualTo(admissionYear);
        if(classNo != null && !classNo.isEmpty()) criteria.andClassNoIn(classNo);
        RowBounds rowBounds = page != null && limit != null ? new RowBounds(limit * (page - 1), limit) : new RowBounds();

        List<Student> students = studentMapper.selectByExampleWithRowbounds(studentExample, rowBounds);
        return ResultDTO.okOf(students, studentMapper.countByExample(studentExample));
    }

    @ResponseBody
    @RequestMapping("/api/json/add_student")
    public ResultDTO addStudent(HttpSession session,
                                @RequestParam String studentId,
                                @RequestParam String name,
                                @RequestParam String gender,
                                @RequestParam String idNo,
                                @RequestParam Integer admissionYear,
                                @RequestParam String institute,
                                @RequestParam(required = false) String profession,
                                @RequestParam String classNo,
                                @RequestParam(required = false) String phoneNo){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }

        Student student = new Student();
        student.setStudentId(studentId);
        student.setGender(gender);
        student.setName(name);
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
    @RequestMapping("/api/json/modify_student")
    public ResultDTO modifyStudent(HttpSession session,
                                @RequestParam String studentId,
                                @RequestParam(required = false) String gender,
                                @RequestParam(required = false) String idNo,
                                @RequestParam(required = false) Integer admissionYear,
                                @RequestParam(required = false) String institute,
                                @RequestParam(required = false) String profession,
                                @RequestParam(required = false) String classNo,
                                @RequestParam(required = false) String phoneNo){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }

        Student student = new Student();
        student.setGender(gender);
        student.setIdNo(idNo);
        student.setAdmissionYear(admissionYear);
        student.setInstitute(institute);
        student.setProfession(profession);
        student.setClassNo(classNo);
        student.setPhoneNo(phoneNo);

        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStudentIdEqualTo(studentId);
        int count = studentMapper.updateByExampleSelective(student, studentExample);
        return count > 0? ResultDTO.okOf(): ResultDTO.errorOf(0, "找不到要修改的记录。");
    }

    @ResponseBody
    @RequestMapping("/api/json/delete_student")
    public ResultDTO deleteStudent(HttpSession session,
                                   @RequestParam List<String> studentId){
        //TODO 删除学生
        //注：也要删除与其相关联的学生用户（如果有）。

        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }

        for (String item:studentId){
            StudentExample studentExample = new StudentExample();
            studentExample.createCriteria().andStudentIdEqualTo(item);
            List<Student> students = studentMapper.selectByExample(studentExample);
            studentMapper.deleteByExample(studentExample);
            for (Student item1:students){
                Integer tmpuid = item1.getUid();
                if (tmpuid != null){
                    userMapper.deleteByPrimaryKey(tmpuid);
                    accountManagementService.logoutUserFromAllSessions(tmpuid);
                }
            }
        }
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping("/api/json/obtain_grades")
    public ResultDTO obtainGradesEntries(HttpSession session,
                                         @RequestParam(required = false) List<Integer> eid,
                                         @RequestParam(required = false) String isApproved,
                                         @RequestParam(required = false) String institute,
                                         @RequestParam(required = false) Integer minPoint,
                                         @RequestParam(required = false) Integer maxPoint,
                                         @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit){

        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }

        DetailedGradesEntryExample gradesEntryExample = new DetailedGradesEntryExample();
        DetailedGradesEntryExample.Criteria criteria = gradesEntryExample.createCriteria();

        if(eid != null&& !eid.isEmpty()) criteria.andEidIn(eid);
        if(StringUtils.isNotBlank(institute)) criteria.andInstituteEqualTo(institute);
        if(minPoint != null) criteria.andGradesGreaterThanOrEqualTo(minPoint);
        if(maxPoint != null) criteria.andGradesLessThanOrEqualTo(maxPoint);
        if(StringUtils.isNotBlank(isApproved)) criteria.andIsApprovedEqualTo((byte) (isApproved.equals("on") ? 1: 0));
        else criteria.andIsApprovedEqualTo((byte) 1);
        RowBounds rowBounds = page != null && limit != null ? new RowBounds(limit * (page - 1), limit) : new RowBounds();
        List<DetailedGradesEntry> gradesEntries = detailedGradesEntryMapper.selectByExampleWithRowbounds(gradesEntryExample, rowBounds);
        return ResultDTO.okOf(gradesEntries, detailedGradesEntryMapper.countByExample(gradesEntryExample));
    }

    @ResponseBody
    @RequestMapping("/api/json/obtain_select_exam_rank")
    public ResultDTO obtainSelectExamRank(HttpSession session, @RequestParam Integer eid,
                                          @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        DetailedSelectRankEntryExample selectRankEntryExample = new DetailedSelectRankEntryExample();
        selectRankEntryExample.createCriteria().andEidEqualTo(eid);
        selectRankEntryExample.setOrderByClause("rank_no ASC");
        RowBounds rowBounds = page != null && limit != null ? new RowBounds(limit * (page - 1), limit) : new RowBounds();
        List<DetailedSelectRankEntry> selectRankEntries = detailedSelectRankEntryMapper.selectByExampleWithRowbounds(selectRankEntryExample, rowBounds);
        return ResultDTO.okOf(selectRankEntries, detailedSelectRankEntryMapper.countByExample(selectRankEntryExample));
    }

    private final static List<String> availableStatus = Arrays.asList("not confirmed", "pending", "auto-approved", "approved", "manually-approved", "failed");

    @ResponseBody
    @RequestMapping("/api/json/obtain_application")
    public ResultDTO obtainApplication(HttpSession session, @RequestParam Integer eid, @RequestParam(required = false) List<String> status,
                                       @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| (teacherInfo == null && !sessionUser.getType().equals("associate"))){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        ApplicationExample applicationExample = new ApplicationExample();
        ApplicationExample.Criteria criteria = applicationExample.createCriteria().andEidEqualTo(eid);
        if(status != null&& !status.isEmpty()){
            for(String statusItem: status){
                if(!availableStatus.contains(statusItem)){
                    return ResultDTO.errorOf(0, "无效的状态代码 "+statusItem+"。");
                }
            }
            criteria.andAppStatusIn(status);
        }
        RowBounds rowBounds = page != null && limit != null ? new RowBounds(limit * (page - 1), limit) : new RowBounds();
        List<Application> applications = applicationMapper.selectByExampleWithRowbounds(applicationExample, rowBounds);
        List<ApplicationDTO> applicationDTOS = new ArrayList<>();
        for(Application application: applications){
            ApplicationDTO applicationDTO = new ApplicationDTO();
            StudentExample studentExample = new StudentExample();
            studentExample.createCriteria().andUidEqualTo(application.getUid());
            Student student = studentMapper.selectByExample(studentExample).get(0);
            CCFEvent ccfEvent = ccfEventMapper.selectByPrimaryKey(application.getEid());
            BeanUtils.copyProperties(ccfEvent, applicationDTO);
            BeanUtils.copyProperties(student, applicationDTO);
            BeanUtils.copyProperties(application, applicationDTO);
            applicationDTOS.add(applicationDTO);
        }
        return ResultDTO.okOf(applicationDTOS, applicationMapper.countByExample(applicationExample));
    }

    @ResponseBody
    @RequestMapping("/api/json/change_application_status")
    public ResultDTO changeAppStatus(HttpSession session, @RequestParam Integer aid, @RequestParam String status){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        Application application = applicationMapper.selectByPrimaryKey(aid);
        if(application == null)
            return ResultDTO.errorOf(0, "找不到该申请。");
        if(!availableStatus.contains(status))
            return ResultDTO.errorOf(0, "无效的状态。");
        application.setAppStatus(status);
        applicationMapper.updateByPrimaryKey(application);
        return ResultDTO.okOf();
    }

    @RequestMapping("/api/grades_proof/{gid}")
    public ResponseEntity loadGradesProof(HttpSession session, HttpServletRequest request, @PathVariable Integer gid){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        Student studentInfo = (Student) session.getAttribute("student_info");
        if(sessionUser == null)
            return ResponseEntity.status(403).body("用户未登录。");
        GradesEntryProof gradesEntryProof = gradesEntryProofMapper.selectByPrimaryKey(gid);
        GradesEntry gradesEntry = gradesEntryMapper.selectByPrimaryKey(gid);

        if(studentInfo != null){
            if(gradesEntry == null || gradesEntryProof == null|| !gradesEntry.getStudentId().equals(studentInfo.getStudentId()))
                return ResponseEntity.status(403).body("无权获取该文件。");
        }else if(gradesEntry == null || gradesEntryProof == null){
            return ResponseEntity.status(403).body("找不到要求的文件。");
        }

        if(studentInfo == null && teacherInfo == null)
            return ResponseEntity.status(403).body("无权获取该文件。");

        try {
            String fileName = gradesEntryProof.getProofUrl();
            Resource resource = fileService.loadFileFromAliyunAsResource(fileName);
            String contentType = request.getServletContext().getMimeType(fileName);
            if(contentType == null) {
                contentType = "application/octet-stream";
            }
            return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "filename=\"" + fileName + "\"")
                    .body(resource);

        } catch (IOException | OSSException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).body(e.getLocalizedMessage());
        }
    }
    @ResponseBody
    @RequestMapping("/api/json/change_global_settings")
    public ResultDTO changeMidgradesForAutoapprove(HttpSession session,
                                     @RequestParam String value,
                                     @RequestParam String param){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        if(sessionUser == null|| !sessionUser.getType().equals("associate")){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }

        GlobalParameter globalParameter = new GlobalParameter();
        globalParameter.setParam(param);
        globalParameter.setValue(value);
        try{
            globalParameterMapper.updateByPrimaryKey(globalParameter);
            return ResultDTO.okOf();
        }catch (Exception e){
            e.printStackTrace();
            return ResultDTO.errorOf(0,"修改失败");
        }
    }
}