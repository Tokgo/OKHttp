package com.moblor.http.request;

import java.util.Map;

import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Oliver on 17/1/11.
 */

public class GetRequest extends OKHttpRequest {

    public GetRequest(String url, Map<String, String> params, Map<String, String> headers, Object tag) {
        super(url, params, headers, tag);
    }

    @Override
    public RequestBody buildRequestBody() {
        return null;
    }

    @Override
    public Request build(RequestBody requestBody) {
        return builder.get().build();
    }
}
