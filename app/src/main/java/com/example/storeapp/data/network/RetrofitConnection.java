package com.example.storeapp.data.network;

import com.example.storeapp.uitils.C;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnection {
    final static Retrofit retrofit = new Retrofit.Builder().baseUrl(C.BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
    public static RetrofitService getRetrofit() {
       return retrofit.create(RetrofitService.class);
    }
}
