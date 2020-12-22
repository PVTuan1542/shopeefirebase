package com.shopee.live;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.shopee.MainActivity;
import com.shopee.R;
import com.shopee.home.HomeFragment;
import com.shopee.home.InternationalActivity;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private List<App> apps;
    private ViewPager viewPager;

    public CustomAdapter(Context context, List<App> apps) {
        this.context = context;
        this.apps = apps;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mName;
        ImageView mImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.name);
            mImage = itemView.findViewById(R.id.image);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_list_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        App app = apps.get(position);

        holder.mName.setText(app.getName());
        holder.mImage.setImageResource(app.getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                viewPager = v.findViewById(R.id.vp_fragment);
//                viewPager.setCurrentItem(position);

            }
        });


    }

    @Override
    public int getItemCount() {
        return apps.size();
    }


}
