package com.shopee.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shopee.R;
import com.shopee.cart.CartActivity;
import com.shopee.feed.FeedFragment;
import com.shopee.live.LiveFragment;
import com.shopee.me.MeFragment;
import com.shopee.notification.NotificationFragment;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewHoder> {

    ArrayList<Category> categories;
    Context context;
    int layout;

    public CategoryAdapter(ArrayList<Category> categories, Context context, int layout) {
        this.categories = categories;
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
        holder.tvName.setText(categories.get(position).getName());
        holder.img.setImageResource(categories.get(position).getImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        Toast.makeText(context,categories.get(position).getName(), Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(context,categories.get(position).getName(), Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Intent myIntent = new Intent(context, InternationalActivity.class);
                        context.startActivity(myIntent);

                        break;
                    case 3:
                        Toast.makeText(context,categories.get(position).getName(), Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(context,categories.get(position).getName(), Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(context,categories.get(position).getName(), Toast.LENGTH_SHORT).show();
                        break;

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class viewHoder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView img;
        public viewHoder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            img = (ImageView) itemView.findViewById(R.id.img_calotery);
        }
    }
}
