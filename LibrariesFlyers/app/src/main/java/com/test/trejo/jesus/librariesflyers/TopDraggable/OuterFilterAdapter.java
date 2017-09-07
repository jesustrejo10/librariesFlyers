package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.Models.RecyclerObject;
import com.test.trejo.jesus.librariesflyers.R;
import com.test.trejo.jesus.librariesflyers.widget.ApplyStyleRatingBar;

import java.util.ArrayList;

/**
 * Created by jesus on 29/08/17.
 */

public class OuterFilterAdapter extends RecyclerView.Adapter<OuterFilterViewHolder> {

    private ArrayList<RecyclerObject> mDataSet;
    private InnerFilterAdapter mInnerFilterAdapter;
    private Context mContext;

    private boolean listStatus = false;

    public OuterFilterAdapter(ArrayList<RecyclerObject> mDataset, Context context) {
        this.mDataSet = mDataset;
        this.mContext = context;
    }

    @Override
    public OuterFilterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.outer_filter_item, parent, false);
        return new OuterFilterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final OuterFilterViewHolder holder, final int position) {
        holder.getmTextView().setText(mDataSet.get(position).getDescription());
//        ApplyStyleRatingBar.setRatingBarStarsColor(holder.ratingBar, mContext);
        holder.getmFullLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDataSet.get(position).getId() == 1) {
                    showStatusVisivility(holder.mContainerFilterStar, View.VISIBLE);
                } else {

                    showStatusVisivility(holder.mContainerFilterPrice, View.VISIBLE);

                    holder.rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
                        @Override
                        public void valueChanged(Number minValue, Number maxValue) {
                            holder.tvMin.setText(String.format("%s%s", mContext.getResources().getString(R.string.from), String.valueOf(minValue)));
                            holder.tvMax.setText(String.format("%s%s", mContext.getResources().getString(R.string.to), String.valueOf(maxValue)));
                        }
                    });

                    holder.rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
                        @Override
                        public void finalValue(Number minValue, Number maxValue) {
                            Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
                        }
                    });
                }

                if (listStatus) {
                    holder.getmImageView().animate().rotation(360).start();
                    holder.click.setVisibility(View.GONE);
                    listStatus = false;
                } else {
                    holder.getmImageView().animate().rotation(180).start();
                    holder.click.setVisibility(View.VISIBLE);
                    listStatus = true;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    private void showStatusVisivility(LinearLayout linearLayoutm, int status) {
        linearLayoutm.setVisibility(status);
    }

}