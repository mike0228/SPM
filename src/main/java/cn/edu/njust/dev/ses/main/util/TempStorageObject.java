package cn.edu.njust.dev.ses.main.util;

import lombok.Data;

@Data
public class TempStorageObject<T> {
    private T data;
    private Integer id;
}
