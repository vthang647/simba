package com.simba68.sbusersservices.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {
    SUCCESS("0000","SUCCESS");

    private String code;
    private String message;

    @Override
    public String toString() {
        return "StatusCodeEnum{"+"code='"+code+'\'' + ", message='"+message+'\''+"}";
    }
}
