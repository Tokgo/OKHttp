package com.moblor.http.builder;

import com.moblor.http.request.OKHttpRequest;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Oliver.Lau
 * @version 2.0
 * @data 2017-01-12
 */
public abstract class OKHttpRequestBuilder<T extends OKHttpRequestBuilder> {

    //url
    protected String url;
    //参数
    protected Map<String,String> params;
    //头
    protected Map<String,String> headers;
    protected Object tag;
    public T url(String url){
        this.url=url;
        return (T)this;
    }
    public T params(Map<String,String> params){
        this.params=params;
        return (T)this;
    }

    public T addParams(String key,String value){
        if(this.params==null){
            params=new LinkedHashMap<>();
        }
        params.put(key,value);
        return (T)this;
    }
    public T headers(Map<String,String> headers){
        this.headers=headers;
        return (T)this;
    }

    public T tag(Object tag){
        this.tag=tag;
        return (T)this;
    }

    public T addHeaders(String key,String value){
        if(this.headers==null){
            headers=new LinkedHashMap<>();
        }
        headers.put(key,value);
        return (T)this;
    }
    public abstract OKHttpRequest build();
}
