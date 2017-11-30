package com.moblor.http.builder;

import com.moblor.http.request.OKHttpRequest;
import com.moblor.http.request.PostFormRequest;

import java.util.Map;

/**
 * @author Oliver.Lau
 * @version 2.0
 * @data 2017-01-13
 */
public class PostFormRequestBuilder extends OKHttpRequestBuilder<PostFormRequestBuilder>{

    protected Map<String,String> content;
    @Override
    public OKHttpRequest build() {
        return new PostFormRequest(url,params,headers,content,tag);
    }
    public PostFormRequestBuilder content(Map<String,String> content){
        this.content=content;
        return this;
    }
}
