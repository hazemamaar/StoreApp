package com.example.storeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.ProductViewHolder> {

    Context context;
    List<ProductModel> productList;

    public ProductRecyclerViewAdapter(Context context, List<ProductModel> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.product_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
       holder.priceTxt.setText(productList.get(position).getPrice().toString()+"$");
       holder.descTxt.setText(productList.get(position).getDescription());
       holder.heartImg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               holder.heartImg.setImageResource(R.drawable.redheart);
           }
       });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {
          ImageView heartImg,productImg;
          TextView categoryTxt,descTxt,priceTxt;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
           heartImg=itemView.findViewById(R.id.heartImg);
           productImg =itemView.findViewById(R.id.productimg);
           categoryTxt=itemView.findViewById(R.id.txt_category);
           descTxt=itemView.findViewById(R.id.txt_desc);
           priceTxt=itemView.findViewById(R.id.txt_desc);
        }
    }
}
