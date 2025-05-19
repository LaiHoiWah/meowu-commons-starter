package com.meowu.starter.commons.utils.adapter;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.Objects;

public class DateAdapter implements TypeAdapter<Date>{

    @Override
    public Class<Date> getType(){
        return Date.class;
    }

    @Override
    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext){
        return Objects.isNull(date) ? null : new JsonPrimitive(date.getTime());
    }

    @Override
    public Date deserialize(JsonElement element, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException{
        return Objects.isNull(element) ? null : new Date(element.getAsJsonPrimitive().getAsLong());
    }
}
