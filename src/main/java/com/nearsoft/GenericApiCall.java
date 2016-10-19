package com.nearsoft;

import java.util.HashMap;
import java.util.Map;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
/**
 * Created by xloeza on 10/18/16.
 */
public class GenericApiCall {
    private String baseUrl;
    private String userName;
    private String password;
    public GenericApiCall(String baseUrl, String userName, String password){
        this.baseUrl = baseUrl;
        this.userName = userName;
        this.password = password;
    }


    public String Request(HttpVerbs method, String endPoint, Map<String, String> headers, Map<String, String> parameters, Map<String, String> queryParameters, String body) throws Exception {
        String url = baseUrl + endPoint;



        ClientRequest req = new ClientRequest(url);


        if(parameters != null && !parameters.isEmpty())
        {
            parameters.entrySet().forEach((value)->req.queryParameter(value.getKey().toString(), value.getValue().toString()));
        }

        if(queryParameters != null && !queryParameters.isEmpty())
        {
            queryParameters.entrySet().forEach((value)->req.pathParameter(value.getKey().toString(), value.getValue().toString()));
        }

        if(headers != null && !headers.isEmpty())
        {
            headers.entrySet().forEach((value)->req.header(value.getKey().toString(), value.getValue().toString()));
        }


        ClientResponse<String> res = GetServiceResponse(method, req);

        return res.getEntity();
    }

    private ClientResponse<String> GetServiceResponse(HttpVerbs method, ClientRequest req) throws Exception {
        ClientResponse<String> res =null;
        switch (method) {
            case GET:
                res = req.get(String.class);
                break;
            case POST:
                res = req.post(String.class);
                break;
            case PUT:
                res = req.put(String.class);
                break;
            case DELETE:
                res = req.delete(String.class);
                break;
            case HEAD:
                res = req.head();
                break;
            case PATCH:
                res = req.httpMethod("PATCH");

        }
        return res;
    }


    public enum HttpVerbs{
        GET,
        POST,
        PUT,
        PATCH,
        DELETE,
        HEAD
    }
}
