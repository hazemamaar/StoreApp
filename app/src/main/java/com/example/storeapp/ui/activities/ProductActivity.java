package com.example.storeapp.ui.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.storeapp.R;
import com.example.storeapp.databinding.ActivityProductBinding;
import com.example.storeapp.ui.fragments.ProductDialog;

public class ProductActivity extends AppCompatActivity implements ProductDialog.HelperDialogListener {

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

        binding.fab.setOnClickListener(view -> {
            ProductDialog productDialog =new ProductDialog();
            productDialog.show(getSupportFragmentManager(),"Dialog");
        });
    }


    @Override
    public void getData(String title, String category, String des) {
        Toast.makeText(this, ""+title+category+des, Toast.LENGTH_SHORT).show();
    }
}