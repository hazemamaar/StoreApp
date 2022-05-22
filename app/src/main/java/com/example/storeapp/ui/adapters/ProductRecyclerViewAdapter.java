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
import com.example.storeapp.model.ProductModel;
import com.squareup.picasso.Picasso;

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
       holder.titleTxt.setText(productList.get(position).getTitle());
       holder.categoryTxt.setText(productList.get(position).getCategory());
        Picasso.get().load(productList.get(position).getImage()).into(holder.productImg);

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
          TextView categoryTxt,titleTxt,priceTxt;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
           heartImg=itemView.findViewById(R.id.heartImg);
           productImg =itemView.findViewById(R.id.productimg);
           categoryTxt=itemView.findViewById(R.id.txt_category);
           titleTxt=itemView.findViewById(R.id.txt_Title);
           priceTxt=itemView.findViewById(R.id.txt_price);
        }
    }
}
