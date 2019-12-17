package cn.edu.njust.dev.ses.main.service;

import cn.edu.njust.dev.ses.main.mapper.GlobalParameterMapper;
import cn.edu.njust.dev.ses.main.model.GlobalParameter;
import cn.edu.njust.dev.ses.main.model.GlobalParameterExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
final public class GlobalSettingsService {
    private final GlobalParameterMapper globalParameterMapper;
    public GlobalSettingsService(GlobalParameterMapper globalParameterMapper) {
        this.globalParameterMapper = globalParameterMapper;
    }
    private Logger logger = LoggerFactory.getLogger(GlobalSettingsService.class);

    private boolean isInitialized = false;
    private final static Map<String, String> globalParamValueMap = new HashMap<>();




    @Scheduled(fixedDelay = 3500000)
    public void updateCachedValues(){
        globalParamValueMap.clear();
        for(GlobalParameter globalParameter: globalParameterMapper.selectByExample(new GlobalParameterExample())){
            globalParamValueMap.put(globalParameter.getKey(), globalParameter.getValue());
        }
        isInitialized = true;
    }
    public String getValue(String param){
        if(!isInitialized) updateCachedValues();
        return globalParamValueMap.get(param);
    }
    public Integer getMidGradesForAutoApprovement(){
        String midgrades_for_autoapprove1 = globalParamValueMap.get("midgrades_for_autoapprove");
        if(midgrades_for_autoapprove1 == null) {
            logger.warn("\"midgrades_for_autoapprove\" is not found in the database, default value 300 is used instead.");
            return 300;
        } else {
            try {
                return Integer.parseInt(midgrades_for_autoapprove1);
            } catch (NumberFormatException e) {
                logger.warn("\"midgrades_for_autoapprove\" (" + midgrades_for_autoapprove1 + ") can't be parsed as an integer correctly, default value 300 is used instead.");
                e.printStackTrace();
                return 300;
            }
        }
    }

    public Integer getMaxSponsoredParticipants(){
        String maxSponsoredParticipants = globalParamValueMap.get("max_sponsored_participants");
        if(maxSponsoredParticipants == null) {
            logger.warn("\"max_sponsored_participants\" is not found in the database, default value 150 is used instead.");
            return 150;
        } else {
            try {
                return Integer.parseInt(maxSponsoredParticipants);
            } catch (NumberFormatException e) {
                logger.warn("\"max_sponsored_participants\" (" + maxSponsoredParticipants + ") can't be parsed as an integer correctly, default value 150 is used instead.");
                e.printStackTrace();
                return 150;
            }
        }
    }
}
