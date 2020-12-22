package com.shopee.cart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.shopee.MainActivity;
import com.shopee.OrderActivity;
import com.shopee.chat.ChatActivity;
import com.shopee.R;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    ArrayList<Cart> listCarts;
    ImageView back, chat;
    TextView tv_order;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Back();
        openChat();
        openOrder();
        initCart();

    }


    public void initCart() {
        RecyclerView rcv_Cart = findViewById(R.id.rcv_cart);
        rcv_Cart.setHasFixedSize(true);
        LinearLayoutManager gird = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rcv_Cart.setLayoutManager(gird);

        listCarts = new ArrayList<>();

        listCarts.add(new Cart(R.drawable.cart1, "DẦU NHỜN TỔNG HỢP", "NHỚT POWER UP 4T 20W50 DÀNH CHO XE SỐ 1L", "đ 119.000", 1));
        listCarts.add(new Cart(R.drawable.cart2, "Kho sỉ cửa khẩu", "[Mã GROMS25 hoàn 8% đơn 199K] (Combo gói 30 cái) chân vịt cay Dacheng cực kì ngon", "đ 660.000", 4));


        CartAdapter CartAdapter = new CartAdapter(listCarts, CartActivity.this, R.layout.item_cart);
        rcv_Cart.setAdapter(CartAdapter);

    }

    public void Back() {
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void openChat() {
        chat = findViewById(R.id.chat);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CartActivity.this, ChatActivity.class);
                startActivity(myIntent);
            }
        });
    }
    public void openOrder() {
        tv_order = findViewById(R.id.tv_buynow);
        tv_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CartActivity.this, OrderActivity.class);
                startActivity(myIntent);
            }
        });
    }


}
