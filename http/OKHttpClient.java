package com.moblor.http;

import android.util.Log;

import com.moblor.http.builder.BodyRequestBuilder;
import com.moblor.http.builder.DeleteFormRequestBuilder;
import com.moblor.http.builder.DeleteRequestBuilder;
import com.moblor.http.builder.GetRequestBuilder;
import com.moblor.http.builder.OKHttpRequestBuilder;
import com.moblor.http.builder.PatchRequestBuilder;
import com.moblor.http.builder.PostFormRequestBuilder;
import com.moblor.http.builder.PostRequestBuilder;
import com.moblor.http.builder.PutFormRequestBuilder;
import com.moblor.http.builder.PutRequestBuilder;
import com.moblor.http.callback.CallBack;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * @author Oliver.Lau
 * @version 2.1.2
 * @data 2016-12-30
 */
public class OKHttpClient {
    public static OkHttpClient instance;
    private static OKHttpClient okHttpClient;

//    public static void init() {
//        OkHttpClient.Builder builder = new OkHttpClient.Builder()
//                .connectTimeout(30, TimeUnit.SECONDS)
//                .writeTimeout(30, TimeUnit.SECONDS)
//                .readTimeout(30, TimeUnit.SECONDS)
//                .hostnameVerifier(new HostnameVerifier() {//SSLSocketFactory代码设置，用于解决5.0以下TLS1.1和TLS1.2关闭问题
//                    @Override
//                    public boolean verify(String hostname, SSLSession session) {
//                        return true;
//                    }
//                });
//        SSLContext sslContext = null;
//        try {
//            sslContext = SSLContext.getInstance("TLS");
//            try {
//                sslContext.init(null, null, null);
//            } catch (KeyManagementException e) {
//                e.printStackTrace();
//            }
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        SSLSocketFactory socketFactory = new TLS12SocketFactory(sslContext.getSocketFactory());
//        builder.sslSocketFactory(socketFactory, new TLSSupperSocketFactory.UnSafeTrustManager());
//        instance = builder.build();
//    }

    private OKHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .hostnameVerifier(new HostnameVerifier() {//SSLSocketFactory代码设置，用于解决5.0以下TLS1.1和TLS1.2关闭问题
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                });
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("TLS");
            try {
                sslContext.init(null, null, null);
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SSLSocketFactory socketFactory = new TLS12SocketFactory(sslContext.getSocketFactory());
        builder.sslSocketFactory(socketFactory, new TLSSupperSocketFactory.UnSafeTrustManager());
        instance = builder.build();
    }

    public static OKHttpClient getInstance() {
        if (okHttpClient == null) {
            synchronized (OKHttpClient.class) {
                if (okHttpClient == null) {
                    okHttpClient = new OKHttpClient();
                }
            }
        }
        return okHttpClient;
    }

    public OkHttpClient getOkHttpClient(){
        return instance;
    }

    public OKHttpRequestBuilder<GetRequestBuilder> get(){
        return new GetRequestBuilder();
    }

    public BodyRequestBuilder<PostRequestBuilder> post(){
        return new PostRequestBuilder();
    }

    public OKHttpRequestBuilder<PostFormRequestBuilder> postForm(){
        return new PostFormRequestBuilder();
    }

    public OKHttpRequestBuilder<PutFormRequestBuilder> putForm(){
        return new PutFormRequestBuilder();
    }

    public OKHttpRequestBuilder<DeleteFormRequestBuilder> deleteForm() {
        return new DeleteFormRequestBuilder();
    }
    public BodyRequestBuilder<PatchRequestBuilder> patch(){
        return new PatchRequestBuilder();
    }

    public BodyRequestBuilder<PutRequestBuilder> put(){
        return new PutRequestBuilder();
    }

    public BodyRequestBuilder<DeleteRequestBuilder> delete(){
        return new DeleteRequestBuilder();
    }
    public void execute(Call call, final CallBack callBack){
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if(callBack==null)
                 return;
                callBack.onError(call,e);
            }

            @Override
            public void onResponse(Call call, Response response){
                try {
                    if(call.isCanceled()){
                        Log.i("OKHttpClient_onResponse","Call is canceled!");
                    }
                    if(callBack.isSuccessful(response)){
                        callBack.onSuccess(call,response);
                    }else{
                        callBack.onFailure(call,response);
                    }
                } catch (IOException e) {
                    Log.w("OKHttpClient_onResponse","IOException");
                    callBack.onError(call,e);
                    e.printStackTrace();
                }
            }
        });
    }

    public void cancelRequest(Object tag){
        for (Call call : instance.dispatcher().queuedCalls()) {
            if (tag.equals(call.request().tag())) {
                call.cancel();
            }
        }
        for (Call call : instance.dispatcher().runningCalls()) {
            if (tag.equals(call.request().tag())) {
                call.cancel();
            }
        }
    }


}
