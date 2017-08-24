package com.test.trejo.jesus.librariesflyers.LonelyEffect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.HorizontalAdapter;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.RecyclerObject;
import com.test.trejo.jesus.librariesflyers.R;

import java.util.ArrayList;

public class LonelyEffectActivity extends AppCompatActivity {

    private ArrayList<RecyclerObject> mDataSet;
    private VerticalLonelyAdapter mAdapter;

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

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.list);
        // setLayoutManager like normal RecyclerView, you do not need to change any thing.
        LinearLayoutManager layout = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layout);
        mRecyclerView.setAdapter(mAdapter);
    }
}
