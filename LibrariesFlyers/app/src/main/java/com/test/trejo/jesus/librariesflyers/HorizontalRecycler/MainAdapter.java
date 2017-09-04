package com.test.trejo.jesus.librariesflyers.HorizontalRecycler;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.Models.GeneralObject;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.Models.RecyclerObject;
import com.test.trejo.jesus.librariesflyers.R;

import java.util.ArrayList;

/**
 * Created by jesus on 04/09/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder>{

    private ArrayList<GeneralObject> mDataSet;
    int[] sampleImages = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4, R.drawable.slide};
    private Context mContext;
    private HorizontalAdapter mOfferAdapter;

    public MainAdapter(ArrayList<GeneralObject> mDataset, Context context) {
        this.mDataSet = mDataset;
        mContext = context;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_general_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MainViewHolder vh = new MainViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {

        holder.getCarouselView().setPageCount(sampleImages.length);

        holder.getCarouselView().setImageListener(imageListener);

        holder.getCarouselView().setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(mContext, "Clicked item: "+ position, Toast.LENGTH_SHORT).show();
            }
        });

        manageAdapter(holder.getOfferRecyclerView());

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    private void manageAdapter(RecyclerViewPager mRecyclerView){
        RecyclerObject test = new RecyclerObject();
        ArrayList<RecyclerObject> mdataSet = new ArrayList<>();
        mdataSet.add(test);
        mdataSet.add(test);
        mdataSet.add(test);
        mdataSet.add(test);
        mdataSet.add(test);
        mdataSet.add(test);
        mdataSet.add(test);

        mOfferAdapter = new HorizontalAdapter(mdataSet);

        // setLayoutManager like normal RecyclerView, you do not need to change any thing.
        LinearLayoutManager layout = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
        layout.setAutoMeasureEnabled(true);

        mRecyclerView.setLayoutManager(layout);
        mRecyclerView.setAdapter(mOfferAdapter);


//        recyclerView.setLayoutManager(layoutManager);
  //      recyclerView.setNestedScrollingEnabled(false);
    }
}
