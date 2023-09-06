package com.simba68.sbproductservices.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OptionRequestCode {
    FIND_LIMIT_BY_NAME_ASC("name_asc"),
    FIND_LIMIT_BY_NAME_DESC("name_desc"),
    FIND_BY_ID("id"),
    FIND_LIMIT_BY_PRICE_IN_ASCENDING("price_asc"),
    FIND_LIMIT_BY_PRICE_IN_DESCENDING("price_desc"),
    FIND_LIMIT_BY_QUANTITY_IN_ASCENDING("quantity_asc"),
    FIND_LIMIT_BY_QUANTITY_IN_DESCENDING("quantity_desc"),
    FIND_LIMIT_BY_STATUS_IN_ASCENDING("quantity_asc"),
    FIND_LIMIT_BY_STATUS_IN_DESCENDING("quantity_desc"),
    FIND_LIMIT_BY_QUANTITY_AND_PRICE_IN_ASCENDING("quantity_and_price_asc"),
    FIND_LIMIT_BY_QUANTITY_AND_PRICE_IN_DESCENDING("quantity_and_price_desc"),
    FIND_LIMIT_BY_QUANTITY_ASC_AND_PRICE_DESC("quantity_asc_and_price_desc"),
    FIND_LIMIT_BY_QUANTITY_DESC_AND_PRICE_ASC("quantity_desc_and_price_asc");

    private String value;

}
