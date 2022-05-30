package com.example.storeapp.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeapp.R;

import java.util.List;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.RecyclerViewHolder> {

    Context context;
    List<String> categoryList;
     int []photos={
       R.drawable.elec,
             R.drawable.jewelrystore,
             R.drawable.menclothing,
             R.drawable.womenclothing
     };
    public CategoryRecyclerViewAdapter(Context context, List<String> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new RecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.category_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        holder.categoryTxt.setText(categoryList.get(position).toString());
        holder.categoryImg.setImageResource(photos[position]);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView categoryTxt;
        ImageView categoryImg;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
categoryImg =itemView.findViewById(R.id.category_img);
categoryTxt=itemView.findViewById(R.id.txt_category);
        }
    }
}
