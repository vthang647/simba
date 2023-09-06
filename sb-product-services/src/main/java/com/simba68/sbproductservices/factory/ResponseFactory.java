package com.simba68.sbproductservices.factory;

import com.simba68.sbproductservices.constant.StatusCode;
import com.simba68.sbproductservices.response.GeneralResponse;
import com.simba68.sbproductservices.response.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseFactory {
    public <T>ResponseEntity<GeneralResponse<T>> success(Object data, Class<T> clazz){
        GeneralResponse<T> responseObject = new GeneralResponse<>();
        ResponseStatus responseStatus =
                new ResponseStatus(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage());
        responseObject.setStatus(responseStatus);
        responseObject.setData(clazz.cast(data));
        return ResponseEntity.ok(responseObject);
    }

    public ResponseEntity<GeneralResponse> success(){
        GeneralResponse<Object> responseObject = new GeneralResponse<>();
        ResponseStatus responseStatus =
                new ResponseStatus(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage());
        responseObject.setStatus(responseStatus);
        return ResponseEntity.ok(responseObject);
    }

    public ResponseEntity<GeneralResponse> error(String statusCode, String message, HttpStatus status){
        ResponseStatus responseStatus = new ResponseStatus(statusCode, message);
        GeneralResponse<Object> responseObject = new GeneralResponse<>();
        responseObject.setStatus(responseStatus);
        return new ResponseEntity<>(responseObject, status);
    }

    public ResponseEntity<GeneralResponse> buildErrorResponse(Exception exception, HttpStatus httpStatus){
        GeneralResponse generalResponse = new GeneralResponse();
        ResponseStatus responseStatus = new ResponseStatus(ResponseStatus.ERROR_CODE, exception.getClass().getName());
        generalResponse.setStatus(responseStatus);
        return ResponseEntity.status(httpStatus).body(generalResponse);
    }

    public ResponseEntity<GeneralResponse> buildErrorResponse(String message, HttpStatus httpStatus){
        GeneralResponse response = new GeneralResponse();
        ResponseStatus status = new ResponseStatus(ResponseStatus.ERROR_CODE, message);
        response.setStatus(status);
        return  ResponseEntity.status(httpStatus).body(response);
    }

}
