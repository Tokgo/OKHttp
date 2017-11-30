package com.moblor.http.builder;

import com.moblor.http.request.OKHttpRequest;
import com.moblor.http.request.PutFormRequest;

import java.util.Map;

/**
 * @author Oliver.Lau
 * @version 2.0
 * @data 2017-01-13
 */
public class PutFormRequestBuilder extends OKHttpRequestBuilder<PutFormRequestBuilder>{
    protected Map<String,String> content;
    @Override
    public OKHttpRequest build() {
        return new PutFormRequest(url,params,headers,content,tag);
    }
    public PutFormRequestBuilder content(Map<String,String> content){
        this.content=content;
        return this;
    }
}
