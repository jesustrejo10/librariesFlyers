package com.test.trejo.jesus.librariesflyers.ToolbarEffect;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alexvasilkov.gestures.Settings;
import com.alexvasilkov.gestures.animation.ViewPositionAnimator;
import com.alexvasilkov.gestures.transition.GestureTransitions;
import com.alexvasilkov.gestures.transition.ViewsTransitionAnimator;
import com.alexvasilkov.gestures.views.GestureImageView;
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
    private ImageView mapPreview;
    private GestureImageView mapPreviewFull;
    private Toolbar toolbar;
    private ViewsTransitionAnimator animator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_alternative);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowTitleEnabled(false);
        }

        final MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        initViews();

        configureToolbarBehavior();
    }

    private void initViews() {
        final FrameLayout mapFullLayout = findViewById(R.id.maps_full_layout);
        final Button closeMapButton = findViewById(R.id.close_map_button);
        final CoordinatorLayout coordinator = findViewById(R.id.coordinator);

        mapPreview = findViewById(R.id.map_image);
        mapPreviewFull = findViewById(R.id.map_preview_full);

        mapPreviewFull.getController().getSettings()
                .setPanEnabled(false)
                .setZoomEnabled(false)
                .setDoubleTapEnabled(false)
                .setRotationEnabled(false)
                .setRestrictRotation(false)
                .setOverscrollDistance(this, 0f, 0f)
                .setOverzoomFactor(1f)
                .setExitEnabled(false)
                .setFillViewport(true)
                .setFitMethod(Settings.Fit.VERTICAL)
                .setGravity(Gravity.CENTER)
                .setAnimationsDuration(Settings.ANIMATIONS_DURATION);

        mapPreviewFull.getPositionAnimator().addPositionUpdateListener(new ViewPositionAnimator.PositionUpdateListener() {
            @Override
            public void onPositionUpdate(float position, boolean isLeaving) {
                if (position == 1) {
                    mapFullLayout.setVisibility(View.VISIBLE);
                    mapPreviewFull.setVisibility(View.GONE);
                    coordinator.setVisibility(View.GONE);
                } else if (isLeaving) {
                    mapPreviewFull.setVisibility(View.VISIBLE);
                    coordinator.setVisibility(View.VISIBLE);
                    mapFullLayout.setVisibility(View.GONE);
                }
            }
        });

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
                mapPreviewFull.getPositionAnimator().exit(true);
            }
        });

        GesturesDetectorListener gesturesDetectorListener = new GesturesDetectorListener() {
            @Override
            public boolean onDoubleTap(MotionEvent motionEvent) {
                Log.d("NELSON", "onDoubleTap");
                openFullImage();
                return true;
            }

            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                double defaultScaleFactor = 1;
                Log.d("NELSON", "onScale - detector.getScaleFactor() = " + detector.getScaleFactor());
                if (detector.getScaleFactor() > defaultScaleFactor) {
                    openFullImage();
                }
                return true;
            }
        };

        final GestureDetector gestureDetector = new GestureDetector(this, gesturesDetectorListener);
        gestureDetector.setOnDoubleTapListener(gesturesDetectorListener);

        final ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(this, gesturesDetectorListener);


        mapPreview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                scaleGestureDetector.onTouchEvent(event);
                return true;
            }
        });

        animator = GestureTransitions.from(mapPreview).into(mapPreviewFull);

        animator.addPositionUpdateListener(new ViewPositionAnimator.PositionUpdateListener() {
            @Override
            public void onPositionUpdate(float position, boolean isLeaving) {
                if (position == 0f && isLeaving)
                    mapPreviewFull.setVisibility(View.INVISIBLE);
                else
                    mapPreviewFull.setVisibility(View.VISIBLE);
            }
        });
    }

    private void openFullImage() {
        // Setting image drawable from 'from' view to 'to' to prevent flickering
        if (mapPreviewFull.getDrawable() == null) {
            mapPreviewFull.setImageDrawable(mapPreview.getDrawable());
        }

        // Updating gesture image settings
        mapPreviewFull.getController().resetState();

        animator.enterSingle(true);
    }

    private void configureToolbarBehavior() {
        final LinearLayout toolbarContent = findViewById(R.id.toolbar_layout);
        final TextView toolbarTitle = findViewById(R.id.toolbar_title);
        final AppBarLayout appBarLayout = findViewById(R.id.app_bar_layout);

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
        if (item.getItemId() == android.R.id.home) {
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
