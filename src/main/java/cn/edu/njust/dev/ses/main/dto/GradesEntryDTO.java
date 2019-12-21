package cn.edu.njust.dev.ses.main.dto;

import cn.edu.njust.dev.ses.main.util.excelparser.annotation.ExcelField;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GradesEntryDTO extends GenericDTO {
    private Integer gid;
    @ExcelField("认证成绩")
    private Integer grades;
    private Integer eid;
    private String studentId;
    @ExcelField("证件号码")
    private String idNo;
    @ExcelField("第一题得分")
    private Integer gradesProblem1;
    @ExcelField("第二题得分")
    private Integer gradesProblem2;
    @ExcelField("第三题得分")
    private Integer gradesProblem3;
    @ExcelField("第四题得分")
    private Integer gradesProblem4;
    @ExcelField("第五题得分")
    private Integer gradesProblem5;
}
