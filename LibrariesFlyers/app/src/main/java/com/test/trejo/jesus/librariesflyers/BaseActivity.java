package com.test.trejo.jesus.librariesflyers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

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

    public void setToolbar(@NonNull Toolbar toolBar) {
        setSupportActionBar(toolBar);
        mToolbar = toolBar;
        haveToolbar = true;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
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

    /**
     * @return Vista que retorna desde una vista hija
     */
    abstract public int getLayout();

    /**
     * @param savedInstanceState @{@link Bundle} de una actividad
     */
    abstract public void onCreateView(Bundle savedInstanceState);

}