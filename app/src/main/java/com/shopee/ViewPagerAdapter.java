package com.shopee;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.shopee.feed.FeedFragment;
import com.shopee.live.LiveFragment;
import com.shopee.home.HomeFragment;
import com.shopee.me.MeFragment;
import com.shopee.notification.NotificationFragment;

public class  ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new FeedFragment();
            case 2:
                return new LiveFragment();
            case 3:
                return new NotificationFragment();
            case 4:
                return new MeFragment();
            default:
                return new HomeFragment();

        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
