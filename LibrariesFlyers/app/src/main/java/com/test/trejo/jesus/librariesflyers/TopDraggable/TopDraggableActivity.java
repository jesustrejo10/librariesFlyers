package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.RecyclerObject;
import com.test.trejo.jesus.librariesflyers.LonelyEffect.VerticalLonelyAdapter;
import com.test.trejo.jesus.librariesflyers.R;

import java.util.ArrayList;

public class TopDraggableActivity extends AppCompatActivity {

    SlidingUpPanelLayout mPanel;
    LinearLayout mMainLayout;
    RecyclerView mRecyclerView;
    ArrayList<RecyclerObject> mDataSet;
    OuterFilterAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_draggable);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hoteles Disponibles");

        mPanel= (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        mMainLayout = (LinearLayout) findViewById(R.id.main_layout);
        mMainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPanel.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        });
        mPanel.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPanel.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        manageRecyclerView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.draggable_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_filter:
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Do something after 1000ms
                        mPanel.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                    }
                }, 100);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void manageRecyclerView(){

        RecyclerObject test = new RecyclerObject();
        mDataSet = new ArrayList<>();
        mDataSet.add(test);
        mDataSet.add(test);
        mDataSet.add(test);
        mDataSet.add(test);
        mAdapter = new OuterFilterAdapter(mDataSet,getApplicationContext());

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
    
}


