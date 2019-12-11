package cn.edu.njust.dev.ses.main.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class RequiredExcelFieldNotFoundException extends UnsupportedExcelFormatException {
    public RequiredExcelFieldNotFoundException(){ super(); }
    public RequiredExcelFieldNotFoundException(String message){super(message);}
    public RequiredExcelFieldNotFoundException(String message, Throwable cause){ super( message, cause); }
    @Getter
    private List<String> fieldsNotFound = new ArrayList<>();
}
