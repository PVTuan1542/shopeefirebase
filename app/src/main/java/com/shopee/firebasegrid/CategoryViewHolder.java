package com.shopee.firebasegrid;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shopee.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    public ImageView img;
    public TextView name,tv_giaban,tv_giakm;


    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        name = (TextView) itemView.findViewById(R.id.tv_ThongTinSP);
        img = (ImageView) itemView.findViewById(R.id.anh_SanPham);
        tv_giaban= (TextView) itemView.findViewById(R.id.tv_giaban);
        tv_giakm = (TextView) itemView.findViewById(R.id.tv_giakm);

    }
}
