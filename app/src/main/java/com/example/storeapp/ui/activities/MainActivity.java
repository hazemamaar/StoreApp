
package com.example.storeapp.ui.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storeapp.databinding.ActivityMainBinding;
import com.example.storeapp.uitils.AppStatus;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
     ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (AppStatus.getInstance(this).isOnline()) {

            Toast.makeText(this,"You are online!!!!", Toast.LENGTH_LONG).show();

        } else {

            Toast.makeText(this,"You are offline!!!!", Toast.LENGTH_LONG).show();
            Log.v("Home", "############################You are not online!!!!");
        }

    }
}