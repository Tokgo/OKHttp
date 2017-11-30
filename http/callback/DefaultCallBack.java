package com.moblor.http.callback;

import java.io.IOException;

import okhttp3.Call;

/**
 * @author Oliver.Lau
 * @version 2.0
 * @data 2017-01-13
 */
public interface DefaultCallBack  {
    void onFail(Call call, IOException e);
    void onSuccess();
}
