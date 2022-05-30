package com.example.storeapp.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.storeapp.R;
import com.example.storeapp.databinding.ActivityProductBinding;

public class ProductActivity extends AppCompatActivity {

    NavController navController;
    private NavHostFragment navHostFragment;
    private NavInflater inflater;
    private NavGraph navGraph;
    ActivityProductBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
         navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.frag_host_pro);
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController);
    }



}