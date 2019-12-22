package cn.edu.njust.dev.ses.main.dto;

import cn.edu.njust.dev.ses.main.model.CCFEvent;
import lombok.Getter;

import java.util.Date;

public class CCFEventExtendedDTO extends CCFEvent {
    @Getter
    private boolean canApply;
    public boolean isCanApply(){
        Date currentDate = new Date();
        return getAppliDeadline().after(currentDate) && getAppliStartsOn().before(currentDate) && getCanApply() > 0;
    }
}
