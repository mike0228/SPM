package cn.edu.njust.dev.ses.main.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StatsDTO {
    private Integer count;
    private Integer examNo;
    private Date examTime;
    private Integer eid;
    private Double avgGrades;
    private Integer maxGrades;
    private Integer minGrades;
}
