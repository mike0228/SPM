package cn.edu.njust.dev.ses.main.controller;

import cn.edu.njust.dev.ses.main.dto.CCFEventExtendedDTO;
import cn.edu.njust.dev.ses.main.dto.ResultDTO;
import cn.edu.njust.dev.ses.main.mapper.*;
import cn.edu.njust.dev.ses.main.model.CCFEvent;
import cn.edu.njust.dev.ses.main.model.CCFEventExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
    public ResultDTO availableEvents(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit){
        RowBounds rowBounds = page != null && limit != null ? new RowBounds(limit * (page - 1), limit) : new RowBounds();
        CCFEventExample example = new CCFEventExample();
        List<CCFEvent> ccfEvents = ccfEventMapper.selectByExampleWithRowbounds(example, rowBounds);
        List<CCFEventExtendedDTO> ccfEventExtendedDTOS = new ArrayList<>();
        ccfEvents.forEach(value -> {
            CCFEventExtendedDTO ccfEventExtendedDTO = new CCFEventExtendedDTO();
            BeanUtils.copyProperties(value, ccfEventExtendedDTO);
            ccfEventExtendedDTOS.add(ccfEventExtendedDTO);
        });
        return ResultDTO.okOf(ccfEventExtendedDTOS, ccfEventMapper.countByExample(example));
    }
}
