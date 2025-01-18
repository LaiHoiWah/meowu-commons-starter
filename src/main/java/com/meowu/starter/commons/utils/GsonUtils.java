package com.meowu.starter.commons.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;
import com.meowu.starter.commons.utils.adapter.DateTypeAdapter;
import com.meowu.starter.commons.utils.adapter.TypeAdapter;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Objects;

public class GsonUtils{

    private final static Gson DEFAULT_GSON = getBuilder().create();

    private GsonUtils(){
        throw new IllegalStateException("Instantiation is not allowed");
    }

    public static String toJson(Object object){
        return DEFAULT_GSON.toJson(object);
    }

    public static <T> T fromJson(String json, Class<T> classOf){
        return DEFAULT_GSON.fromJson(json, classOf);
    }

    public static GsonBuilder getBuilder(){
        return getBuilder(true, true, new DateTypeAdapter());
    }

    public static GsonBuilder getBuilder(boolean serializeNulls, boolean disableHtmlEscaping, TypeAdapter<?>... adapters){
        GsonBuilder builder = new GsonBuilder();
        builder.setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE);

        if(serializeNulls){
            builder.serializeNulls();
        }
        if(disableHtmlEscaping){
            builder.disableHtmlEscaping();
        }
        if(ArrayUtils.isNotEmpty(adapters)){
            Arrays.stream(adapters)
                  .filter(Objects::nonNull)
                  .forEach(adapter -> builder.registerTypeAdapter(adapter.getType(), adapter));
        }

        return builder;
    }
}
