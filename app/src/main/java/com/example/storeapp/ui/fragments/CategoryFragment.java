package com.example.storeapp.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.storeapp.databinding.FragmentCategoryBinding;
import com.example.storeapp.myrepo.DefualtRepo;
import com.example.storeapp.ui.adapters.CategoryRecyclerViewAdapter;
import com.example.storeapp.ui.viewmodel.CategoriesViewModel;

import java.util.List;


public class CategoryFragment extends Fragment {

 FragmentCategoryBinding binding;
 CategoryRecyclerViewAdapter categoryRecyclerViewAdapter;
 DefualtRepo defualtRepo;
 CategoriesViewModel categoriesViewModel;
    public CategoryFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        categoriesViewModel.categoryLiveData.observe(getActivity(), strings -> {setUpRecyclerView(strings,getContext());
        binding.spinKit.setVisibility(View.GONE);});
    }

    void init(){
        defualtRepo =new DefualtRepo();
        categoriesViewModel= new ViewModelProvider(this).get(CategoriesViewModel.class);
        categoriesViewModel.getCategories(defualtRepo);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =FragmentCategoryBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
    public void setUpRecyclerView(List<String> categoryModelList, Context context){
       categoryRecyclerViewAdapter =new CategoryRecyclerViewAdapter(context,categoryModelList);
        binding.categoryRecyclerview.setLayoutManager(new LinearLayoutManager(context));
        binding.categoryRecyclerview.setAdapter(categoryRecyclerViewAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getFragmentManager().beginTransaction().remove(CategoryFragment.this).commitAllowingStateLoss();
    }
}