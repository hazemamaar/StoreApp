package com.example.storeapp.ui.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.storeapp.R;


public class SplashScreen extends Fragment {


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public SplashScreen() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        sharedPreferences= getActivity().getSharedPreferences("logininfo", Context.MODE_PRIVATE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final NavController navController = Navigation.findNavController(view);
                String test=sharedPreferences.getString("Email",null);
                if(test==null){
                    navController.navigate(R.id.action_splashScreen_to_onBoarding);
                }else{
                    navController.navigate(R.id.action_splashScreen_to_productActivity);
                }


            }
        },2500);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash_screen, container, false);
    }

}