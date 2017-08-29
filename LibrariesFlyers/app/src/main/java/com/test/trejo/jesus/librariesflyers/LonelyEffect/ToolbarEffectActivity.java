package com.test.trejo.jesus.librariesflyers.LonelyEffect;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.test.trejo.jesus.librariesflyers.R;

/**
 * Created by alexis on 24/08/17.
 */

public class ToolbarEffectActivity extends AppCompatActivity {

    CollapsingToolbarLayout collapsing_container;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_effect);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Doctor Strange");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        setSupportActionBar(toolbar);
        collapsing_container = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsing_container.setTitle("Titulo1");


    }
}
