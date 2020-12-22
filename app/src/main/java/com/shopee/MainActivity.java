package com.shopee;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shopee.cart.CartActivity;
import com.shopee.chat.ChatActivity;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navView;
    private CustomViewPager viewPager;
    ImageView chat,cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setbtn_Cart();
        setbtn_Chat();

        navView = findViewById(R.id.bottom_nav);
        viewPager = findViewById(R.id.view_pager);

        setViewPager();




        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        chat.setImageResource(R.drawable.ic_chat);
                        cart.setImageResource(R.drawable.ic_cart);
                        viewPager.setCurrentItem(0);
                        break;

                    case R.id.action_feed:
                        chat.setImageResource(R.drawable.ic_chat_orange);
                        cart.setImageResource(R.drawable.ic_cart_orange);
                        viewPager.setCurrentItem(1);
                        break;

                    case R.id.action_live:
                        chat.setImageResource(R.drawable.ic_chat_orange);
                        cart.setImageResource(R.drawable.ic_cart_orange);
                        viewPager.setCurrentItem(2);
                        break;

                    case R.id.action_notifications:
                        chat.setImageResource(R.drawable.ic_chat_orange);
                        cart.setImageResource(R.drawable.ic_cart_orange);
                        viewPager.setCurrentItem(3);
                        break;

                    case R.id.action_me:
                        chat.setImageResource(R.drawable.ic_chat);
                        cart.setImageResource(R.drawable.ic_cart);
                        viewPager.setCurrentItem(4);
                        break;
                }

                return true;
            }
        });
    }

    private void setViewPager() {
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(pagerAdapter);
    }

    public void setbtn_Chat(){
        chat = findViewById(R.id.chat);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(myIntent);
            }
        });

    }

    public void setbtn_Cart(){
        cart = findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(myIntent);
            }
        });

    }

}