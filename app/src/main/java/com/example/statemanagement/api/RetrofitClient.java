package com.example.statemanagement.api;


import android.util.Log;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    private static final String TAG = "RetrofitClient";


    private static Retrofit getClient() {
        if (retrofit != null){
            return retrofit;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();


        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                .build();
    }

    public static ApiServices getApiServices() {
        return getClient().create(ApiServices.class);
    }
}
