package com.moblor.http.builder;

import android.net.Uri;

import com.moblor.http.request.GetRequest;
import com.moblor.http.request.OKHttpRequest;
import com.moblor.tools.StringUtil;

import java.util.Map;
import java.util.Set;

/**
 * @author Oliver.Lau
 * @version 2.0
 * @data 2017-01-13
 */
public class GetRequestBuilder extends OKHttpRequestBuilder<GetRequestBuilder> {
    @Override
    public OKHttpRequest build() {
        if(params!=null){
            url=appendParams(url,params);
        }
       return new GetRequest(url,params,headers,tag);
    }

    private String appendParams(String url, Map<String, String> params) {
        if(StringUtil.isEmpty(url)||params==null||params.isEmpty()){
            return url;
        }
        Uri.Builder builder=Uri.parse(url).buildUpon();
        Set<String> keys=params.keySet();
        for (String key : keys) {
            builder.appendQueryParameter(key, params.get(key));
        }
        return builder.build().toString();
    }
}
