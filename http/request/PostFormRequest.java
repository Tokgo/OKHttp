package com.moblor.http.request;

import java.util.Map;

import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Oliver on 17/1/13.
 */

public class PostFormRequest extends FormRequest {

    protected Map<String, String> content;

    public PostFormRequest(String url, Map<String, String> params, Map<String, String> headers, Map<String, String> content, Object tag) {
        super(url, params, headers,content, tag);
//        this.content = content;
    }

//    @Override
//    public RequestBody buildRequestBody() {
//        return null;
//    }

    @Override
    public Request build(RequestBody requestBody) {
//        FormBody.Builder bodyBuilder = new FormBody.Builder();
//        if (content != null && !content.isEmpty()) {
//            Set<String> keys = content.keySet();
//            for (String key : keys) {
//                String value = content.get(key);
//                bodyBuilder.add(key, value);
//            }
//        }
//        FormBody body = bodyBuilder.build();
        return builder.post(buildBody()).build();
    }
}
