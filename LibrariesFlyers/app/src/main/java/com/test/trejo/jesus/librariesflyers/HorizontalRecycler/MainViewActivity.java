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
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.HorizontalAdapter;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.RecyclerObject;
import com.test.trejo.jesus.librariesflyers.R;

import java.util.ArrayList;

public class MainViewActivity extends AppCompatActivity {


    private HorizontalAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<RecyclerObject> mdataSet;
    CarouselView carouselView;

    int[] sampleImages = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4, R.drawable.slide};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

        RecyclerObject test = new RecyclerObject();
        mdataSet = new ArrayList<>();
        mdataSet.add(test);
        mdataSet.add(test);
        mdataSet.add(test);
        mdataSet.add(test);
        mdataSet.add(test);
        mdataSet.add(test);
        mdataSet.add(test);

        mAdapter = new HorizontalAdapter(mdataSet);

        RecyclerViewPager mRecyclerView = (RecyclerViewPager) findViewById(R.id.list);
        // setLayoutManager like normal RecyclerView, you do not need to change any thing.
        LinearLayoutManager layout = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(layout);
        mRecyclerView.setAdapter(mAdapter);
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getApplicationContext(), "Clicked item: "+ position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

}

