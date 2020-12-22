package com.shopee;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shopee.cart.CartActivity;
import com.shopee.chat.ChatActivity;
import com.shopee.home.BannerAdapter;
import com.shopee.home.TopSale;

import java.util.ArrayList;
import java.util.List;

public class DetailProductActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Integer> listPhoto;
    private TextView tv_name,tv_gia,tv_km,tv_rating;
    private RatingBar ratingBar;
    ImageView back,cart,chat;
    private DatabaseReference mData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        init ();

        setbtn_Cart();
        setbtn_Back();
        setbtn_Chat();
        setData();
        viewPager = findViewById(R.id.viewpager);
        listPhoto = getListPhoto();
        BannerAdapter bnAdapter = new BannerAdapter(this, listPhoto);
        viewPager.setAdapter(bnAdapter);

    }

    public void init (){
        tv_name = findViewById(R.id.name_product);
        tv_gia = findViewById(R.id.gia_product);
        tv_km = findViewById(R.id.gia_km);
        tv_rating = findViewById(R.id.rating_product);
        ratingBar = findViewById(R.id.ratingBar);
    }
    public void setData(){
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        mData = FirebaseDatabase.getInstance().getReference().child("Product");
        mData.orderByKey().equalTo(id).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Product values =  snapshot.getValue (Product.class);
                tv_name.setText(values.getName());
                tv_gia.setText(values.getGia());
                tv_km.setText(values.getGia_km());
                tv_rating.setText(values.getNum_ratting() );

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private ArrayList<Integer> getListPhoto() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.shop1);
        list.add(R.drawable.shop2);
        list.add(R.drawable.shop3);
        return list;
    }
    public void setbtn_Chat(){
        chat = findViewById(R.id.chat);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DetailProductActivity.this, ChatActivity.class);
                startActivity(myIntent);
            }
        });

    }

    public void setbtn_Cart(){
        cart = findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DetailProductActivity.this, CartActivity.class);
                startActivity(myIntent);
            }
        });

    }
    public void setbtn_Back(){
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
