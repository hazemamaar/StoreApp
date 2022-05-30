package com.example.storeapp.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class FavoritesViewModel extends ViewModel {
    MutableLiveData<List<ProductsViewModel>>mutableLiveData=new MutableLiveData<>();
    LiveData<List<ProductsViewModel>>liveData=mutableLiveData;

}
