package com.example.storeapp.data.network;

import com.example.storeapp.model.ProductModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {


    @GET("products")
    Observable<List<ProductModel>> getProducts2();
    @GET("products/category/{category}")
    Observable<List<ProductModel>> getCategory( @Path("category") String category );

    @GET("products/categories")
     Observable<List<String>> getCategoryName();
    @POST("products")
    Observable<List<ProductModel>>postProduct(@Body ProductModel productModel);

}
