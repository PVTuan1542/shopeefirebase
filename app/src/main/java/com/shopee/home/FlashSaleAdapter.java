package com.shopee.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shopee.R;

import java.util.ArrayList;

public class FlashSaleAdapter extends RecyclerView.Adapter<FlashSaleAdapter.viewHoder> {

    ArrayList<FlashSale> flashSales;
    Context context;
    int layout;

    public FlashSaleAdapter(ArrayList<FlashSale> flashSales, Context context, int layout) {
        this.flashSales = flashSales;
        this.context = context;
        this.layout = layout;
    }

    @NonNull
    @Override
    public viewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(layout,parent,false);
        return new viewHoder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHoder holder, int position) {
        holder.tvName.setText(flashSales.get(position).getGia());
        holder.img.setImageResource(flashSales.get(position).getImg());
        holder.sell.setText(flashSales.get(position).getSell());

    }

    @Override
    public int getItemCount() {
        return flashSales.size();
    }

    public class viewHoder extends RecyclerView.ViewHolder {
        TextView tvName,sell;
        ImageView img;

        public viewHoder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_gia);
            img = (ImageView) itemView.findViewById(R.id.img_flashsale);
            sell = (TextView) itemView.findViewById(R.id.sell);
        }
    }
}
