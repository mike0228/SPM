package cn.edu.njust.dev.ses.main.controller;

import cn.edu.njust.dev.ses.main.mapper.CCFEventMapper;
import cn.edu.njust.dev.ses.main.model.CCFEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CCFEvenController {
    private  final CCFEventMapper ccfEventMapper;

    public CCFEvenController(CCFEventMapper ccfEventMapper) {
        this.ccfEventMapper = ccfEventMapper;
    }

    @RequestMapping(value = "/test_teacher",method = {RequestMethod.GET,RequestMethod.POST})
    public String test_teacher(){
        return "test_ccf_event";
    }

    @RequestMapping(value = "/do_construct_ccfexam",method = {RequestMethod.GET,RequestMethod.POST})
    public String constructCCFExam(HttpServletRequest request, HttpServletResponse response,
                                   HttpSession httpSession) throws ParseException {
        CCFEvent ccfEvent = new CCFEvent();
        Integer eid = 0;
        eid = Integer.valueOf(request.getParameter("eid"));

        Integer exam_no = 0;
        exam_no = Integer.valueOf(request.getParameter("exam_no"));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = request.getParameter("exam_time");
        Date exam_time = formatter.parse(s);

        s = request.getParameter("select_exam_time");
        Date select_exam_time = formatter.parse(s);

        s = request.getParameter("appli_deadline");
        Date appli_deadline = formatter.parse(s);

        Byte can_apply = (byte) 0;
        can_apply = Byte.valueOf(request.getParameter("can_apply"));

        s = request.getParameter("appli_starts_on");
        Date appli_starts_on = formatter.parse(s);

        ccfEvent.setEid(eid);
        ccfEvent.setExamNo(exam_no);
        ccfEvent.setExamTime(exam_time);
        ccfEvent.setSelectExamTime(select_exam_time);
        ccfEvent.setAppliDeadline(appli_deadline);
        ccfEvent.setCanApply(can_apply);
        ccfEvent.setAppliStartsOn(appli_starts_on);

        ccfEventMapper.insert(ccfEvent);
        return "test_ccf_event";
    }
}
