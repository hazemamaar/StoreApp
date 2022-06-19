package com.example.storeapp.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.storeapp.data.local.ProductDatabase;
import com.example.storeapp.data.local.ProductsDao;
import com.example.storeapp.databinding.FragmentFavoritesBinding;
import com.example.storeapp.model.ProductModel;
import com.example.storeapp.model.ProductModelRoom;
import com.example.storeapp.ui.adapters.ProductRecyclerViewAdapter;
import com.example.storeapp.ui.communications.SelectListener;
import com.example.storeapp.ui.communications.UICommunicationProductAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;



@AndroidEntryPoint
public class FavoritesFragment extends Fragment implements UICommunicationProductAdapter, SelectListener {


    private ProductRecyclerViewAdapter productRecyclerViewAdapter;
    FragmentFavoritesBinding binding;
    ProductDatabase productDatabase;

    @Inject
    ProductsDao productsDao;
    public FavoritesFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productsDao.getProductsFromRoom().
                subscribeOn(Schedulers.computation()).
                observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ProductModelRoom>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }
                    @Override
                    public void onNext(@NonNull List<ProductModelRoom> productModels) {
                        binding.spinKit.setVisibility(View.GONE);
                        setUpRecyclerView(productModels, getContext());
                    }
                    @Override
                    public void onError(@NonNull Throwable e) {
                    }
                    @Override
                    public void onComplete() {

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

        productsDao.insert(productModelRoom).subscribeOn(Schedulers.computation()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                Log.i("HAZEM", "onError: " + e.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onItemClick(ProductModel productModel) {
        Toast.makeText(getContext(), ""+productModel.getId(), Toast.LENGTH_SHORT).show();
    }
}