package com.shopee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;
import com.shopee.home.BannerAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class FirebaseActivity extends AppCompatActivity {
    private DatabaseReference mData;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private ArrayList<Integer> listPhoto;
    private Timer timer;
    TextView tv_tmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
        mData = FirebaseDatabase.getInstance().getReference().child("BannerHome");
//        lv_tmp = findViewById(R.id.lv_tmp);
        tv_tmp = findViewById(R.id.tv_tmp);
//        listPhoto = new ArrayList<>();

//        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, listPhoto);
//        lv_tmp.setAdapter(arrayAdapter);

        getListPhoto();

        autoSlideImage();
    }

    private void getListPhoto() {
        listPhoto = new ArrayList<>();

        viewPager = findViewById(R.id.viewpager);
        BannerAdapter bnAdapter = new BannerAdapter(this, listPhoto);
       listPhoto = getList(bnAdapter);
        bnAdapter.notifyDataSetChanged();
//        listPhoto.add(R.drawable.banner1);
//        listPhoto.add(R.drawable.banner2);
//        listPhoto.add(R.drawable.banner3);
//        listPhoto.add(R.drawable.banner4);
//        listPhoto.add(R.drawable.banner5);
//        listPhoto.add(R.drawable.banner6);
//        listPhoto.add(R.drawable.banner7);
//        listPhoto.add(R.drawable.banner8);
//        listPhoto.add(R.drawable.banner9);


        circleIndicator = findViewById(R.id.circle_indicator);

        viewPager.setAdapter(bnAdapter);

        circleIndicator.setViewPager(viewPager);
        bnAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());




    }
    private ArrayList<Integer> getList (BannerAdapter bnAdapter){
        mData.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                int values =  snapshot.getValue (int.class);

//                tv_tmp.append(values+ "\n");
                listPhoto.add(values);
                bnAdapter.notifyDataSetChanged();

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
        return listPhoto;
    }
    private void autoSlideImage() {
        if (listPhoto == null || listPhoto.isEmpty() || viewPager == null) {
            tv_tmp.setText("list Null");
            return;
        }
        // Init Timer
        if (timer == null) {
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = listPhoto.size() - 1;
                        if (currentItem < totalItem) {
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        } else {
                            viewPager.setCurrentItem(1);
                        }
                    }
                });
            }
        }, 400, 2000);
    }
}