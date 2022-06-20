package com.example.storeapp.myrepo;

import com.example.storeapp.data.local.ProductsDao;
import com.example.storeapp.data.network.RetrofitService;
import com.example.storeapp.model.ProductModel;
import com.example.storeapp.model.ProductModelRoom;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

public class DefualtRepo {
 RetrofitService retrofitService;
ProductsDao productsDao;

     @Inject
    public DefualtRepo(RetrofitService retrofitService, ProductsDao productsDao) {
        this.retrofitService = retrofitService;
        this.productsDao=productsDao;
    }

    public Observable<List<ProductModel>> getAllProducts2() {
        return retrofitService.getProducts2();
    }
    public Observable<List<String>> getCategories(){
        return retrofitService.getCategoryName();
    }
    public Completable postProduct(ProductModel productModel){return retrofitService.postProduct(productModel);}

    public Completable insertProduct(ProductModelRoom productModelRoom){
         return productsDao.insert(productModelRoom);
    }
  public Observable<List<ProductModelRoom>> getProductFromDB(){
         return productsDao.getProductsFromRoom();
  }
  public Completable deleteProduct(Integer id){
         return productsDao.deleteProduct(id);
  }
}
