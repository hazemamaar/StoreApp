package com.example.storeapp.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.storeapp.model.ProductModelRoom;

@Database(entities = ProductModelRoom.class,version = 1)
public abstract class ProductDatabase extends RoomDatabase {
    private static ProductDatabase productDatabase;

    public abstract ProductsDao productsDao();
    public static synchronized ProductDatabase getInstance(Context context){
        if(productDatabase ==null){
            productDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    ProductDatabase.class,
                    "product_DB").
                    fallbackToDestructiveMigration()
                    .build();
        }

        return productDatabase;
    }
}
