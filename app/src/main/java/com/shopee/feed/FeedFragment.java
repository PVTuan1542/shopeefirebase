package com.shopee.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shopee.MainActivity;
import com.shopee.R;
import com.shopee.me.AdapterOfListMenu;

import java.util.ArrayList;

public class FeedFragment extends Fragment {
    Toolbar toolbar;

    private View view;
    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_feed, container, false);
//        bottomNavigationView();

        addControler();
        return view;
    }

    private void addControler() {
        init_ListToolBar();
        init_Posts();
    }

    //Hiện thị list toolbar
    public void init_ListToolBar() {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_dsmenu);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<List_Menu> arrayList = new ArrayList<>();
        arrayList.add(new List_Menu(R.drawable.thoi_gian, "Thời Gian"));
        arrayList.add(new List_Menu(R.drawable.review, "Shopee Review"));
        arrayList.add(new List_Menu(R.drawable.idol, "Shopee Idol"));
        arrayList.add(new List_Menu(R.drawable.make_up, "Làm đẹp"));
        arrayList.add(new List_Menu(R.drawable.thoitrang, "Thời Trang"));
        arrayList.add(new List_Menu(R.drawable.songchat, "Sống Chất"));
        arrayList.add(new List_Menu(R.drawable.sale, "Siêu Sale"));
        arrayList.add(new List_Menu(R.drawable.khampha, "Khám Phá"));

        AdapterOfListMenu adapter = new AdapterOfListMenu(arrayList, mainActivity, R.layout.row_listmenu);
        recyclerView.setAdapter(adapter);

    }

    //Hiện thị posts
//Hiện thị list toolbar
    public void init_Posts() {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_posts);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<post> arrayList = new ArrayList<>();
        arrayList.add(new post(R.drawable.logo_suxi, "Su.xi.vn", R.drawable.post1, 1040, 200, 300));
        arrayList.add(new post(R.drawable.logo_jg, "Jungjan.vn", R.drawable.post2, 400, 200, 300));
        arrayList.add(new post(R.drawable.logo_tuni, "Tuni Store", R.drawable.post3, 100, 200, 30));
        arrayList.add(new post(R.drawable.tuenhishop, "TueNhiShop", R.drawable.post4, 400, 100, 90));
        arrayList.add(new post(R.drawable.logo_shopee, "Shopeevn", R.drawable.post5, 100, 800, 300));

        AdapterPosts adapter = new AdapterPosts(arrayList, mainActivity);
        recyclerView.setAdapter(adapter);

    }
}