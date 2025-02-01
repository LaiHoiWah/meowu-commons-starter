package com.meowu.starter.commons.utils;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;

public class SpellUtils{

    public static String toCamel(String str){
        return StringUtils.isNotBlank(str) ? CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, str) : str;
    }

    public static String toUnderScore(String str){
        return StringUtils.isNotBlank(str) ? CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str) : str;
    }
}
