package com.example.storeapp.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.storeapp.myrepo.DefualtRepo;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class CategoriesViewModel extends ViewModel {
    MutableLiveData<List<String>> categoryMutableLiveData=new MutableLiveData<>();
    public LiveData<List<String>>categoryLiveData=categoryMutableLiveData;
    DefualtRepo defualtRepo;

    @Inject
    public CategoriesViewModel(DefualtRepo defualtRepo) {
        this.defualtRepo = defualtRepo;
    }

    public void getCategories(){
        defualtRepo.getCategories().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<String>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<String> strings) {
                        categoryMutableLiveData.setValue(strings);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i("hazooom", "onError: "+e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
