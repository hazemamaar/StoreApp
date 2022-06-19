package com.example.storeapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.storeapp.databinding.FragmentShowCompleteProductBinding;
import com.example.storeapp.model.ProductModel;
import com.squareup.picasso.Picasso;

public class ShowCompleteProduct extends Fragment  {

   private ProductModel model;
   private FragmentShowCompleteProductBinding binding;



    public ShowCompleteProduct() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ShowCompleteProductArgs argrs=ShowCompleteProductArgs.fromBundle(getArguments());
        model =argrs.getProductModel();
        Picasso.get().load(model.getImage()).into(binding.productimg);
        binding.txtCategory.setText(model.getCategory());
        binding.ratingBar.setRating(4.5f);
        binding.txtTitle.setText(model.getTitle());
        binding.txtDec.setText(model.getDescription());
        binding.ratingBar.setEnabled(false);
        binding.ratingBar.setRating(model.getRating().getRate().floatValue());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =FragmentShowCompleteProductBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }


}