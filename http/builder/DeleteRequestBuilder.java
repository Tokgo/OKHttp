package com.moblor.http.builder;

import com.moblor.http.request.DeleteRequest;
import com.moblor.http.request.OKHttpRequest;

/**
 * @author Oliver.Lau
 * @version 2.0
 * @data 2017-01-12
 */
public class DeleteRequestBuilder extends BodyRequestBuilder<DeleteRequestBuilder> {
    @Override
    public OKHttpRequest builder() {
        return new DeleteRequest(url, params, headers, content, type, tag);
    }
}
