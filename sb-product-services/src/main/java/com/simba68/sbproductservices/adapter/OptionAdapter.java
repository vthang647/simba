package com.simba68.sbproductservices.adapter;

import com.simba68.sbproductservices.constant.OptionRequestCode;

import java.util.HashMap;
import java.util.Map;

public class OptionAdapter {

    public static String checkRequestType(String option){
        for (OptionRequestCode optionRequest: OptionRequestCode.values()){
            if (optionRequest.getValue().equals(option)){
                return optionRequest.getValue();
            }
        }
        return null;
    }

    public static Map<String, OptionRequestCode> convertEnumToMap(){
        Map<String, OptionRequestCode> map = new HashMap<>();
        for (OptionRequestCode optionRequest: OptionRequestCode.values()){
            map.put(optionRequest.getValue(), optionRequest);
        }
        return map;
    }

}
