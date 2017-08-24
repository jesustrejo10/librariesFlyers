package com.test.trejo.jesus.librariesflyers.HorizontalRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.test.trejo.jesus.librariesflyers.R;

/**
 * Created by jesus on 22/08/17.
 */

public class HorizontalViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView mTextView;

    public HorizontalViewHolder(View v) {
        super(v);
        mTextView = (TextView) v.findViewById(R.id.id);
    }

    public TextView getmTextView() {
        return mTextView;
    }
}
