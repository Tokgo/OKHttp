package com.moblor.http.request;

import com.moblor.http.call.RequestCall;
import com.moblor.http.callback.CallBack;
import com.moblor.tools.StringUtil;

import java.util.Map;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Oliver on 17/1/11.
 */

public abstract class OKHttpRequest{
    protected String url;
    protected Map<String,String> params;
    protected Map<String,String> headers;
    protected Object tag;
    protected Request.Builder builder=new Request.Builder();
    public OKHttpRequest(String url, Map<String,String> params,Map<String,String> headers,Object tag){
        this.url=url;
        this.params=params;
        this.headers=headers;
        this.tag=tag;
        if(StringUtil.isEmpty(url)){
            throw new IllegalArgumentException("Url  can't be null");
        }
        initBuilder();
    }

    private void initBuilder() {
        builder.url(url).tag(tag);
        addHeaders();
    }

    public abstract RequestBody buildRequestBody();

    private void addHeaders() {
        Headers.Builder headBuilder=new Headers.Builder();
        if(headers==null||headers.isEmpty())
            return;
        for(String key:headers.keySet()){
            headBuilder.add(key,headers.get(key));
        }
        builder.headers(headBuilder.build());
    }
    public abstract Request build(RequestBody requestBody);
    public RequestCall execute(CallBack callBack){
        Request request = build(buildRequestBody());
        return new RequestCall(request,callBack);
    }
}
