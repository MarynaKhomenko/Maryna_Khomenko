package org.api;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UploadRequest extends RequestSender {
    public void upload() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        response = Unirest.post("https://content.dropboxapi.com/2/files/upload")
                .header("Dropbox-API-Arg", "{\"path\": \"/Test.txt\",\"mode\": \"add\",\"autorename\": true,\"mute\": false,\"strict_conflict\": false}")
                .header("Content-Type", "application/octet-stream")
                .header("Authorization", token)
                .asString();
    }
}
