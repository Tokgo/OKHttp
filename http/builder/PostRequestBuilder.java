package com.moblor.http.builder;

import com.moblor.http.request.OKHttpRequest;
import com.moblor.http.request.PostRequest;
/**
 * @author Oliver.Lau
 * @version 2.0
 * @data 2017-01-13
 */
public class PostRequestBuilder extends BodyRequestBuilder<PostRequestBuilder> {

    @Override
    public OKHttpRequest builder() {
        return new PostRequest(url,params,headers,content,type,tag);
    }
}
