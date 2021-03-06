package com.test.trejo.jesus.librariesflyers.LonelyEffect;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.HorizontalViewHolder;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.Models.RecyclerObject;
import com.test.trejo.jesus.librariesflyers.R;

import java.util.ArrayList;

/**
 * Created by jesus on 24/08/17.
 */

public class VerticalLonelyAdapter  extends RecyclerView.Adapter<HorizontalViewHolder> {

    private ArrayList<RecyclerObject> mDataSet;

    public VerticalLonelyAdapter(ArrayList<RecyclerObject> mDataset) {
        this.mDataSet = mDataset;
    }

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizontal_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        HorizontalViewHolder vh = new HorizontalViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, int position) {

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