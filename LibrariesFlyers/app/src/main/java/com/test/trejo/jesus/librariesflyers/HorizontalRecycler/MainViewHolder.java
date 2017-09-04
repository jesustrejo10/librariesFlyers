package com.test.trejo.jesus.librariesflyers.HorizontalRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.test.trejo.jesus.librariesflyers.R;

/**
 * Created by jesus on 04/09/17.
 */

public class MainViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    private TextView mPrincipalTextView;
    private CarouselView carouselView;
    private ImageView activityImageView;
    private ImageView carsRentalImageView;
    private ImageView TranlationImageView;
    private RecyclerView offerRecyclerView;

    public MainViewHolder(View v) {
        super(v);


    }

    public TextView getmTextView() {
        return mPrincipalTextView;
    }
}
