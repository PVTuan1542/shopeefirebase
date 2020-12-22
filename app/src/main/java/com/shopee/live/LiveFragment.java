package com.shopee.live;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.shopee.MainActivity;
import com.shopee.R;
import com.shopee.home.BannerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class LiveFragment extends Fragment {
    FragmentManager fm;
    private ViewPager vpCategory,vpFragment;
    private CircleIndicator circleIndicator;
    private BannerAdapter photoAdapter;
    private ArrayList<Integer> mListPhoto;
    private Timer mTimer;
    RecyclerView mList1;
    List<App> appList;

    private View view;
    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_live, container, false);
        mainActivity = (MainActivity) getActivity();

        vpCategory = view.findViewById(R.id.vp_category);
        circleIndicator = view.findViewById(R.id.circle_indicator);

        mListPhoto = getListPhoto();
        photoAdapter = new BannerAdapter(mainActivity, mListPhoto);
        vpCategory.setAdapter(photoAdapter);

        circleIndicator.setViewPager(vpCategory);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        setData();

        autoSlideImage();

        return view;
    }
    public void setData(){
        mList1 = view.findViewById(R.id.list1);
        appList = new ArrayList<>();

        appList.add(new App(R.drawable.watchingtv, "Tất cả"));
        appList.add(new App(R.drawable.gift, "Freeship"));
        appList.add(new App(R.drawable.schedule, "Sắp diễn ra"));
        appList.add(new App(R.drawable.live, "Idol Review"));
        appList.add(new App(R.drawable.videocallingapp, "Mới nhất"));
        appList.add(new App(R.drawable.backarrow, "Xem lại"));

        LinearLayoutManager manager1 = new LinearLayoutManager(mainActivity);
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        mList1.setLayoutManager(manager1);

        CustomAdapter adaptor1 = new CustomAdapter(mainActivity, appList);
        mList1.setAdapter(adaptor1);

    }

    private ArrayList<Integer> getListPhoto() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.shopee1);
        list.add(R.drawable.shopee2);
        list.add(R.drawable.shopee3);
        list.add(R.drawable.shopee4);
        list.add(R.drawable.shopee5);
        list.add(R.drawable.shopee6);

        return list;
    }

    private void autoSlideImage() {
        if (mListPhoto == null || mListPhoto.isEmpty() || vpCategory == null) {
            return;
        }

        // Init Timer
        if (mTimer == null) {
            mTimer = new Timer();
        }

        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = vpCategory.getCurrentItem();
                        int totalItem = mListPhoto.size() - 1;
                        if (currentItem < totalItem) {
                            currentItem++;
                            vpCategory.setCurrentItem(currentItem);
                        } else {
                            vpCategory.setCurrentItem(0);
                        }
                    }
                });
            }
        }, 400, 2500);
    }
    public void setVpFragment(){

    }

}

