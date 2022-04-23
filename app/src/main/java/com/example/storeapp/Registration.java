package com.example.storeapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;


public class Registration extends Fragment {


     private TextInputEditText userNameEditText,mobilePhoneEditText,passwordEditText,emailEditText;
     MaterialButton createButton;
    public Registration() {

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }
    void init(View view){
        userNameEditText=view.findViewById(R.id.inputTextUserName);
        emailEditText=view.findViewById(R.id.inputTextEmail);
        mobilePhoneEditText =view.findViewById(R.id.inputTextMobilePhone);
        passwordEditText=view.findViewById(R.id.inputTextPassword);
        createButton=view.findViewById(R.id.creatacctxt);
    }
}