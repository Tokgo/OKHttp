package com.moblor.http.builder;

import com.moblor.http.request.DeleteFormRequest;
import com.moblor.http.request.OKHttpRequest;

import java.util.Map;

/**
 * @author Oliver.Lau
 * @version 2.0
 * @data 2017-01-12
 */
public class DeleteFormRequestBuilder extends OKHttpRequestBuilder<DeleteFormRequestBuilder> {

    protected Map<String,String> content;

    @Override
    public OKHttpRequest build() {
        return new DeleteFormRequest(url,params,headers,content,tag);
    }
    public DeleteFormRequestBuilder content(Map<String,String> content){
        this.content=content;
        return this;
    }
}
