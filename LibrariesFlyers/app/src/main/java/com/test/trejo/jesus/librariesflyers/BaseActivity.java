package com.test.trejo.jesus.librariesflyers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by roger on 06/09/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private boolean haveToolbar;
    private Toolbar mToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        onCreateView(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public void setToolbar(Toolbar toolBar) {
        if (toolBar != null) {
            setSupportActionBar(toolBar);
            mToolbar = toolBar;
            haveToolbar = true;
        }
    }

    @Override
    public void setTitle(int titleId) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(titleId);
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void showToolbar() {
        if ((getSupportActionBar() != null) && haveToolbar) {
            setToolbar(mToolbar);
            mToolbar.setVisibility(View.VISIBLE);
        }
    }

    public void hideToolbar() {
        if ((getSupportActionBar() != null) && haveToolbar) {
            mToolbar.setVisibility(View.GONE);
        }
    }

    abstract public int getLayout();

    abstract public void onCreateView(Bundle savedInstanceState);

}