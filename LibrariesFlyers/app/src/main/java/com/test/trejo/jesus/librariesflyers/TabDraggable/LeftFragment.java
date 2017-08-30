package com.test.trejo.jesus.librariesflyers.TabDraggable;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.trejo.jesus.librariesflyers.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";


    public LeftFragment() {
        // Required empty public constructor
    }

    public static LeftFragment newInstance(int sectionNumber) {
        LeftFragment fragment = new LeftFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_left, container, false);
    }

}
