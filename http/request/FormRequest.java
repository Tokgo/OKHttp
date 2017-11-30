package com.moblor.http.request;

import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * Created by Oliver on 17/6/14.
 */

public abstract class FormRequest extends OKHttpRequest{

    protected Map<String, String> content;

    public FormRequest(String url, Map<String, String> params, Map<String, String> headers, Map<String, String> content, Object tag) {
        super(url, params, headers, tag);
        this.content = content;
    }

    @Override
    public RequestBody buildRequestBody() {
        return null;
    }
    public FormBody buildBody(){
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        if (content != null && !content.isEmpty()) {
            Set<String> keys = content.keySet();
            for (String key : keys) {
                String value = content.get(key);
                bodyBuilder.add(key, value);
            }
        }
        return bodyBuilder.build();
    }
}
