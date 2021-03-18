package com.merchpandas.tourguide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> lstFragment = new ArrayList<>();
    private final ArrayList<String> lstString = new ArrayList<>();

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lstString.get(position);
    }

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return lstFragment.get(position);
    }

    @Override
    public int getCount() {
        return lstString.size();
    }

    public void addFragment(Fragment fragment, String title) {
        lstFragment.add(fragment);
        lstString.add(title);
    }
}