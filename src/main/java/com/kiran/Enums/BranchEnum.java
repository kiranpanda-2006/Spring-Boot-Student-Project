package com.kiran.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum BranchEnum {

    CSE,
    MECHANICAL,
    ELECTRICAL,
    CIVIL;

    @JsonCreator
    public static BranchEnum fromValue(String value){
        return BranchEnum.valueOf(value.toUpperCase());
    }
}
