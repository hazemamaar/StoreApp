package com.example.storeapp.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.storeapp.model.ProductModel;
import com.example.storeapp.myrepo.DefualtRepo;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class ProductActivityViewModel extends ViewModel {

    MutableLiveData<Boolean> mutableLiveData =new MutableLiveData<>();
   public LiveData<Boolean>liveData=mutableLiveData;
   DefualtRepo defualtRepo;

   @Inject
    public ProductActivityViewModel(DefualtRepo defualtRepo) {
        this.defualtRepo = defualtRepo;
    }

    public ProductActivityViewModel(MutableLiveData<Boolean> mutableLiveData) {
        this.mutableLiveData = mutableLiveData;
    }

    public void postProduct(ProductModel productModel){
        defualtRepo.postProduct(productModel).observeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
         @Override
         public void onSubscribe(@NonNull Disposable d) {

         }

         @Override
         public void onComplete() {
             mutableLiveData.setValue(true);

         }

         @Override
         public void onError(@NonNull Throwable e) {

         }
     });

     }
}
