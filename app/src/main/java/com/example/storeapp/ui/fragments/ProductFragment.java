package com.example.storeapp.ui.fragments;

import static androidx.navigation.Navigation.findNavController;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.storeapp.databinding.FragmentProductBinding;
import com.example.storeapp.model.ProductModel;
import com.example.storeapp.model.ProductModelRoom;
import com.example.storeapp.ui.adapters.ProductRecyclerViewAdapter;
import com.example.storeapp.ui.communications.SelectListener;
import com.example.storeapp.ui.communications.UICommunicationProductAdapter;
import com.example.storeapp.ui.viewmodel.ProductsViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ProductFragment extends Fragment implements UICommunicationProductAdapter, SelectListener {

    private ProductRecyclerViewAdapter productRecyclerViewAdapter;
    ProductsViewModel productsViewModel;

    FragmentProductBinding binding;


    public ProductFragment() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        productsViewModel.productLiveData.observe(getActivity(), productModels -> {
            binding.spinKit.setVisibility(View.GONE);
            setUpRecyclerView(productModels, getContext());
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProductBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    void init() {
        productsViewModel = new ViewModelProvider(this).get(ProductsViewModel.class);
        productsViewModel.getAllProducts();
    }

    void setUpRecyclerView(List<ProductModel> productModelList, Context context) {

        productRecyclerViewAdapter = new ProductRecyclerViewAdapter(context, productModelList, this, this);
        binding.ProductRec.setLayoutManager(new LinearLayoutManager(context));
        binding.ProductRec.setAdapter(productRecyclerViewAdapter);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onFavClicked(ProductModel productModel) {
        ProductModelRoom productModelRoom = new ProductModelRoom(productModel.getId(), productModel.getTitle(),
                productModel.getPrice(), productModel.getDescription(), productModel.getCategory(), productModel.getImage());
        productsViewModel.insertProduct(productModelRoom);
    }


    @Override
    public void onItemClick(ProductModel productModel) {
        ProductFragmentDirections.ActionHomeFragToShowCompleteProduct action =
                ProductFragmentDirections.actionHomeFragToShowCompleteProduct(productModel);
                 findNavController(getView()).navigate((NavDirections) action);
    }
}