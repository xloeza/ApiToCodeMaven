package com.nearsoft;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by xloeza on 10/20/16.
 */
public class JsonUtil {
    public static <T> T fromJsonToObject(String json, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }
}
