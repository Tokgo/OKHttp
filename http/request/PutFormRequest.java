package com.moblor.http.request;

import java.util.Map;

import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Oliver on 17/1/16.
 */

public class PutFormRequest extends FormRequest {

    protected Map<String, String> content;

    public PutFormRequest(String url, Map<String, String> params, Map<String, String> headers, Map<String, String> content, Object tag) {
        super(url, params, headers,content, tag);
//        this.content = content;
    }

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
        return builder.put(buildBody()).build();
    }
}
