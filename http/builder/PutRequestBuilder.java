package com.moblor.http.builder;

import com.moblor.http.request.OKHttpRequest;
import com.moblor.http.request.PutRequest;

/**
 * @author Oliver.Lau
 * @version 2.0
 * @data 2017-01-12
 */
public class PutRequestBuilder extends BodyRequestBuilder<PutRequestBuilder> {
    @Override
    public OKHttpRequest builder() {
        return new PutRequest(url,params,headers,content,type,tag);
    }
}
