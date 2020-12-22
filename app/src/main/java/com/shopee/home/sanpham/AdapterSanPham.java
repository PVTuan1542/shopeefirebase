package com.shopee.home.sanpham;

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

public class AdapterSanPham extends RecyclerView.Adapter<AdapterSanPham.ViewHolder>{
    ArrayList<sanpham> sanphams ;
    Context context;
    int row_layout;

    public AdapterSanPham(ArrayList<sanpham> sanphams, Context context,int row_layout) {
        this.sanphams = sanphams;
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
        holder.txtThongTinSP.setText(sanphams.get(position).getthonhTinSP());
        holder.anh.setImageResource(sanphams.get(position).getAnh());
        holder.txtGiaBan.setText(sanphams.get(position).getGiaBan()+"");
        holder.txtGiaKhuyenMai.setText(sanphams.get(position).getGiaKhuyenMai()+"");

    }

    @Override
    public int getItemCount() {
        return sanphams.size();
    }


    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView txtThongTinSP;
        TextView txtGiaBan;
        TextView txtGiaKhuyenMai;
        float tv_DanhGia,tv_SoSao;
        ImageView anh;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtThongTinSP = (TextView) itemView.findViewById(R.id.tv_ThongTinSP);
            anh = (ImageView) itemView.findViewById(R.id.anh_SanPham);
            txtGiaBan = (TextView) itemView.findViewById(R.id.tv_Gia1);
            txtGiaKhuyenMai = (TextView) itemView.findViewById(R.id.tv_Gia2);
        }
    }
}
