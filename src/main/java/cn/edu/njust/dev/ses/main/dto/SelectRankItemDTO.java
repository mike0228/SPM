package cn.edu.njust.dev.ses.main.dto;

import cn.edu.njust.dev.ses.main.model.SelectRankEntry;
import lombok.Data;

@Data
public class SelectRankItemDTO extends SelectRankEntry {
    private Boolean isSelf;
}
