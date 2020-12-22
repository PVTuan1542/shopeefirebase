package com.shopee.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shopee.MainActivity;
import com.shopee.R;
import com.shopee.cart.CartActivity;
import com.shopee.home.danhsachloai.AdapterLoai;
import com.shopee.home.danhsachloai.loai;
import com.shopee.home.sanpham.AdapterSanPham;
import com.shopee.home.sanpham.sanpham;

import java.util.ArrayList;

public class InternationalActivity extends AppCompatActivity {
    private ImageView back,cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international);

        setbtn_Back();
        setbtn_Cart();
        //Gọi recylerview sản phẩm cuối năm
        init_ListSPCuoiNam();
        //Gọi loại danh sách
        init_Loai();
    }

    //Add san pham
    public  void init_ListSPCuoiNam(){
        RecyclerView recyclerView = findViewById(R.id.recyclerview_ThoiTrangCuoiNam);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<sanpham> arrayList =  new ArrayList<>();

        arrayList.add(new sanpham("Áo sơ mi nữ tay phồng theo phong cách retro",R.drawable.sp_aoden,233000 ,118000,5,897));
        arrayList.add(new sanpham("Giày vớ tập đi chống trượt hình động vật dễ thương cho bé",R.drawable.sp_depchobe,68000 ,34000,4,367));
        arrayList.add(new sanpham("Áo Hoodie Tay Dài In Hình Khủng Long Cho Nam",R.drawable.sp_hoodie,201000 ,101000,4,176));
        arrayList.add(new sanpham("Áo tay dài dáng rộng cổ tròn thời trang phong cách cho nam",R.drawable.sp_aotaydai,168000 ,100000,5,67));
        arrayList.add(new sanpham("Áo Thun Lửng Tay Ngắn Thêu Hình Bướm Quyến Rũ Cho Nữ",R.drawable.sp_aothun,100000 ,50000,5,239));

        AdapterSanPham adapter = new AdapterSanPham(arrayList, InternationalActivity.this,R.layout.row_sanpham);
        recyclerView.setAdapter(adapter);

    }
    //add Loai danh sách
    public  void init_Loai(){
        RecyclerView recyclerView = findViewById(R.id.recyclerview_Menu);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<loai> arrayList =  new ArrayList<>();

        arrayList.add(new loai("VOUCHER",R.drawable.voucher,"NGẤT NGÂY"));
        arrayList.add(new loai("SIÊU SALE",R.drawable.sale,"GÕ CỬA"));
        arrayList.add(new loai("MUA NHIỀU",R.drawable.ic_mall,"GIẢM SÂU"));
        arrayList.add(new loai("QUÀ TẶNG",R.drawable.gift,"GIÁNG SINH"));
        arrayList.add(new loai("SĂN SALE",R.drawable.ic_mart,"QUỐC TẾ"));
        arrayList.add(new loai("ƯU ĐÃI TỪ",R.drawable.diamond,"THƯƠNG HIỆU"));
        arrayList.add(new loai("ĐẶT LỊCH",R.drawable.ic_deals,"HÓT DEAL"));
        arrayList.add(new loai("DÀNH RIÊNG",R.drawable.ic_partner,"CHO BẠN"));

        AdapterLoai adapter = new AdapterLoai(arrayList,InternationalActivity.this,R.layout.row_danhsachloai);
        recyclerView.setAdapter(adapter);

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
    public void setbtn_Cart(){
        cart = findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(InternationalActivity.this, CartActivity.class);
                startActivity(myIntent);
            }
        });

    }
}
