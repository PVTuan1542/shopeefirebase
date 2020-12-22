package com.shopee.chat;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.shopee.R;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    ArrayList<Chat> listChats;
    ImageView back, exit;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initChat();
        
    }

    public void initChat() {
        RecyclerView rcv_chat = findViewById(R.id.rcv_chat);
        rcv_chat.setHasFixedSize(true);
        GridLayoutManager gird = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        rcv_chat.setLayoutManager(gird);

        listChats = new ArrayList<>();

        listChats.add(new Chat(R.drawable.shop1, "keobonggon.s","Bạn đã nhận được một sticker","13:13 08-11-2020"));
        listChats.add(new Chat(R.drawable.shop2, "phanphoisitoanquoc", "Combo khuyến mãi được gợi ý","13:13 07-11-2020"));
        listChats.add(new Chat(R.drawable.shop3, "hanghotgiaxuong", "Bạn nhận được lời nhắc nhở từ giỏ hàng","13:13 08-11-2020"));
        listChats.add(new Chat(R.drawable.shop4, "bangbang.vn", "sorry, we have no its size","13:13 08-11-2020"));
        listChats.add(new Chat(R.drawable.shop5, "jaystoree", "Bạn được tặng 1 mã giảm giá","13:13 08-11-2020"));
        listChats.add(new Chat(R.drawable.shop6, "linhkiengiatot.net", "Cám ơn bạn đã theo Shop! Voucher này dành riêng cho bạn kèm hạn sử dụng.","13:13 08-11-2020"));
        listChats.add(new Chat(R.drawable.shop7, "thudannet","254 bế văn dand","13:13 08-11-2020"));
        listChats.add(new Chat(R.drawable.shop8, "luan002", "mua nhanh thì làm thế nào z","13:13 08-11-2020"));
        listChats.add(new Chat(R.drawable.shop9, "bansi.camera", "lưu được khoảng 4-5 ngày a nhé","13:13 08-11-2020"));
        listChats.add(new Chat(R.drawable.shop10, "0865397692.camera", "đt có mạng là được bạn ạ","13:13 08-11-2020"));
        listChats.add(new Chat(R.drawable.shop11, "wado123", "Giá chỉ từ 19,590,000đ","13:13 08-11-2020"));
        listChats.add(new Chat(R.drawable.shop12, "dungtienpham", "Mình không kịp tưới cây. Bạn giúp mình một tay nha! https://games.shopee.vn/farm/friend.html?fid=62619482&backmyfarm=1&schannel=chat","13:13 08-11-2020"));
        listChats.add(new Chat(R.drawable.shop13, "lvthu93","ns z thì chịu òi","13:13 08-11-2020"));
        listChats.add(new Chat(R.drawable.shop14, "hadalabo.officialstore", "chân cắm y ảnh mình mô tả đó nha b","13:13 08-11-2020"));
        listChats.add(new Chat(R.drawable.shop15, "smartvoucher", "For Samsung New Series 9: 900X3C 900X4B 900X4C 900X4D NP900X3C NP900X4B NP900X4C NP900X4D","13:13 08-11-2020"));

        ChatAdapter chatAdapter = new ChatAdapter(listChats, ChatActivity.this, R.layout.item_chat);
        rcv_chat.setAdapter(chatAdapter);

    }


}
