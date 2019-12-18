package cn.edu.njust.dev.ses.main.dto;

import cn.edu.njust.dev.ses.main.util.excelparser.annotation.ExcelField;
import lombok.Data;
import lombok.Getter;

@Data
public class StudentDTO extends GenericDTO {
    @Getter
    private Integer uid;
    @ExcelField("姓名")
    private String name;
    @ExcelField("学号")
    private String studentId;
    @ExcelField("性别")
    private String gender;
    @ExcelField({"身份证号", "身份证", "证件号码"})
    private String idNo;
    @ExcelField(value = "民族", required = false)
    private String ethnicGroup;
    @ExcelField("入学年份")
    private Integer admissionYear;
    @ExcelField("学院")
    private String institute;
    @ExcelField("专业")
    private String profession;
    @ExcelField({"班级", "班级号"})
    private String classNo;
    @ExcelField(value = {"联系方式", "电话号码"}, required = false)
    private String phoneNo;
}
