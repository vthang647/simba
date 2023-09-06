package com.simba68.sbproductservices.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class GeneralResponse<T>  implements Serializable {
    public static final long serialVersionUID = 1L;

    @JsonProperty("status")
    private ResponseStatus status;

    @JsonProperty("data")
    private T data;
}
