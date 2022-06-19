package com.example.storeapp.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.storeapp.R;
import com.example.storeapp.databinding.ActivityProductBinding;
import com.example.storeapp.ui.fragments.ProductDialog;
import com.example.storeapp.ui.viewmodel.ProductActivityViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ProductActivity extends AppCompatActivity  {

    NavController navController;
    private NavHostFragment navHostFragment;

    ActivityProductBinding binding;
    ProductActivityViewModel productActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        productActivityViewModel = new ViewModelProvider(this).get(ProductActivityViewModel.class);
         navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.frag_host_pro);
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController);

        binding.fab.setOnClickListener(view -> {
            ProductDialog productDialog =new ProductDialog();
            productDialog.show(getSupportFragmentManager(),"      Dialog");
        });
    }


//    @Override
//    public void getData(String title, String category, String des) {
//        productActivityViewModel.postProduct(repo,new ProductModel(null, title,
//                null, des, category,null,null));
//        productActivityViewModel.liveData.observe(ProductActivity.this, new Observer<Boolean>() {
//            @Override
//            public void onChanged(Boolean aBoolean) {
//                Toast.makeText(ProductActivity.this, "Product Pushed", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}