package com.test.trejo.jesus.librariesflyers.LonelyEffect;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.HorizontalAdapter;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.RecyclerObject;
import com.test.trejo.jesus.librariesflyers.R;

import java.util.ArrayList;

public class LonelyEffectActivity extends AppCompatActivity {

    private ArrayList<RecyclerObject> mDataSet;
    private VerticalLonelyAdapter mAdapter;
    SlidingUpPanelLayout panel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lonely_effect);

        RecyclerObject test = new RecyclerObject();
        mDataSet = new ArrayList<>();
        mDataSet.add(test);
        mDataSet.add(test);
        mDataSet.add(test);
        mDataSet.add(test);
        mDataSet.add(test);
        mDataSet.add(test);
        mDataSet.add(test);
        mAdapter = new VerticalLonelyAdapter(mDataSet);

        panel = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        panel.setScrollContainer(true);
        /*
        final int someWaitInterval = 20;
        Runnable r = new Runnable() {

            @Override
            public void run() {
                try {
                    panel.setPanelHeight(50);
                } catch (Exception e2) {
                    new Handler().postDelayed(this, someWaitInterval);
                }
            }};
        new Handler().postDelayed(r, someWaitInterval);
        */
//                                                                                                                          panel.

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.list);
        // setLayoutManager like normal RecyclerView, you do not need to change any thing.
        LinearLayoutManager layout = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layout);
        /*
        if (layout.findFirstCompletelyVisibleItemPosition() == 0) {
            panel.setPanelHeight(50);
        }else{
            panel.setPanelHeight(250);
        }
        */
        mRecyclerView.setAdapter(mAdapter);
    }
}
