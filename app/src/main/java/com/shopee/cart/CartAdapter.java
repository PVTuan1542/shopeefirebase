package com.shopee.cart;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shopee.R;
import com.shopee.home.InternationalActivity;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewHoder> {

    ArrayList<Cart> carts;
    Context context;
    int layout,soluong;

    public CartAdapter(ArrayList<Cart> carts, Context context, int layout) {
        this.carts = carts;
        this.context = context;
        this.layout = layout;
    }

    @NonNull
    @Override
    public viewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(layout, parent, false);
        return new viewHoder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHoder holder, int position) {
        holder.tvName.setText(carts.get(position).getName());
        holder.tvProduct.setText(carts.get(position).getProduct());
        holder.tvGia.setText(carts.get(position).getGia());
        holder.img.setImageResource(carts.get(position).getImg());
        holder.solg.setText(String.valueOf(carts.get(position).getSolg()));

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(context, carts.get(position).getName(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
        soluong = carts.get(position).getSolg();
        holder.imgSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soluong -= 1;
                holder.solg.setText(String.valueOf(soluong));
            }
        });
        holder.imgSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soluong += 1;
                holder.solg.setText(String.valueOf(soluong));
            }
        });
    }

    @Override
    public int getItemCount() {
        return carts.size();
    }

    public void addItem(int position, Cart data) {
        carts.add(position, data);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        carts.remove(position);
        notifyItemRemoved(position);
    }


    public class viewHoder extends RecyclerView.ViewHolder {
        TextView tvName, tvProduct, tvGia ;
        ImageView img,imgSum,imgSub;
        EditText solg;

        public viewHoder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvProduct = itemView.findViewById(R.id.tv_product);
            tvGia = itemView.findViewById(R.id.tv_gia);
            img = itemView.findViewById(R.id.img_product);
            imgSum = itemView.findViewById(R.id.imgsum);
            imgSub = itemView.findViewById(R.id.imgsub);
            solg = itemView.findViewById(R.id.edt_solg);

        }
    }
}
