package com.example.storeapp.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.storeapp.myrepo.AuthRepo;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationViewModel extends AndroidViewModel {
AuthRepo authRepo;
MutableLiveData<FirebaseUser>userModelMutableLiveData=new MutableLiveData<>();
LiveData<FirebaseUser>userModelLiveData=userModelMutableLiveData;

    public RegistrationViewModel(@NonNull Application application) {
        super(application);
       authRepo =new AuthRepo(application);
    }
   public void register(String email,String password){
        authRepo.registerWithFirebase(email,password,userModelMutableLiveData);
    }

    public MutableLiveData<FirebaseUser> getUserModelMutableLiveData() {
        return userModelMutableLiveData;
    }
}
