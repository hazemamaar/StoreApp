package com.example.storeapp.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.storeapp.myrepo.AuthRepo;
import com.google.firebase.auth.FirebaseUser;

public class LoginViewModel extends AndroidViewModel {
    AuthRepo authRepo;
    MutableLiveData<FirebaseUser>userModelLiveData=new MutableLiveData<>();;
    public LoginViewModel(@NonNull Application application) {
        super(application);
        authRepo =new AuthRepo(application);
    }
    public void login(String email,String passwors){
        authRepo.login(email,passwors,userModelLiveData);
    }

    public MutableLiveData<FirebaseUser> getUserModelLiveData() {
        return userModelLiveData;
    }
}
