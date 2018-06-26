package com.cysion.simple.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by cysion on 2018\6\25 0025.
 */

public class Caller2 {
    private Retrofit mRetrofit;
    private OkHttpClient mOkHttpClient;
    private static volatile Caller2 instance;

    private Caller2() {
        Retrofit.Builder reBuilder = Caller.obj().getReBuilder();
        OkHttpClient.Builder okBuilder = Caller.obj().getOkBuilder();
        mOkHttpClient = okBuilder.build();
        mRetrofit = reBuilder.client(mOkHttpClient).build();
    }

    public static synchronized Caller2 obj() {
        if (instance == null) {
            instance = new Caller2();
        }
        return instance;
    }

    public <T> T create(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }

}
