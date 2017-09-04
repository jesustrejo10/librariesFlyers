package com.test.trejo.jesus.librariesflyers.HorizontalRecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.Models.GeneralObject;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.Models.RecyclerObject;
import com.test.trejo.jesus.librariesflyers.R;

import java.util.ArrayList;

public class MainViewActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        GeneralObject mObject = new GeneralObject();
        ArrayList<GeneralObject> mObjects = new ArrayList<>();
        mObjects.add(mObject);
        mObjects.add(mObject);
        mObjects.add(mObject);

        MainAdapter adapter = new MainAdapter(mObjects,getApplicationContext());

        // setLayoutManager like normal RecyclerView, you do not need to change any thing.
        LinearLayoutManager layout = new LinearLayoutManager(getApplicationContext());

        mRecyclerView.setLayoutManager(layout);
        mRecyclerView.setNestedScrollingEnabled(true);
        mRecyclerView.setAdapter(adapter);

    }
    
}

