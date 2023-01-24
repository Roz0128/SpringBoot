package me.with.study.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // Controller에서 발생하는 예외처리를 여기서 처리 한다
public class SpringBootStudyExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e){
        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.info("Advice 내 ExceptionHandler 호출");

        Map<String, String> map = new HashMap<>();
        map.put("Error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }

    @ExceptionHandler(value = SpringBootStudyException.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(SpringBootStudyException e){
        HttpHeaders responseHeaders = new HttpHeaders();

        Map<String, String> map = new HashMap<>();
        map.put("error type", e.getHttpStatusType());
        map.put("error code", Integer.toString(e.getHttpStatusCode())); // Map<String, Object>로 설정하면 Integer.toString() 작업 필요 X
        map.put("message", e.getMessage());

        return new ResponseEntity<>(map, responseHeaders, e.getHttpStatus());
    }

}
