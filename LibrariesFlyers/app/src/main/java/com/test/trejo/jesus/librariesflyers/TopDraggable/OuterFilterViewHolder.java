package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.test.trejo.jesus.librariesflyers.R;

import butterknife.Bind;

/**
 * Created by jesus on 29/08/17.
 */

public class OuterFilterViewHolder extends RecyclerView.ViewHolder {

    // each data item is just a string in this case
    public TextView mTextView;
    public ImageView mImageView;
    public RecyclerView mRecyclerView;
    private LinearLayout mFullLayout;
    public LinearLayout click;
    LinearLayout mContainerFilterStar;
    LinearLayout mContainerFilterPrice;

    RatingBar ratingBar;

    CrystalRangeSeekbar rangeSeekbar;
    TextView tvMin;
    TextView tvMax;

    public OuterFilterViewHolder(View v) {
        super(v);
        mTextView = (TextView) v.findViewById(R.id.detail_name);
        mImageView = (ImageView) v.findViewById(R.id.expand_icon);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mFullLayout = (LinearLayout) v.findViewById(R.id.full_layout);
        click = (LinearLayout) v.findViewById(R.id.click);
        mContainerFilterStar = (LinearLayout) v.findViewById(R.id.filter_star);
        mContainerFilterPrice = (LinearLayout) v.findViewById(R.id.filter_price);
        ratingBar = (RatingBar) v.findViewById(R.id.ratingBar);

        rangeSeekbar = (CrystalRangeSeekbar) v.findViewById(R.id.rangeSeekbar1);
        tvMin = (TextView) v.findViewById(R.id.minimo);
        tvMax = (TextView) v.findViewById(R.id.maximo);
    }

    public TextView getmTextView() {
        return mTextView;
    }

    public ImageView getmImageView() {
        return mImageView;
    }

    public RecyclerView getmRecyclerView() {
        return mRecyclerView;
    }

    public LinearLayout getmFullLayout() {
        return mFullLayout;
    }
}