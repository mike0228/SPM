package cn.edu.njust.dev.ses.main.dto;

import cn.edu.njust.dev.ses.main.util.excelparser.annotation.ExcelField;
import lombok.Data;

@Data
public class GradesEntryDTO extends GenericDTO {
    @ExcelField("考生姓名")
    String name;
    @ExcelField("证件号码")
    String idNo;
    @ExcelField("认证成绩")
    Integer grades;
}
