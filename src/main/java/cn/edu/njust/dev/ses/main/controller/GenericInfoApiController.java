package cn.edu.njust.dev.ses.main.controller;

import cn.edu.njust.dev.ses.main.dto.ResultDTO;
import cn.edu.njust.dev.ses.main.mapper.*;
import cn.edu.njust.dev.ses.main.model.CCFEventExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GenericInfoApiController {
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

    @RequestMapping("/api/json/available_events")
    @ResponseBody
    public ResultDTO availableEvents(){
        return ResultDTO.okOf(ccfEventMapper.selectByExample(new CCFEventExample()));
    }
}
