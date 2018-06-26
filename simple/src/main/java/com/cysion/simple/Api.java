package com.cysion.simple;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018\6\26 0026.
 */

public interface Api {

    @GET("index")
    Call<String> getSimple();

    @GET("getxml")
    Call<String> getXml(@Query("code") int code);

    @FormUrlEncoded
    @POST("postme")
    Call<String> postSimple(@Field("from") String foo);

    @Headers({"Content-Type: application/xml", "Accept: application/json"})
    @POST("postxml")
    Call<String> postXml(@Body RequestBody aRequestBody);


}
