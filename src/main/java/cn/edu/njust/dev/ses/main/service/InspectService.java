package cn.edu.njust.dev.ses.main.service;

import cn.edu.njust.dev.ses.main.dto.GradesEntryDTO;
import cn.edu.njust.dev.ses.main.mapper.GradesEntryMapper;
import cn.edu.njust.dev.ses.main.model.GradesEntry;
import cn.edu.njust.dev.ses.main.model.GradesEntryExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InspectService {
    @Autowired
    private GradesEntryMapper gradesEntryMapper;

    public List<GradesEntryDTO> GetByIsApproved(){
        GradesEntryExample example = new GradesEntryExample();
        GradesEntryExample.Criteria criteria = example.createCriteria();
        criteria.andIsApprovedEqualTo(false);
        List<GradesEntry> gradesEntries =gradesEntryMapper.selectByExample(example);
        List<GradesEntryDTO> gradesEntryDTOS = gradesEntries.stream().map(q->{
            GradesEntryDTO gradesEntryDTO = new GradesEntryDTO();
            BeanUtils.copyProperties(q,gradesEntryDTO);
            return gradesEntryDTO;
        }).collect(Collectors.toList());
        return gradesEntryDTOS;
    }
}
