package cn.edu.njust.dev.ses.main.mapper;

import cn.edu.njust.dev.ses.main.dto.DistributionShowcaseDTO;
import cn.edu.njust.dev.ses.main.dto.StatsDTO;
import cn.edu.njust.dev.ses.main.model.CCFEventExample;
import cn.edu.njust.dev.ses.main.model.DetailedGradesEntryExample;
import cn.edu.njust.dev.ses.main.model.GradesEntryExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradesEntryAdvancedMapper {
    List<StatsDTO> countByDetailedExampleWithGroupByCCFEvent(DetailedGradesEntryExample example);
    List<StatsDTO> getSponsoredParticipantsStats();
    List<DistributionShowcaseDTO> getGradesDistributionByExample(DetailedGradesEntryExample example);
}
