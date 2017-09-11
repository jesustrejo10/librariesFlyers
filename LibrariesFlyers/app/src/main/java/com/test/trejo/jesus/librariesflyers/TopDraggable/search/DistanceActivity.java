package com.test.trejo.jesus.librariesflyers.TopDraggable.search;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.test.trejo.jesus.librariesflyers.BaseActivity;
import com.test.trejo.jesus.librariesflyers.R;

import butterknife.Bind;

public class DistanceActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    public int getLayout() {
        return R.layout.activity_distance;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        setToolbar(mToolbar);
        setTitle(getResources().getString(R.string.hotels_available));
    }
}