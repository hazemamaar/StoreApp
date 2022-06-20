package com.example.storeapp.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.storeapp.model.ProductModelRoom;
import com.example.storeapp.myrepo.DefualtRepo;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class FavoritesViewModel extends ViewModel {
    private MutableLiveData<List<ProductModelRoom>>mutableLiveData=new MutableLiveData<>();
    public LiveData<List<ProductModelRoom>>liveData=mutableLiveData;
      DefualtRepo defualtRepo;

      @Inject
    public FavoritesViewModel(DefualtRepo defualtRepo) {
        this.defualtRepo = defualtRepo;
    }

  public  void getProductFromRoom(){
          defualtRepo.getProductFromDB().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<ProductModelRoom>>() {
              @Override
              public void onSubscribe(@NonNull Disposable d) {

              }

              @Override
              public void onNext(@NonNull List<ProductModelRoom> productModelRooms) {
                    mutableLiveData.setValue(productModelRooms);
              }

              @Override
              public void onError(@NonNull Throwable e) {
                  Log.i("gmgmgm", "onError: "+e.getLocalizedMessage());
              }

              @Override
              public void onComplete() {

              }
          });
  }
  public void deleteProduct(Integer id){
          defualtRepo.deleteProduct(id).subscribeOn(Schedulers.computation()).subscribe(new CompletableObserver() {
              @Override
              public void onSubscribe(@NonNull Disposable d) {

              }

              @Override
              public void onComplete() {

              }

              @Override
              public void onError(@NonNull Throwable e) {

              }
          });
  }
}
