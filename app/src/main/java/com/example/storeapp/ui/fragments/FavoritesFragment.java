package com.example.storeapp.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.storeapp.data.local.ProductDatabase;
import com.example.storeapp.data.local.ProductsDao;
import com.example.storeapp.databinding.FragmentFavoritesBinding;
import com.example.storeapp.model.ProductModel;
import com.example.storeapp.model.ProductModelRoom;
import com.example.storeapp.ui.adapters.ProductRecyclerViewAdapter;
import com.example.storeapp.ui.communications.SelectListener;
import com.example.storeapp.ui.communications.UICommunicationProductAdapter;
import com.example.storeapp.ui.viewmodel.FavoritesViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;



@AndroidEntryPoint
public class FavoritesFragment extends Fragment implements UICommunicationProductAdapter, SelectListener {


    private ProductRecyclerViewAdapter productRecyclerViewAdapter;
    FragmentFavoritesBinding binding;
    ProductDatabase productDatabase;
    FavoritesViewModel favoritesViewModel;
    @Inject
    ProductsDao productsDao;
    public FavoritesFragment() {

    }

    @Override
    public void onViewCreated(@androidx.annotation.NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        favoritesViewModel = new ViewModelProvider(this).get(FavoritesViewModel.class);
        favoritesViewModel.getProductFromRoom();
        favoritesViewModel.liveData.observe(getActivity(), new androidx.lifecycle.Observer<List<ProductModelRoom>>() {
            @Override
            public void onChanged(List<ProductModelRoom> productModelRooms) {
                binding.spinKit.setVisibility(View.GONE);
                setUpRecyclerView(productModelRooms, getContext());
            }
        });
    }


    void setUpRecyclerView(List<ProductModelRoom> productModelList, Context context) {
        ArrayList<ProductModel> productModels = new ArrayList<>();
        productModelList.forEach(new Consumer<ProductModelRoom>() {

            @Override
            public void accept(ProductModelRoom productModelRoom) {
                productModels.add(new ProductModel(productModelRoom.getId(), productModelRoom.getTitle(),
                        productModelRoom.getPrice(), productModelRoom.getDescription(), productModelRoom.getCategory(),
                        productModelRoom.getImage()));
            }

            @Override
            public Consumer<ProductModelRoom> andThen(Consumer<? super ProductModelRoom> after) {
                return Consumer.super.andThen(after);
            }
        });
        Log.i("HAZEM", "setUpRecyclerView: ");
        productRecyclerViewAdapter = new ProductRecyclerViewAdapter(context, productModels, this,this);
        binding.ProductRec.setLayoutManager(new LinearLayoutManager(context));
        binding.ProductRec.setAdapter(productRecyclerViewAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onFavClicked(ProductModel productModel) {
        ProductModelRoom productModelRoom = new ProductModelRoom(productModel.getId(), productModel.getTitle(),
                productModel.getPrice(), productModel.getDescription(), productModel.getCategory(), productModel.getImage());
           favoritesViewModel.deleteProduct(productModelRoom.getId());


//        productsDao.insert(productModelRoom).subscribeOn(Schedulers.computation()).subscribe(new CompletableObserver() {
//            @Override
//            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//
//            @Override
//            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
//                Log.i("HAZEM", "onError: " + e.getLocalizedMessage());
//            }
//        });
    }

    @Override
    public void onItemClick(ProductModel productModel) {

    }
}