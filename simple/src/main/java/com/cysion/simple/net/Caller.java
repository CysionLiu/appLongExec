package com.cysion.simple.net;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by cysion on 2018\6\25 0025.
 * 使用前，必须调用init方法
 */

public class Caller {

    private OkHttpClient mOkHttpClient;
    private Retrofit mRetrofit;
    private Map<String, String> mHeaders;
    private static volatile Caller instance;

    public interface Injector {
        Map<String, String> headers();
    }

    private Caller() {

    }

    public OkHttpClient.Builder getOkBuilder() {
        return mOkHttpClient.newBuilder();
    }

    public Retrofit.Builder getReBuilder() {
        return mRetrofit.newBuilder();
    }


    public void init(String baseUrl, final Injector aInjector) {
        if (mOkHttpClient != null) {
            return;
        }
        mOkHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                mHeaders = aInjector.headers();
                if (mHeaders != null&&mHeaders.size()>0) {
                    Request.Builder builder = request.newBuilder();
                    Set<String> keys = mHeaders.keySet();
                    for (String key : keys) {
                        builder.addHeader(key, mHeaders.get(key));
                    }
                    request = builder.build();
                }
                return chain.proceed(request);
            }
        }).connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS).build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)//如果需要，在这添加factory
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(mOkHttpClient)
                .build();
    }

    public static synchronized Caller obj() {
        if (instance == null) {
            instance = new Caller();
        }
        return instance;
    }

    public <T> T load(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }
}
