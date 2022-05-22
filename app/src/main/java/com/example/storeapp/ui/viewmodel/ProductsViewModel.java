package com.example.storeapp.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.storeapp.model.ProductModel;
import com.example.storeapp.myrepo.DefualtRepo;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ProductsViewModel extends ViewModel {

    MutableLiveData<List<ProductModel>> mutableLiveData=new MutableLiveData<>();
   public LiveData<List<ProductModel>>liveData=mutableLiveData;
    public void getAllProducts(DefualtRepo defualtRepo){
        defualtRepo.getAllProducts().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<List<ProductModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<ProductModel> productModels) {
              mutableLiveData.setValue(productModels);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i("err", "onError: "+e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

}
