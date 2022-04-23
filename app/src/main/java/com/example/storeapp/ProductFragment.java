package com.example.storeapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class ProductFragment extends Fragment {

    private  RecyclerView productRecyclerView;
    private ProductRecyclerViewAdapter productRecyclerViewAdapter;
    private GetDataFromApi getDataFromApi;
    public ProductFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_product, container, false);

    }
    void init(View view){
        getDataFromApi =new GetDataFromApi();
        productRecyclerView = view.findViewById(R.id.Product_Rec);
        productRecyclerViewAdapter =new ProductRecyclerViewAdapter(,);
    }
}