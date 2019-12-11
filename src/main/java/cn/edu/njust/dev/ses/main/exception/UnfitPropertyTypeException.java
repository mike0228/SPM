package cn.edu.njust.dev.ses.main.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UnfitPropertyTypeException extends UnsupportedExcelFormatException{
    public UnfitPropertyTypeException(){super();}
    public UnfitPropertyTypeException(String message){super(message);}
    public UnfitPropertyTypeException(String message, Throwable cause){super(message, cause);}
    Integer row;
    Integer column;

}
