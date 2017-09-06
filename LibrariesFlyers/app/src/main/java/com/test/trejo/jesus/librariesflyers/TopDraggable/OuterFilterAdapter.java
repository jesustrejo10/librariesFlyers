package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.Models.RecyclerObject;
import com.test.trejo.jesus.librariesflyers.R;

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
        holder.getmFullLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //here i need to show and hide the sub list.

                if (mDataSet.get(position).getId() == 1) {
                    showStatusVisivility(holder.mContainerChecBox, View.VISIBLE);
                    showStatusVisivility(holder.mContainerSeekbar, View.GONE);
                } else {
                    showStatusVisivility(holder.mContainerChecBox, View.GONE);
                    showStatusVisivility(holder.mContainerSeekbar, View.VISIBLE);
                }

                if (listStatus) {
                    holder.click.setVisibility(View.GONE);
                    listStatus = false;
                } else {
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