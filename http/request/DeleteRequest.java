package com.moblor.http.request;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Oliver on 17/1/17.
 */

public class DeleteRequest extends BodyRequest {
    public DeleteRequest(String url, Map<String, String> params, Map<String, String> headers, String content, MediaType type, Object tag) {
        super(url, params, headers, content, type, tag);
    }

    @Override
    public Request build(RequestBody requestBody) {
        return builder.delete(requestBody).build();
    }
}
