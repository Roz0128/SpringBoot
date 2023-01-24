package me.with.study.common.exception;

import me.with.study.common.Constants;
import org.springframework.http.HttpStatus;

public class SpringBootStudyException extends Exception{

    private static final long serialVersionUID = 4663380430591151694L; // 직렬화를 위해 만듬

    private Constants.ExceptionClass exceptionClass;
    private HttpStatus httpStatus;

    public SpringBootStudyException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message){
        super(exceptionClass.toString() + message);
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    public Constants.ExceptionClass getExceptionClass(){
        return exceptionClass;
    }

    public int getHttpStatusCode(){
        return httpStatus.value();
    }

    public String getHttpStatusType(){
        return httpStatus.getReasonPhrase();
    }

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }

}
