package com.shopee.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.shopee.R;

import java.util.ArrayList;
import java.util.List;

public class BannerAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Integer> listPhoto;


    public BannerAdapter() {
    }

    public BannerAdapter(Context context, ArrayList<Integer> listPhoto) {
        this.context = context;
        this.listPhoto = listPhoto;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_banner, container, false);
        ImageView imgBanner = view.findViewById(R.id.img_banner);

        Integer img = listPhoto.get(position);
        if (img != null){

            Glide.with(context).load(img).into(imgBanner);
        }

        //Add view to group
        container.addView(view);

        return view ;
    }

    @Override
    public int getCount() {
        if(listPhoto != null){
            return listPhoto.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
