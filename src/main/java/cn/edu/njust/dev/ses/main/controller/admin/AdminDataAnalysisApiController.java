package cn.edu.njust.dev.ses.main.controller.admin;

import cn.edu.njust.dev.ses.main.dto.DistributionShowcaseDTO;
import cn.edu.njust.dev.ses.main.dto.ResultDTO;
import cn.edu.njust.dev.ses.main.dto.StatsDTO;
import cn.edu.njust.dev.ses.main.mapper.ApplicationExtendMapper;
import cn.edu.njust.dev.ses.main.mapper.GradesEntryAdvancedMapper;
import cn.edu.njust.dev.ses.main.mapper.StudentExtendMapper;
import cn.edu.njust.dev.ses.main.model.CCFEventExample;
import cn.edu.njust.dev.ses.main.model.DetailedGradesEntryExample;
import cn.edu.njust.dev.ses.main.model.Teacher;
import cn.edu.njust.dev.ses.main.model.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.impl.soap.Detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("rawtypes")
@Controller
public class AdminDataAnalysisApiController {
    @Autowired
    GradesEntryAdvancedMapper gradesEntryAdvancedMapper;
    @Autowired
    StudentExtendMapper studentExtendMapper;

    private final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //TODO correspond with front-end

    @ResponseBody
    @RequestMapping("/api/json/stats/overall_stats")
    public ResultDTO obtainOverallStats(HttpSession session,
                                        @RequestParam(required = false) List<Integer> eid,
                                        @RequestParam(required = false) String laterThan,
                                        @RequestParam(required = false) String earlierThan,
                                        @RequestParam(required = false) Integer maxGrades,
                                        @RequestParam(required = false) Integer minGrades,
                                        @RequestParam(required = false) List<String> inInstitutes,
                                        @RequestParam(required = false) List<String> inProfessions){
        //TODO
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        DetailedGradesEntryExample detailedGradesEntryExample = new DetailedGradesEntryExample();
        DetailedGradesEntryExample.Criteria criteria = detailedGradesEntryExample.createCriteria();
        if(eid != null && !eid.isEmpty()) criteria.andEidIn(eid);
        if(StringUtils.isNotBlank(earlierThan)){
            Date date;
            try {
                date = formatter.parse(earlierThan);
            } catch (ParseException e) {
                e.printStackTrace();
                return ResultDTO.errorOf(0, "earlierThan 参数格式错误。");
            }
            criteria.andExamTimeLessThanOrEqualTo(date);
        }
        if(StringUtils.isNotBlank(laterThan)){
            Date date;
            try {
                date = formatter.parse(laterThan);
            } catch (ParseException e) {
                e.printStackTrace();
                return ResultDTO.errorOf(0, "laterThan 参数格式错误。");
            }
            criteria.andExamTimeLessThanOrEqualTo(date);
        }
        if(maxGrades != null) criteria.andGradesLessThan(maxGrades);
        if(minGrades != null) criteria.andGradesGreaterThan(minGrades);
        if(inInstitutes != null && !inInstitutes.isEmpty()) criteria.andInstituteIn(inInstitutes);
        if(inProfessions != null && !inProfessions.isEmpty()) criteria.andProfessionIn(inProfessions);

        List<StatsDTO> statsDTOS = gradesEntryAdvancedMapper.countByDetailedExampleWithGroupByCCFEvent(detailedGradesEntryExample);
        return ResultDTO.okOf(statsDTOS);
    }

    @ResponseBody
    @RequestMapping("/api/json/stats/grades_value_distribution")
    public ResultDTO obtainDistribution(HttpSession session,
                                        @RequestParam(required = false) List<Integer> eid,
                                        @RequestParam(required = false) String laterThan,
                                        @RequestParam(required = false) String earlierThan,
                                        @RequestParam(required = false) List<String> inInstitutes,
                                        @RequestParam(required = false) List<String> inProfessions){
        //TODO
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        DetailedGradesEntryExample detailedGradesEntryExample = new DetailedGradesEntryExample();
        DetailedGradesEntryExample.Criteria criteria = detailedGradesEntryExample.createCriteria();
        if(eid != null && !eid.isEmpty()) criteria.andEidIn(eid);
        if(StringUtils.isNotBlank(earlierThan)){
            Date date;
            try {
                date = formatter.parse(earlierThan);
            } catch (ParseException e) {
                return ResultDTO.errorOf(0, "earlierThan 参数格式错误。");
            }
            criteria.andExamTimeLessThanOrEqualTo(date);
        }
        if(StringUtils.isNotBlank(laterThan)){
            Date date;
            try {
                date = formatter.parse(laterThan);
            } catch (ParseException e) {
                return ResultDTO.errorOf(0, "laterThan 参数格式错误。");
            }
            criteria.andExamTimeGreaterThanOrEqualTo(date);
        }
        if(inInstitutes != null && !inInstitutes.isEmpty()) criteria.andInstituteIn(inInstitutes);
        if(inProfessions != null && !inProfessions.isEmpty()) criteria.andProfessionIn(inProfessions);

        List<DistributionShowcaseDTO> distributionShowcaseDTOS = gradesEntryAdvancedMapper.getGradesDistributionByExample(detailedGradesEntryExample);
        return ResultDTO.okOf(distributionShowcaseDTOS);
    }

    @ResponseBody
    @RequestMapping("/api/json/stats/distribution_of_sponsored")
    public ResultDTO obtainDistributionOfSponsored(HttpSession session){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        return ResultDTO.okOf(gradesEntryAdvancedMapper.getSponsoredParticipantsStats());
    }

    @ResponseBody
    @RequestMapping("/api/json/all_institutes")
    public ResultDTO obtainAllAvailableInstitutes(HttpSession session){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        return ResultDTO.okOf(studentExtendMapper.getAllAvailableInstitutes());
    }

}
