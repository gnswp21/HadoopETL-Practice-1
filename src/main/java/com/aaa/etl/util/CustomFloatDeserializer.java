package com.aaa.etl.util;





import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class CustomFloatDeserializer extends JsonDeserializer<Float> {
    @Override
    public Float deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String floatString = p.getText();
        if(floatString.equals(".")){
            return null;
        }
        return Float.valueOf(floatString);
    }
}
