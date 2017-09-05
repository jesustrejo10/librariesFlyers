package com.test.trejo.jesus.librariesflyers.HorizontalRecycler;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.synnapps.carouselview.CarouselView;
import com.test.trejo.jesus.librariesflyers.R;

/**
 * Created by jesus on 04/09/17.
 */

public class MainViewHolder extends RecyclerView.ViewHolder {

    private TextView mPrincipalTextView;
    private CarouselView carouselView;
    private ImageView activityImageView;
    private ImageView carsRentalImageView;
    private ImageView movingImageView;
    private RecyclerViewPager offerRecyclerView;
    private TextView mHotelName;
    private TextView mHotelPrice;
    private ImageView mHotelRating;
    private TextView extraData;

    public MainViewHolder(View v) {
        super(v);
        mPrincipalTextView = (TextView) v.findViewById(R.id.travel_tittle);
        carouselView = (CarouselView) v.findViewById(R.id.carouselView);
        activityImageView = (ImageView) v.findViewById(R.id.activities_iv);
        carsRentalImageView = (ImageView) v.findViewById(R.id.carsrental_iv);
        movingImageView = (ImageView) v.findViewById(R.id.move_iv);
        offerRecyclerView = (RecyclerViewPager) v.findViewById(R.id.list);

    }

    public TextView getmTextView() {
        return mPrincipalTextView;
    }

    public TextView getmPrincipalTextView() {
        return mPrincipalTextView;
    }

    public CarouselView getCarouselView() {
        return carouselView;
    }

    public ImageView getActivityImageView() {
        return activityImageView;
    }

    public ImageView getCarsRentalImageView() {
        return carsRentalImageView;
    }

    public ImageView getMovingImageView() {
        return movingImageView;
    }

    public RecyclerViewPager getOfferRecyclerView() {
        return offerRecyclerView;
    }
}

