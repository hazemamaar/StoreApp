package com.example.storeapp.data.network;

import com.example.storeapp.uitils.C;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnection {
    final static Retrofit retrofit = new Retrofit.Builder().baseUrl(C.BASEURL)
           .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create())
            .build();

    public static RetrofitService getRetrofit() {
       return retrofit.create(RetrofitService.class);
    }
}
