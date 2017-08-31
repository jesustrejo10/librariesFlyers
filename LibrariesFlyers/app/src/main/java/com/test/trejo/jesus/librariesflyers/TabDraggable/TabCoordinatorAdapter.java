package com.test.trejo.jesus.librariesflyers.TabDraggable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by jesus on 30/08/17.
 */

public class TabCoordinatorAdapter extends FragmentPagerAdapter {

    public TabCoordinatorAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                return LeftFragment.newInstance("Active");

            case 1:
                return RightFragment.newInstance("Past");

            default:
                return LeftFragment.newInstance("Active");
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Active";
            case 1:
                return "Past";
        }
        return null;
    }
}