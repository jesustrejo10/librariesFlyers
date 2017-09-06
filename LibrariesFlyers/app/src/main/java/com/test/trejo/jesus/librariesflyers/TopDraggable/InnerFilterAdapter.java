package com.test.trejo.jesus.librariesflyers.TopDraggable;

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

public class InnerFilterAdapter extends RecyclerView.Adapter<InnerFilterViewHolder> {

    private ArrayList<RecyclerObject> mDataSet;
    private int id;

    public InnerFilterAdapter(ArrayList<RecyclerObject> mDataset) {
        this.mDataSet = mDataset;
    }

    public InnerFilterAdapter(int id) {
        this.id = id;
    }

    @Override
    public InnerFilterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inner_filter_item, parent, false);
        return new InnerFilterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InnerFilterViewHolder holder, int position) {

        if (id == 1) {
            showStatusVisivility(holder.mContainerChecBox, View.VISIBLE);
            showStatusVisivility(holder.mContainerSeekbar, View.GONE);
        } else {
            if (id == 2) {
                showStatusVisivility(holder.mContainerChecBox, View.GONE);
                showStatusVisivility(holder.mContainerSeekbar, View.VISIBLE);
            }
        }


//        holder.getmTextView().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("holamundo");
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    private void showStatusVisivility(LinearLayout linearLayoutm, int status) {
        linearLayoutm.setVisibility(status);
    }


}