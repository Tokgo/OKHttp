package com.moblor.http.call;

import com.moblor.http.OKHttpClient;
import com.moblor.http.callback.CallBack;

import okhttp3.Call;
import okhttp3.Request;

/**
 * @author Oliver.Lau
 * @version 2.0
 * @data 2017-01-11
 */
public class RequestCall {
    protected Request request;
    protected Call call;
    protected CallBack callBack;

    public RequestCall(Request request, CallBack callBack) {
        this.request = request;
        this.callBack=callBack;
        startCall();
    }

    private void startCall() {
        call = OKHttpClient.getInstance().getOkHttpClient().newCall(request);
        if(callBack!=null)
            callBack.onBefore();
        OKHttpClient.getInstance().execute(call,callBack);
    }

    public void cancelRequest(){
        if(call!=null)
            call.cancel();
    }
}
