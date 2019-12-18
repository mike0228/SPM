package cn.edu.njust.dev.ses.main.util;

import lombok.Data;

import java.util.Date;

@Data
public class TempStorageObject<T> {
    private T data;
    private Integer id;
    private Date creationDate;
}
