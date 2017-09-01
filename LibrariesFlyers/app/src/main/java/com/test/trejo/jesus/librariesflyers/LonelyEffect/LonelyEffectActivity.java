package com.test.trejo.jesus.librariesflyers.LonelyEffect;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.RecyclerObject;
import com.test.trejo.jesus.librariesflyers.R;

import java.util.ArrayList;

public class LonelyEffectActivity extends AppCompatActivity implements OnMapReadyCallback {

    private ArrayList<RecyclerObject> mDataSet;
    private VerticalLonelyAdapter mAdapter;
    SlidingUpPanelLayout panel;
    LinearLayoutManager mLayoutManager;
    RecyclerView mRecyclerView;
    int status = 0;

    private Button backTolist;
    static final LatLng HAMBURG = new LatLng(53.558, 9.927);
    static final LatLng KIEL = new LatLng(53.551, 9.993);
    private GoogleMap map;
    private ImageView mapPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lonely_effect);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);


        RecyclerObject test = new RecyclerObject();
        mDataSet = new ArrayList<>();
        mDataSet.add(test);
        mDataSet.add(test);
        mDataSet.add(test);
        mDataSet.add(test);
        mDataSet.add(test);
        mDataSet.add(test);
        mDataSet.add(test);
        mAdapter = new VerticalLonelyAdapter(mDataSet);
        mapPreview = (ImageView) findViewById(R.id.map_preview);

        mapPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                panel.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);

            }
        });
        panel = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        panel.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {

            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
                System.out.println("estatus.");
                if (newState.name().equalsIgnoreCase("HIDDEN")) {
                    status = 1;
                }
                if (newState.name().equalsIgnoreCase("COLLAPSED")) {
                    status = 0;
                }
                if (newState.name().equalsIgnoreCase("EXPANDED") || newState.name().equalsIgnoreCase("DRAGGING")) {
                    mapPreview.setVisibility(View.GONE);
                    //panel.setActivated(false);
                    //mapPreview.setLayoutParams(new FrameLayout.LayoutParams(0, 0));

                }else{
                    mapPreview.setVisibility(View.VISIBLE);
                    //panel.setActivated(true);
                }

                if (newState.name().equalsIgnoreCase("EXPANDED")) {
                    backTolist.setVisibility(View.VISIBLE);
                    //mapPreview.setLayoutParams(new FrameLayout.LayoutParams(0, 0));

                }else{
                    backTolist.setVisibility(View.GONE);
                }
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        panel.setScrollableView(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                int pastVisibleItems = mLayoutManager.findFirstVisibleItemPosition();

                if (pastVisibleItems == 0) {

                    if (status != 0) {
                        panel.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                    }
                    
                } else {

                //    if ((status != 1) || ( !panel.getPanelState().name().equalsIgnoreCase("HIDDEN")) )
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //Do something after 1000ms
                            panel.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN);
                        }
                    }, 100);
                }

            }
        });

        backTolist = (Button) findViewById(R.id.button);
        backTolist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                panel.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

            }
        });

    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        LatLng sydney = new LatLng(-33.867, 151.206);
        LatLng sydney2 = new LatLng(-33.867, 150.206);
        map = googleMap;

        googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                // Make a snapshot when map's done loading
                googleMap.snapshot(new GoogleMap.SnapshotReadyCallback() {
                    @Override
                    public void onSnapshotReady(Bitmap bitmap) {
                        //mapPreview.setLayoutParams(new FrameLayout.LayoutParams(
                          //      ViewGroup.LayoutParams.MATCH_PARENT,
                            //    160));
                        mapPreview.setImageBitmap(bitmap);

                        // If map won't be used afterwards, remove it's views
//              ((FrameLayout)findViewById(R.id.map)).removeAllViews();
                    }
                });
            }
        });

/*
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            System.out.println("holamundo");
            return;
        }
  */
        //googleMap.setMyLocationEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));

        googleMap.addMarker(new MarkerOptions()
                .title("Sydney")
                .snippet("The most populous city in Australia.")
                .position(sydney));
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }    }

}

