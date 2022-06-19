package com.example.storeapp.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.storeapp.model.ProductModel;
import com.example.storeapp.myrepo.DefualtRepo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;



@HiltViewModel
public class ProductsViewModel extends ViewModel  {

    DefualtRepo defualtRepo;
    MutableLiveData<List<ProductModel>> productMutableLiveData=new MutableLiveData<>();
   public LiveData<List<ProductModel>>productLiveData=productMutableLiveData;

    @Inject
    public ProductsViewModel(DefualtRepo defualtRepo) {
        this.defualtRepo = defualtRepo;
    }

    public void getAllProducts(){
        defualtRepo.getAllProducts2().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<ProductModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<ProductModel> productModels) {

             productMutableLiveData.setValue(productModels);
                Log.i("succ", "onError: ");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i("error", "onError: "+e.getLocalizedMessage());
                productMutableLiveData.setValue(new ArrayList<ProductModel>());

            }

            @Override
            public void onComplete() {

            }
        });
//        defualtRepo.getAllProducts().enqueue(new Callback<List<ProductModel>>() {
//            @Override
//            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
//                mutableLiveData.setValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
//
//            }
//        });
    }

}
