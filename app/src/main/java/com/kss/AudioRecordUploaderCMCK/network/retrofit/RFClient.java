package com.kss.AudioRecordUploaderCMCK.network.retrofit;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

public class RFClient {

    public static Retrofit getClient(String BASE_URL) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.connectTimeout(100, TimeUnit.SECONDS);
        clientBuilder.readTimeout(100, TimeUnit.SECONDS);
        clientBuilder.addInterceptor(loggingInterceptor);



        Gson gson = new GsonBuilder().setLenient().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
        return new Retrofit.Builder().client(clientBuilder.build()).baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static Retrofit getClient(String BASE_URL, OkHttpClient okHttpClient) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();

        return new Retrofit.Builder().baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static Retrofit getClientWithStringResponse(String BASE_URL) {

        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(new ToStringConverterFactory())
                .build();
    }


}
