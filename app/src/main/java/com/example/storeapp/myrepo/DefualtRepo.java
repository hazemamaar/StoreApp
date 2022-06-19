package com.example.storeapp.myrepo;

import com.example.storeapp.data.network.RetrofitService;
import com.example.storeapp.model.ProductModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

public class DefualtRepo {
 RetrofitService retrofitService;


     @Inject
    public DefualtRepo(RetrofitService retrofitService) {
        this.retrofitService = retrofitService;
    }

    public Observable<List<ProductModel>> getAllProducts2() {
        return retrofitService.getProducts2();
    }
    public Observable<List<String>> getCategories(){
        return retrofitService.getCategoryName();
    }
    public Completable postProduct(ProductModel productModel){return retrofitService.postProduct(productModel);}
}
