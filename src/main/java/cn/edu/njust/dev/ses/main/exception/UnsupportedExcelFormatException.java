package cn.edu.njust.dev.ses.main.exception;

public class UnsupportedExcelFormatException extends RuntimeException {
    public UnsupportedExcelFormatException(){
        super();
    }
    public UnsupportedExcelFormatException(String message){
        super(message);
    }
}
