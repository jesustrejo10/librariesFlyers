package com.test.trejo.jesus.librariesflyers.TabDraggable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.trejo.jesus.librariesflyers.R;

/**
 * Created by jesus on 30/08/17.
 */

public class RightFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static String ARG_SECTION_TITTLE = "section_title";

    public RightFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static RightFragment newInstance(String sectionTittle) {
        RightFragment fragment = new RightFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_TITTLE, sectionTittle);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_right, container, false);
        return rootView;
    }
}
