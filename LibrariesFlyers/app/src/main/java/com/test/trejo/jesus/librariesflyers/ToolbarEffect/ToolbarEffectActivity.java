package com.test.trejo.jesus.librariesflyers.ToolbarEffect;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alexvasilkov.gestures.views.GestureImageView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.test.trejo.jesus.librariesflyers.R;

/**
 * Created by alexis on 24/08/17.
 */

public class ToolbarEffectActivity extends AppCompatActivity implements OnMapReadyCallback {
    private ImageView mapPreview;
    private GestureImageView mapPreviewFull;
    private MapView mapView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_alternative);

        final LinearLayout toolbarContent = findViewById(R.id.toolbar_layout);
        final TextView toolbarTitle = findViewById(R.id.toolbar_title);
        final FrameLayout mapFullLayout = findViewById(R.id.maps_full_layout);
        final Button closeMapButton = findViewById(R.id.close_map_button);
        final CoordinatorLayout coordinator = findViewById(R.id.coordinator);

        mapPreview = findViewById(R.id.map_image);
        mapPreviewFull = findViewById(R.id.map_preview_full);

        mapPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapFullLayout.setVisibility(View.VISIBLE);
                coordinator.setVisibility(View.GONE);
            }
        });

        closeMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapFullLayout.setVisibility(View.GONE);
                coordinator.setVisibility(View.VISIBLE);
            }
        });

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowTitleEnabled(false);
        }

        final MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);


        AppBarLayout appBarLayout = findViewById(R.id.app_bar_layout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
                    // Collapsed
                    toolbarTitle.setVisibility(View.GONE);
                    toolbarContent.setVisibility(View.VISIBLE);
                    toolbar.setBackgroundColor(getResources().getColor(R.color.black));
                } else if (verticalOffset == 0) {
                    toolbarTitle.setVisibility(View.VISIBLE);
                    toolbarContent.setVisibility(View.GONE);
                } else {
                    toolbar.setBackgroundColor(getResources().getColor(R.color.flyers_primary));
                }
            }
        });
    }

      @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tab_activity_action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        LatLng sydney = new LatLng(-33.867, 151.206);

        googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                // Make a snapshot when map's done loading
                googleMap.snapshot(new GoogleMap.SnapshotReadyCallback() {
                    @Override
                    public void onSnapshotReady(Bitmap bitmap) {
                        mapPreview.setImageBitmap(bitmap);
                    }
                });
            }
        });

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));

        googleMap.addMarker(new MarkerOptions()
                .title("Sydney")
                .snippet("The most populous city in Australia.")
                .position(sydney));
    }
}
