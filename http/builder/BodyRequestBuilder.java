package com.moblor.http.builder;

import com.moblor.http.request.OKHttpRequest;

import okhttp3.MediaType;

/**
 * @author Oliver.Lau
 * @version 2.0
 * @data 2017-01-12
 */
public abstract class BodyRequestBuilder<E extends BodyRequestBuilder> extends OKHttpRequestBuilder<E>{
    protected String content;
    protected MediaType type;
    @Override
    public OKHttpRequest build() {
        return builder();
    }

    public E content(String content){
        this.content=content;
        return (E)this;
    }

    public E mediaType(MediaType type){
        this.type=type;
        return (E)this;
    }
    public abstract OKHttpRequest builder();
}
