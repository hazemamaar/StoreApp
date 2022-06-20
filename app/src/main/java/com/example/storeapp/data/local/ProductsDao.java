package com.example.storeapp.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.storeapp.model.ProductModelRoom;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

@Dao
public interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(ProductModelRoom productModelRoom);


    @Query("select * from products_table")
    Observable<List<ProductModelRoom>> getProductsFromRoom();

    @Query("delete from products_table where id =:idproduct")
    public Completable deleteProduct(Integer idproduct);
}
