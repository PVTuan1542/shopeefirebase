package com.shopee.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.shopee.R;
import com.shopee.chat.ChatActivity;

public class AccountSettingActivity extends AppCompatActivity {
    private ImageView back, chat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);

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
    public void setbtn_Chat(){
        chat = findViewById(R.id.chat);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(AccountSettingActivity.this, ChatActivity.class);
                startActivity(myIntent);
            }
        });

    }
}
