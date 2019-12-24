package cn.edu.njust.dev.ses.main.dto;

import cn.edu.njust.dev.ses.main.model.Application;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApplicationDTO extends Application {
    private Integer examNo;
    private Date selectExamTime;
    private Date examTime;
    private Date appliDeadline;
    private Date appliStartsOn;
    private Byte canApply;
    private String name;
    private String studentId;
    private String idNo;
    public String getAppStatus(){
        switch(super.getAppStatus()){
            case "approved":
                return "已通过";
            case "auto-approved":
                return "已自动通过";
            case "manually-approved":
                return "老师通过";
            case "not confirmed":
                return "未确认";
            case "failed":
                return "已落选";
            case "pending":
                return "等待中";
        }
        return "";
    }
}
