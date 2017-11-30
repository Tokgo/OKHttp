package com.moblor.http.request;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Oliver on 17/1/12.
 */

public class PostRequest extends BodyRequest {

    public PostRequest(String url, Map<String, String> params, Map<String, String> headers, String content, MediaType type, Object tag) {
        super(url,params,headers,content,type,tag);
    }

    @Override
    public Request build(RequestBody requestBody) {
        return builder.post(requestBody).build();
    }
}
