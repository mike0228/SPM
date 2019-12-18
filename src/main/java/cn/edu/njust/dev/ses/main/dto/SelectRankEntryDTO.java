package cn.edu.njust.dev.ses.main.dto;

import cn.edu.njust.dev.ses.main.util.excelparser.annotation.ExcelField;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SelectRankEntryDTO  extends GenericDTO {

    private Integer reid;
    private Integer uid;
    @ExcelField("选拔排名")
    private Integer rank;
    private Integer eid;
}
