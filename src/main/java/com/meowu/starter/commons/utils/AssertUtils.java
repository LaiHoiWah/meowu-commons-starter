package com.meowu.starter.commons.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class AssertUtils{

    private AssertUtils(){
        throw new IllegalStateException("Instantiation is not allowed");
    }

    public static void isNotNull(Object object, String message){
        if(Objects.isNull(object)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNotBlank(String str, String message){
        if(StringUtils.isBlank(str)){
            throw new IllegalArgumentException(message);
        }
    }
}
