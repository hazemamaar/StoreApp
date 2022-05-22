package com.example.storeapp.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.storeapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProductActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    NavController navController;
    private NavHostFragment navHostFragment;
    private NavInflater inflater;
    private NavGraph navGraph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
//        navController = Navigation.findNavController(this, R.id.frag_host_pro);
//      NavigationUI.setupWithNavController(bottomNavigationView, navController);
//        navHostFragment =
//                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.frag_host_pro);
//        inflater = navHostFragment.getNavController().getNavInflater();
//        navGraph = inflater.inflate(R.navigation.main_nav);
//        NavigationUI.setupWithNavController(bottomNavigationView, navController);
//        navHostFragment.getNavController().setGraph(navGraph);

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.frag_host_pro);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frag_host_pro,fragment);
        fragmentTransaction.commit();
    }

}