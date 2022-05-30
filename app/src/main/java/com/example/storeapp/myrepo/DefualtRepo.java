package com.example.storeapp.myrepo;

import com.example.storeapp.data.local.ProductDatabase;
import com.example.storeapp.data.network.RetrofitConnection;
import com.example.storeapp.data.network.RetrofitService;
import com.example.storeapp.model.ProductModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class DefualtRepo {
 RetrofitService retrofitService;
 ProductDatabase productDatabase;
    public DefualtRepo() {
        this.retrofitService = RetrofitConnection.getRetrofit();
    }

    public Observable<List<ProductModel>> getAllProducts2() {
        return retrofitService.getProducts2();
    }
    public Observable<List<String>> getCategories(){
        return retrofitService.getCategoryName();
    }


}
