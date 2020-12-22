package com.shopee.me;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.shopee.R;
import com.shopee.feed.List_Menu;

import java.util.ArrayList;

public class AdapterOfListMenu extends  RecyclerView.Adapter<AdapterOfListMenu.ViewHolder> {

    ArrayList<List_Menu> list_menus;
    Context context;
    int row_layout;

    public AdapterOfListMenu(ArrayList<List_Menu> list_menus, Context context, int row_layout) {
        this.list_menus = list_menus;
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

        holder.txtTen.setText(list_menus.get(position).getTen());
        holder.imgHinh.setImageResource(list_menus.get(position).getAnh());
    }

    @Override
    public int getItemCount() {
        return list_menus.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtTen ;
        ImageView imgHinh;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTen = (TextView) itemView.findViewById(R.id.tv_ten);
            imgHinh = (ImageView) itemView.findViewById(R.id.img);
        }
    }


}
