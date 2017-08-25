package com.test.trejo.jesus.librariesflyers.LonelyEffect;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ScrollView;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.HorizontalAdapter;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.RecyclerObject;
import com.test.trejo.jesus.librariesflyers.R;

import java.util.ArrayList;

public class LonelyEffectActivity extends AppCompatActivity {

    private ArrayList<RecyclerObject> mDataSet;
    private VerticalLonelyAdapter mAdapter;
    private ScrollView mScrollView;
    SlidingUpPanelLayout panel;
    LinearLayoutManager mLayoutManager;
    RecyclerView mRecyclerView;
    int visibleItemCount ;
    int totalItemCount ;
    int firstVisibleItemIndex ;
    boolean loading = false;
    int previousTotal = 0;
    int status = 1;
    //0 mean collapsed
    //1 mean hidden
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


        final int someWaitInterval = 20;


//                                                                                                                          panel.

        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        // setLayoutManager like normal RecyclerView, you do not need to change any thing.
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        /*
        if (layout.findFirstCompletelyVisibleItemPosition() == 0) {
            panel.setPanelHeight(50);
        }else{
            panel.setPanelHeight(250);
        }
        */
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {


                //WORK FOR BOTTOM
                int visibleItemCount = mLayoutManager.getChildCount();
                int totalItemCount = mLayoutManager.getItemCount();
                int pastVisibleItems = mLayoutManager.findFirstVisibleItemPosition();

                if(pastVisibleItems == 0){
                    if (status != 0) {
                        Runnable r = new Runnable() {

                            @Override
                            public void run() {
                                try {
                                    status = 0;
                                    panel.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);                                } catch (Exception e2) {
                                    new Handler().postDelayed(this, someWaitInterval);
                                }
                            }};
                        new Handler().postDelayed(r, someWaitInterval);

                    }
                }else{
                    Runnable r = new Runnable() {

                        @Override
                        public void run() {
                            try {
                                status = 0;
                                panel.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN);                                } catch (Exception e2) {
                                new Handler().postDelayed(this, someWaitInterval);
                            }
                        }};
                    new Handler().postDelayed(r, someWaitInterval);
                    //if (pastVisibleItems + visibleItemCount >= totalItemCount) {
                    //}
                }

/*
                visibleItemCount = mRecyclerView.getChildCount();
                totalItemCount = mLayoutManager.getItemCount();
                firstVisibleItemIndex = mLayoutManager.findFirstVisibleItemPosition();
                //synchronizew loading state when item count changes
                if (loading) {
                    if (totalItemCount > previousTotal) {
                        loading = false;
                        previousTotal = totalItemCount;
                    }
                }
                if (!loading)
                    if ((totalItemCount - visibleItemCount) <= firstVisibleItemIndex) {
                        // Loading NOT in progress and end of list has been reached
                        // also triggered if not enough items to fill the screen
                        // if you start loading
                        loading = true;
                    } else if (firstVisibleItemIndex == 0){
                        // top of list reached
                        // if you start loading
                        loading = true;
                    }
*/
            }
        });
    }


}
