package com.meowu.starter.commons.utils.adapter;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Date;

public class DateTypeAdapter implements TypeAdapter<Date>{

    public Class<Date> getType(){
        return Date.class;
    }

    @Override
    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext){
        return date == null ? null : new JsonPrimitive(date.getTime());
    }

    @Override
    public Date deserialize(JsonElement element, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException{
        return element == null ? null : new Date(element.getAsJsonPrimitive().getAsLong());
    }
}
