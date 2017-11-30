package com.moblor.http.request;

import java.util.Map;

import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Oliver on 17/6/14.
 */

public class DeleteFormRequest extends FormRequest {
    public DeleteFormRequest(String url, Map<String, String> params, Map<String, String> headers, Map<String, String> content, Object tag) {
        super(url, params, headers, content, tag);
    }

    @Override
    public Request build(RequestBody requestBody) {
        return builder.delete(buildBody()).build();
    }
}
