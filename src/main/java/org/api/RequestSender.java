package org.api;


import com.mashape.unirest.http.HttpResponse;

public abstract class RequestSender {
    protected static final String token = "Bearer" + "insert token here";
    protected HttpResponse<String> response;

    public HttpResponse<String> getResponse(){
        return response;
    }
}
