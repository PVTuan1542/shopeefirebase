package com.shopee.live;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.shopee.feed.FeedFragment;
import com.shopee.home.HomeFragment;
import com.shopee.me.MeFragment;
import com.shopee.notification.NotificationFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new LiveAllFragment();
            case 1:
                return new LiveEventFragment() ;
            case 2:
                return new LiveAllFragment();
            case 3:
                return new LiveAllFragment();
            case 4:
                return new LiveAllFragment();
            case 5:
                return new LiveAllFragment();
            default:
                return new LiveAllFragment();

        }
    }

    @Override
    public int getCount() {
        return 6;
    }
}
