package com.test.trejo.jesus.librariesflyers.ToolbarEffect;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
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
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.test.trejo.jesus.librariesflyers.R;


/**
 * Created by alexis on 24/08/17.
 */

public class ToolbarEffectActivity extends AppCompatActivity implements OnMapReadyCallback {
    private int[] sampleImages = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4, R.drawable.slide};

    private ImageView mapPreview;
    private GestureImageView mapPreviewFull;
    private ViewsTransitionAnimator animator;
    private FrameLayout mapFullLayout;
    private Button closeMapButton;
    private Button buyButton;
    private CoordinatorLayout coordinator;
    private CarouselView carouselView;
    private TextView toolbarHotelName;
    private RatingBar toolbarStars;
    private TextView hotelName;
    private RatingBar stars;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_alternative);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final LinearLayout toolbarContent = (LinearLayout) findViewById(R.id.toolbar_layout);
        final TextView toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        final AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);

        appBarLayout.addOnOffsetChangedListener(new ToolbarOffsetListener(toolbar, toolbarContent, toolbarTitle));
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        mapFullLayout = (FrameLayout) findViewById(R.id.maps_full_layout);
        buyButton = (Button) findViewById(R.id.buy_button);
        closeMapButton = (Button) findViewById(R.id.close_map_button);
        coordinator = (CoordinatorLayout) findViewById(R.id.coordinator);
        mapPreview = (ImageView) findViewById(R.id.map_image);
        mapPreviewFull = (GestureImageView) findViewById(R.id.map_preview_full);
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        toolbarHotelName = (TextView) findViewById(R.id.toolbar_hotel_name);
        toolbarStars = (RatingBar) findViewById(R.id.toolbar_stars);
        hotelName = (TextView) findViewById(R.id.hotel_name);
        stars = (RatingBar) findViewById(R.id.stars);

        initViews();

        final MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void initViews() {
        final String hotelNameText = "Star Alliance Lounge Buenos Aires";
        final float rating = 5.0f;

        toolbarHotelName.setText(hotelNameText);
        hotelName.setText(hotelNameText);

        toolbarStars.setRating(rating);
        stars.setRating(rating);

        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        });

        mapPreviewFull.getController().getSettings()
                .setPanEnabled(false)
                .setZoomEnabled(false)
                .setDoubleTapEnabled(false)
                .setOverscrollDistance(this, 0f, 0f)
                .setOverzoomFactor(1f)
                .setExitEnabled(false)
                .setFitMethod(Settings.Fit.VERTICAL)
                .setAnimationsDuration(Settings.ANIMATIONS_DURATION);

        final GesturesDetectorListener listener = getNewGesturesDetectorListener();

        final GestureDetector gestureDetector = new GestureDetector(this, listener);
        gestureDetector.setOnDoubleTapListener(listener);

        final ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(this, listener);

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
                final boolean animationFinishedInInitialView = (position == 0f) && isLeaving;
                final boolean animationFinishedInFinalView = (position == 1f) && !isLeaving;

                if (animationFinishedInInitialView) {
                    mapPreviewFull.setVisibility(View.GONE);
                    buyButton.setVisibility(View.VISIBLE);
                } else if (animationFinishedInFinalView) {
                    mapFullLayout.setVisibility(View.VISIBLE);
                    coordinator.setVisibility(View.GONE);
                    mapPreviewFull.setVisibility(View.GONE);
                } else if (isLeaving) {
                    mapFullLayout.setVisibility(View.GONE);
                    coordinator.setVisibility(View.VISIBLE);
                    mapPreviewFull.setVisibility(View.VISIBLE);
                } else {
                    mapPreviewFull.setVisibility(View.VISIBLE);
                    buyButton.setVisibility(View.GONE);
                }
            }
        });

        closeMapButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                animator.exit(true);
            }
        });
    }

    @NonNull
    private GesturesDetectorListener getNewGesturesDetectorListener() {
        return new GesturesDetectorListener() {
            @Override
            public boolean onDoubleTap(MotionEvent motionEvent) {
                openFullMap();
                return true;
            }

            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                openFullMapWhenZoomIn(detector);
                return true;
            }

            private void openFullMapWhenZoomIn(ScaleGestureDetector detector) {
                final double defaultScaleFactor = 1;
                if (detector.getScaleFactor() > defaultScaleFactor) {
                    openFullMap();
                }
            }
        };
    }

    private void openFullMap() {
        // Setting image drawable from mapPreviewView to mapPreviewFullView to prevent flickering
        if (mapPreviewFull.getDrawable() == null) {
            mapPreviewFull.setImageDrawable(mapPreview.getDrawable());
        }

        // Updating gesture image settings
        mapPreviewFull.getController().resetState();

        animator.enterSingle(true);
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
