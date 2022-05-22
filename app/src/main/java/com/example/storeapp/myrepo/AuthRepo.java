package com.example.storeapp.myrepo;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.storeapp.data.network.FirebaseConnect;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

public class AuthRepo {

    Application application;
    public AuthRepo(Application application) {
        this.application = application;
    }
    public void registerWithFirebase(String email, String password,MutableLiveData<FirebaseUser>mutableLiveData){
        FirebaseConnect.firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(application.getMainExecutor(),new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                 mutableLiveData.postValue(FirebaseConnect.firebaseAuth.getCurrentUser());

                }else {
                    Toast.makeText(application, "Registration Failed "+ task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void login(String email,String password,MutableLiveData<FirebaseUser> usermutableLiveData){
        FirebaseConnect.firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(application.getMainExecutor(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    usermutableLiveData.postValue(FirebaseConnect.firebaseAuth.getCurrentUser());
                }else {
                    Toast.makeText(application, "Login Failed"+task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
