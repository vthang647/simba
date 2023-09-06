package com.simba68.sbproductservices.exceptions;

import com.simba68.sbproductservices.factory.ResponseFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.NotReadablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLException;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler {
    @Autowired
    private ResponseFactory responseFactory;


    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeError(RuntimeException ex){
        log.error("RuntimeException", ex);
        return buildErrorResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NotReadablePropertyException.class})
    public ResponseEntity<Object> handleNotReadablePropertyException(
            NotReadablePropertyException ex) {
        log.error("NotReadablePropertyException", ex);
        return buildErrorResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({IllegalStateException.class})
    public ResponseEntity<Object> handleIllegalStateException(IllegalStateException ex) {
        log.error("IllegalStateException", ex);
        return buildErrorResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({SQLException.class})
    protected ResponseEntity<Object> handleSQLExceptions(SQLException ex) {
        log.error("SQLException", ex);
        return buildErrorResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class,})
    public ResponseEntity<Object> methodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException ex) {
        log.error("MethodArgumentTypeMismatchException", ex);
        return buildErrorResponseEntity(ex.getCause().toString(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity buildErrorResponseEntity(Exception ex, HttpStatus httpStatus){
        return responseFactory.buildErrorResponse(ex, httpStatus);
    }

    private ResponseEntity buildErrorResponseEntity(String message, HttpStatus httpStatus){
        return responseFactory.buildErrorResponse(message, httpStatus);
    }
}
