package com.example.storeapp.di;

import android.content.Context;

import androidx.room.Room;

import com.example.storeapp.data.local.ProductDatabase;
import com.example.storeapp.data.local.ProductsDao;
import com.example.storeapp.data.network.RetrofitService;
import com.example.storeapp.uitils.C;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class ModuleApp {

    @Provides
    @Singleton
    public static RetrofitService provideProduct() {
       return new Retrofit.Builder().baseUrl(C.BASEURL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).
                       addConverterFactory(GsonConverterFactory.create())
                .build().create(RetrofitService.class);

    }


    @Provides
    @Singleton
    public  static Context provideAppContext(@ApplicationContext Context context){
        return context;
    }


    @Provides
    @Singleton
    public static ProductDatabase provideProductDatabase(@ApplicationContext  Context context){
       return Room.databaseBuilder(context.getApplicationContext(),
                ProductDatabase.class,
                "product_DB").
                fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    public static ProductsDao provideRoomService(ProductDatabase db){
        return db.productsDao();
    }
}
