package com.moblor.http.callback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;
/**
 * @author Oliver.Lau
 * @version 2.0
 * @data 2017-01-13
 */
public abstract class CallBack {
    public void onBefore(){}
    public abstract void onError(Call call, IOException e);
    public abstract void onSuccess(Call call, Response response) throws IOException;
    public abstract void onFailure(Call call,Response response) throws IOException;

    public boolean isSuccessful(Response response){
        return response.isSuccessful();
    }
}
