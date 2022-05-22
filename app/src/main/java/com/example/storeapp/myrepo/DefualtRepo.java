package com.example.storeapp.myrepo;

import com.example.storeapp.data.network.RetrofitConnection;
import com.example.storeapp.data.network.RetrofitService;
import com.example.storeapp.model.ProductModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class DefualtRepo {
 RetrofitService retrofitService;

    public DefualtRepo() {
        this.retrofitService = RetrofitConnection.getRetrofit();
    }

    public Observable<List<ProductModel>> getAllProducts() {
       return retrofitService.getProducts();
    }
}
