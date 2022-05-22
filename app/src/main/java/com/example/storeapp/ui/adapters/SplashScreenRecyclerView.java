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

public class SplashScreenRecyclerView extends RecyclerView.Adapter<SplashScreenRecyclerView.SplashViewHolder> {

    Context context;
    int[] splashList={
            R.drawable.shop1,
            R.drawable.shop2,
            R.drawable.shop3
    };
    int []splashTitle={
            R.string.buy,
            R.string.sell,
            R.string.getreward
    };
    int []splashDes={
            R.string.buydes,
            R.string.selldes,
            R.string.getdes
    };

    public SplashScreenRecyclerView(Context context) {
        this.context = context;

    }

    @NonNull
    @Override
    public SplashViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new SplashViewHolder(LayoutInflater.from(context).inflate(R.layout.splash_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SplashViewHolder holder, int position) {
        holder.photoSplash.setImageResource(splashList[position]);
        holder.titleSplash.setText(splashTitle[position]);
        holder.desSolash.setText(splashDes[position]);

    }

    @Override
    public int getItemCount() {
        return splashList.length;
    }

    class SplashViewHolder extends RecyclerView.ViewHolder {
        ImageView photoSplash ;
        TextView titleSplash ;
        TextView desSolash ;
        public SplashViewHolder(@NonNull View itemView) {
            super(itemView);
           photoSplash =itemView.findViewById(R.id.splashphoto);
           titleSplash =itemView.findViewById(R.id.splashtitle);
           desSolash =itemView.findViewById(R.id.descriptionsplash);

        }
    }
}
