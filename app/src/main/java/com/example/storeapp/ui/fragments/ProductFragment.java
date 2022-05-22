package com.example.storeapp.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeapp.R;
import com.example.storeapp.data.network.RetrofitConnection;
import com.example.storeapp.model.ProductModel;
import com.example.storeapp.myrepo.DefualtRepo;
import com.example.storeapp.ui.adapters.ProductRecyclerViewAdapter;
import com.example.storeapp.ui.viewmodel.ProductsViewModel;
import com.github.ybq.android.spinkit.SpinKitView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProductFragment extends Fragment {

    private  RecyclerView productRecyclerView;
    private ProductRecyclerViewAdapter productRecyclerViewAdapter;
    List<ProductModel> productModelList=null;
    List<String> categoryList=null;
    SpinKitView spinKitView;
    ProductsViewModel productsViewModel;
    DefualtRepo defualtRepo;
    public ProductFragment() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        defualtRepo =new DefualtRepo();
        productsViewModel= new ViewModelProvider(this).get(ProductsViewModel.class);

        productsViewModel.getAllProducts(defualtRepo);
//        productsViewModel.liveData.observe(getActivity(), productModels ->
//                Toast.makeText(getContext(),"done"+productModels.size(),Toast.LENGTH_SHORT).show());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_product, container, false);

    }
    void init(View view){
        productRecyclerView = view.findViewById(R.id.Product_Rec);
        productModelList= new ArrayList<>();
        categoryList=new ArrayList<>();
        spinKitView=view.findViewById(R.id.spin_kit);
    }
    void setUpRecyclerView(List<ProductModel>productModelList, Context context){
        productRecyclerViewAdapter =new ProductRecyclerViewAdapter(context,productModelList);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        productRecyclerView.setAdapter(productRecyclerViewAdapter);

    }


//    public void getProducts(){
//        Call<List<ProductModel>>call= RetrofitConnection.getRetrofit().getProducts();
//        call.enqueue(new Callback<List<ProductModel>>() {
//            @Override
//            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
//                Log.i("ha", "aly onResponse: "+response.code());
//                if(response.isSuccessful()){
//                    productModelList=response.body();
//                    setUpRecyclerView(productModelList,getContext());
//                    Toast.makeText(getContext(),""+productModelList.size(),Toast.LENGTH_SHORT).show();
//                    if(productModelList.size()>0){
//                        spinKitView.setVisibility(View.GONE);
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
//                Toast.makeText(getContext(),"Check You",Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
    void getCategory(String category){
        Call<List<ProductModel>>call=RetrofitConnection.getRetrofit().getCategory(category);
        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {

            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
            }
        });
    }

    void getCategoryName(){
        Call<List<String>>call=RetrofitConnection.getRetrofit().getCategoryName();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                categoryList=response.body();
            setTextCategory(categoryList);

            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(getContext(),"fail",Toast.LENGTH_SHORT).show();
            }
        });
    }

    void setTextCategory(List<String> categoryList){
        if(categoryList.size()!=0){
            Toast.makeText(getContext(),"Done",Toast.LENGTH_SHORT).show();

        }

    }
}