package com.example.storeapp.data.network;

import com.example.storeapp.model.ProductModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {

    @GET("products")
    Observable<List<ProductModel>> getProducts();

    @GET("products/category/{category}")
    Call<List<ProductModel>> getCategory( @Path("category") String category );

    @GET("products/categories")
     Call<List<String>> getCategoryName();

}
