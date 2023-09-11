package com.example.javaappversion13.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.javaappversion13.Activities.MainActivity;
import com.example.javaappversion13.Activities.callFragment;
import com.example.javaappversion13.Activities.chatFragment;
import com.example.javaappversion13.Activities.statusFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull MainActivity fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new chatFragment();
            case 1:
                return new statusFragment();
            case 2:
                return new callFragment();
            default:
                return new chatFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}