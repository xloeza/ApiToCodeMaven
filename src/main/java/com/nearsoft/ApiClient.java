package com.nearsoft;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xloeza on 10/18/16.
 */
public class ApiClient {
    public JavaInfo GetJavaInfo(String api_key) throws Exception {
        String baseUrl="https://api.nasa.gov";
        String endPoint="/planetary/apod";
        GenericApiCall.HttpVerbs method = GenericApiCall.HttpVerbs.GET;
        GenericApiCall apiCall = new GenericApiCall(baseUrl, "", "");
        String body = "";
        Map<String, String> headers = new HashMap<>();
        Map<String, String> parameters = new HashMap<>();
        Map<String, String> queryParameters = new HashMap<>();

        parameters.put("api_key", api_key);

        String json = apiCall.Request(method, endPoint, headers, parameters, queryParameters, body);


        JavaInfo res  = fromJsonToObject(json, JavaInfo.class);

        return res;
    }

    public static <T> T fromJsonToObject(String json, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }
}
