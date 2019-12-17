package cn.edu.njust.dev.ses.main.mapper;

import cn.edu.njust.dev.ses.main.dto.DistributionShowcaseDTO;
import cn.edu.njust.dev.ses.main.dto.StatsDTO;
import cn.edu.njust.dev.ses.main.model.GradesEntryExample;

import java.util.List;

public interface GradesEntryAdvancedMapper {
    List<StatsDTO> countByExampleWithGroupByCCFEvent(GradesEntryExample example);
    List<DistributionShowcaseDTO> getGradesDistributionByExample(GradesEntryExample example);
}
