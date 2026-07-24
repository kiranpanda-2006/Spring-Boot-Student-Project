package com.kiran.Enums;

public enum CourseEnum {

    BTECH;

    public static CourseEnum fromValue(String value){
        return CourseEnum.valueOf(value.toUpperCase());
    }
}