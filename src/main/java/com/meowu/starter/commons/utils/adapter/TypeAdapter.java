package com.meowu.starter.commons.utils.adapter;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public interface TypeAdapter<T> extends JsonSerializer<T>, JsonDeserializer<T>{

    Type getType();
}
