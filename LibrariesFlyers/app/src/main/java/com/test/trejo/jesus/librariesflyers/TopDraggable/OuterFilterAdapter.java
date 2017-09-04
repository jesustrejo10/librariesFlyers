package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        // create a new view

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.outer_filter_item, parent, false);

        final OuterFilterViewHolder vh = new OuterFilterViewHolder(v);

        mInnerFilterAdapter = new InnerFilterAdapter(mDataSet);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        vh.getmRecyclerView().setLayoutManager(mLayoutManager);
        vh.mRecyclerView.setAdapter(mInnerFilterAdapter);

        return vh;
    }

    @Override
    public void onBindViewHolder(final OuterFilterViewHolder holder, int position) {

        holder.getmFullLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //here i need to show and hide the sub list.
                if (listStatus){
                    holder.getmRecyclerView().setVisibility(View.GONE);
                    listStatus = false;
                }
                else{
                    holder.getmRecyclerView().setVisibility(View.VISIBLE);
                    listStatus = true;
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mDataSet.size();
    }


}