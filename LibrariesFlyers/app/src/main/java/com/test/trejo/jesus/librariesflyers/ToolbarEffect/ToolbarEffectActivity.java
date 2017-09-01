package com.test.trejo.jesus.librariesflyers.ToolbarEffect;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.test.trejo.jesus.librariesflyers.R;

/**
 * Created by alexis on 24/08/17.
 */

public class ToolbarEffectActivity extends AppCompatActivity implements OnMapReadyCallback {

    CollapsingToolbarLayout collapsing_container;
    Toolbar toolbar;
    LinearLayout mToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_alternative);
        mToolbarLayout = (LinearLayout) findViewById(R.id.toolbar_layout);


        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

/*
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Salones Vip seleccionados");
*/
        /*
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Doctor Strange");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        setSupportActionBar(toolbar);
        collapsing_container = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsing_container.setTitle("Titulo1");
        */

        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
                    // Collapsed
                    mToolbarLayout.setVisibility(View.VISIBLE);
                    System.out.println("collapsed");
                } else if (verticalOffset == 0) {
                    mToolbarLayout.setVisibility(View.GONE);
                    System.out.println("expanded");
                } else {
                    // Somewhere in between
                }
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng sydney = new LatLng(-33.867, 151.206);
        LatLng sydney2 = new LatLng(-33.867, 150.206);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));

        googleMap.addMarker(new MarkerOptions()
                .title("Sydney")
                .snippet("The most populous city in Australia.")
                .position(sydney));
    }
}
