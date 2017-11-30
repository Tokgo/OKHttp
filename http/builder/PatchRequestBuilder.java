package com.moblor.http.builder;

import com.moblor.http.request.OKHttpRequest;
import com.moblor.http.request.PatchRequest;

/**
 * @author Oliver.Lau
 * @version 2.0
 * @data 2017-01-12
 */
public class PatchRequestBuilder extends BodyRequestBuilder<PatchRequestBuilder> {
    @Override
    public OKHttpRequest builder() {
        return new PatchRequest(url,params,headers,content,type,tag);
    }
}
