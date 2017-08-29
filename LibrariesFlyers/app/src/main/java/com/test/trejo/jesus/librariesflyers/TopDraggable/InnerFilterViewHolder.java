package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.test.trejo.jesus.librariesflyers.R;

/**
 * Created by jesus on 29/08/17.
 */

public class InnerFilterViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView mTextView;
    public CheckBox mCheckBox;


    public InnerFilterViewHolder(View v) {
        super(v);
        mTextView = (TextView) v.findViewById(R.id.detail_name);
        mCheckBox = (CheckBox) v.findViewById(R.id.checkbox);
    }

    public TextView getmTextView() {
        return mTextView;
    }
}