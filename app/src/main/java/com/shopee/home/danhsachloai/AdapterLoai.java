package com.shopee.home.danhsachloai;

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

public class AdapterLoai extends RecyclerView.Adapter<AdapterLoai.ViewHolder>{
    ArrayList<loai> loais ;
    Context context;
    int row_layout;

    public AdapterLoai(ArrayList<loai> loais, Context context, int row_layout) {
        this.loais = loais;
        this.context = context;
        this.row_layout = row_layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(row_layout,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTen.setText(loais.get(position).getTen());
        holder.txtMoTa.setText(loais.get(position).getMota());
        holder.anh.setImageResource(loais.get(position).getAnh());
    }

    @Override
    public int getItemCount() {
        return loais.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        ImageView anh;
        TextView txtTen,txtMoTa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            anh = (ImageView) itemView.findViewById(R.id.anh_Loai);
            txtTen = (TextView) itemView.findViewById(R.id.tv_Ten);
            txtMoTa = (TextView) itemView.findViewById(R.id.tv_MoTa);
        }
    }
}
