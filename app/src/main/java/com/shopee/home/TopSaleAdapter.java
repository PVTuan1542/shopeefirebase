package com.shopee.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shopee.DetailProductActivity;
import com.shopee.R;

import java.util.ArrayList;

public class TopSaleAdapter extends RecyclerView.Adapter<TopSaleAdapter.viewHoder> {
    ArrayList<TopSale> topSales;
    Context context;
    int layout;

    public TopSaleAdapter(ArrayList<TopSale> topSales, Context context, int layout) {
        this.topSales = topSales;
        this.context = context;
        this.layout = layout;
    }

    @NonNull
    @Override
    public TopSaleAdapter.viewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(layout, parent, false);
        return new TopSaleAdapter.viewHoder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TopSaleAdapter.viewHoder holder, int position) {
        holder.tvGia.setText(topSales.get(position).getGia());
        holder.img.setImageResource(topSales.get(position).getImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(context, DetailProductActivity.class);
                myIntent.putExtra("id",position);

                context.startActivity(myIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return topSales.size();
    }

    public class viewHoder extends RecyclerView.ViewHolder {
        TextView tvGia;
        ImageView img;

        public viewHoder(@NonNull View itemView) {
            super(itemView);
            tvGia = (TextView) itemView.findViewById(R.id.tv_gia);
            img = (ImageView) itemView.findViewById(R.id.img_topsale);
        }
    }
}
