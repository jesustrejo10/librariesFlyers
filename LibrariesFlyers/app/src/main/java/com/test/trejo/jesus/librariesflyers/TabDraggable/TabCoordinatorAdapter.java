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
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position){

            case 0:
                return LeftFragment.newInstance(position + 1);

            case 1:
                return RightFragment.newInstance(position + 1);

            default:
                return LeftFragment.newInstance(position + 1);
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
                return "SECTION 1";
            case 1:
                return "SECTION 2";
        }
        return null;
    }
}