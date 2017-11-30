package com.moblor.http.request;

import com.moblor.http.PostType;
import com.moblor.tools.MoblorLog;

import org.json.JSONObject;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Oliver on 17/1/12.
 */

public abstract class BodyRequest extends OKHttpRequest {

    private String content;
    private MediaType type;
    public BodyRequest(String url, Map<String, String> params, Map<String, String> headers,String content,MediaType type, Object tag) {
        super(url, params, headers, tag);
        this.content = content;
        this.type = type;
    }

    @Override
    public RequestBody buildRequestBody() {
        MoblorLog.w("BodyRequest_buildRequestBody","type&content=>"+type+"||"+content);
        if (type == null||content==null)
            return RequestBody.create(PostType.TYPE_JSON, new JSONObject().toString());
        return RequestBody.create(type, content);
    }

    @Override
    public abstract Request build(RequestBody requestBody);
}
