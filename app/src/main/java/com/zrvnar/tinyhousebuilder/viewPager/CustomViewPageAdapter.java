package com.zrvnar.tinyhousebuilder.viewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.zrvnar.tinyhousebuilder.R;

public class CustomViewPageAdapter extends FragmentStateAdapter {
    public CustomViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return BuildDetailFragment.newInstance("Finding a Lot", "To begin your Tiny house build the first thing youll need is a lot", R.drawable.lot_image);
            default: return BuildDetailFragment.newInstance("404 Fragment not found", "You went to far", R.drawable.error_logo);
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
