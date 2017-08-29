package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.HorizontalViewHolder;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.RecyclerObject;
import com.test.trejo.jesus.librariesflyers.R;

import java.util.ArrayList;

/**
 * Created by jesus on 29/08/17.
 */

public class InnerFilterAdapter extends RecyclerView.Adapter<InnerFilterViewHolder> {

    private ArrayList<RecyclerObject> mDataSet;

    public InnerFilterAdapter(ArrayList<RecyclerObject> mDataset) {
        this.mDataSet = mDataset;
    }

    @Override
    public InnerFilterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inner_filter_item, parent, false);
        InnerFilterViewHolder vh = new InnerFilterViewHolder(v);
        return vh;

    }


    @Override
    public void onBindViewHolder(InnerFilterViewHolder holder, int position) {

        holder.getmTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("holamundo");
            }
        });

    }


    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

}