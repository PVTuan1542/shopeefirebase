package com.shopee.live;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.shopee.MainActivity;
import com.shopee.R;

import java.util.ArrayList;

public class LiveEventFragment extends Fragment {
    ListView lvProductEvent;
    ArrayList<ProductEvent> arrayProductEvent;
    AdapterEventProduct adapter;
    private MainActivity mainActivity;
    View view;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_live_event, container, false);
        mainActivity = (MainActivity) getActivity();

        AnhXa();
        adapter = new AdapterEventProduct(mainActivity, R.layout.item_live_event, arrayProductEvent);
        lvProductEvent.setAdapter(adapter);
        return view;
    }


    private void AnhXa() {
        lvProductEvent = view.findViewById(R.id.lv_product);
        arrayProductEvent = new ArrayList<>();

        arrayProductEvent.add(new ProductEvent("DEAL XỊN VOUCHER XỊN","VN Shopee Live Official","19:00 6 Th12 2020","862 thiết bị nhắc nhở",R.drawable.sp1,R.drawable.sp1));
        arrayProductEvent.add(new ProductEvent("THỬ THÁCH CÙNG SAO","VN Shopee Live Official","12:00 6 Th12 2020","863 thiết bị nhắc nhở",R.drawable.sp2,R.drawable.sp2));
        arrayProductEvent.add(new ProductEvent("KHUI QUÀ TRÚNG SIÊU PHẨM","VN Shopee Live Official","12:00 6 Th12 2020","863 thiết bị nhắc nhở",R.drawable.sp3,R.drawable.sp3));
        arrayProductEvent.add(new ProductEvent("PHỤ KIỆN SIÊU CẤP","TOPK Official Flagship","12:00 6 Th12 2020","456 thiết bị nhắc nhở",R.drawable.sp4,R.drawable.sp4));
        arrayProductEvent.add(new ProductEvent("MỸ PHẨM CHẤT LƯỢNG","FOCALLURE.vn","12:00 6 Th12 2020","456 thiết bị nhắc nhở",R.drawable.sp5,R.drawable.sp5));
        arrayProductEvent.add(new ProductEvent("THẾ GIỚI ÂM THANH","Vtog Official Store","12:00 6 Th12 2020","455 thiết bị nhắc nhở",R.drawable.sp6,R.drawable.sp6));
        arrayProductEvent.add(new ProductEvent("MỸ PHẨM SÀNH ĐIỆU","Pudial Official Store","11:00 6 Th12 2020","123 thiết bị nhắc nhở",R.drawable.sp7,R.drawable.sp7));
        arrayProductEvent.add(new ProductEvent("DẠO QUANH PHỐ PHƯỜNG","Merce Official Store","16:00 7 Th12 2020","223 thiết bị nhắc nhở",R.drawable.sp8,R.drawable.sp8));
    }

}
