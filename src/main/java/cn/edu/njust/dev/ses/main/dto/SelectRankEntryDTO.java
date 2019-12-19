package cn.edu.njust.dev.ses.main.dto;

import cn.edu.njust.dev.ses.main.util.excelparser.annotation.ExcelField;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SelectRankEntryDTO  extends GenericDTO {
    @ExcelField("序号")
    private Integer reid;
    @ExcelField("姓名")
    private String name;
    @ExcelField("学号")
    private String studentId;
    @ExcelField("年级")
    private Integer grade;
    @ExcelField("身份证号码")
    private String idNo;
    @ExcelField("选拔赛rank")
    private Integer rank;
    private Integer eid;//导入的时候填写
}
