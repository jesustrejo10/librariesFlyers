package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.trejo.jesus.librariesflyers.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jesus on 29/08/17.
 */

public class InnerFilterViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case

    LinearLayout mContainerCheck;


    LinearLayout mContainerSeekbar;

    @Bind(R.id.detail_name)
    TextView mTextView;

    @Bind(R.id.checkbox)
    CheckBox mCheckBox;

    public InnerFilterViewHolder(View v) {
        super(v);
        ButterKnife.bind(this, v);
    }

    public TextView getmTextView() {
        return mTextView;
    }
}