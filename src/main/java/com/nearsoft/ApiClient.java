package com.nearsoft;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xloeza on 10/18/16.
 */
public class ApiClient {

    private static final String DEFAULT_URL = "https://api.nasa.gov";
    private static final String DEFAULT_END_POINT = "/planetary/apod";

    public JavaInfo GetJavaInfo(String api_key) throws Exception {
        HttpVerbs method = HttpVerbs.GET;
        GenericApiCall apiCall = new GenericApiCall(DEFAULT_URL, "", "");
        String body = "";
        Map<String, String> headers = new HashMap<>();
        Map<String, String> parameters = new HashMap<>();
        Map<String, String> queryParameters = new HashMap<>();

        parameters.put("api_key", api_key);

        String json = apiCall.Request(method, DEFAULT_END_POINT, headers, parameters, queryParameters, body);


        JavaInfo res = JsonUtil.fromJsonToObject(json, JavaInfo.class);

        return res;
    }

}
