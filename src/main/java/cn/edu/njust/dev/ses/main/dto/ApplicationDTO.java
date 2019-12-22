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
    private Date appliDeadline;
    private Date appliStartsOn;
    private Byte canApply;
}
