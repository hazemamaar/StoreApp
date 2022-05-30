package com.example.storeapp.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.storeapp.myrepo.DefualtRepo;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CategoriesViewModel extends ViewModel {
    MutableLiveData<List<String>> categoryMutableLiveData=new MutableLiveData<>();
    public LiveData<List<String>>categoryLiveData=categoryMutableLiveData;
    public void getCategories(DefualtRepo defualtRepo){

        defualtRepo.getCategories().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<String>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<String> strings) {
                        if(strings.size()==0){
                            categoryMutableLiveData.setValue(null);
                        }else
                        categoryMutableLiveData.setValue(strings);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
