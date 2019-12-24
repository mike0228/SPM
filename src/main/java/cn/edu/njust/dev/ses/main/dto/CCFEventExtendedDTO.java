package cn.edu.njust.dev.ses.main.dto;

import cn.edu.njust.dev.ses.main.model.CCFEvent;
import lombok.Getter;

import java.util.Date;

public class CCFEventExtendedDTO extends CCFEvent {
    @Getter
    private boolean canApply;
    public boolean isCanApply(){
        Date currentDate = new Date(new Date().getTime() + 8 * 3600 * 1000);
        return getAppliDeadline().after(currentDate) && getAppliStartsOn().before(currentDate) && getCanApply() > 0;
    }
}
