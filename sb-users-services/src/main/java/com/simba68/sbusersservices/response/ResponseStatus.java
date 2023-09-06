package com.simba68.sbusersservices.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ResponseStatus implements Serializable {
    public static final long serialVersionUID = 1L;

    public static String SUCCESS_CODE="success";
    public static String SUCCESS_MESSAGE="Success";
    public static String ERROR_CODE="error";

    @JsonProperty("code")
    private String code;
    @JsonProperty("message")
    private String message;

    public ResponseStatus(){

    }
    public ResponseStatus(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }
    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"code\":\"").append(code).append("\"");
        sb.append("\"message\":\"").append(message).append("\"");
        sb.append("}");
        return sb.toString();
    }
}
