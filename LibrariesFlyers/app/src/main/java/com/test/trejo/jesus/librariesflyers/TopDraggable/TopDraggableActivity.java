package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
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
    LinearLayout mBarLayout;
    LinearLayout mPricesLayout;
    LinearLayout mCategoryLayout;
    boolean statusPrices = false;
    boolean statusCategory = false;

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
        manageRangeBar();
        manageLayouts();
    }

    private void manageLayouts() {
        mCategoryLayout = (LinearLayout) findViewById(R.id.layout_categoria);
        mPricesLayout = (LinearLayout) findViewById(R.id.precios_layout);

        mCategoryLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if ( !statusCategory){
                    mCategoryLayout.setBackgroundColor(Color.parseColor("#d8d8d8"));
                    statusCategory = true;
                }
                else {
                    mCategoryLayout.setBackgroundColor(Color.parseColor("#ffffff"));
                    statusCategory = false;
                }
                return false;
            }
        });

        mPricesLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if ( !statusPrices){
                    mPricesLayout.setBackgroundColor(Color.parseColor("#66afe9"));
                    statusPrices = true;
                }
                else {
                    mPricesLayout.setBackgroundColor(Color.parseColor("#ffffff"));
                    statusPrices = false;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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

    private void manageRangeBar() {
        mBarLayout = ( LinearLayout) findViewById(R.id.general_layout);
        mBarLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) findViewById(R.id.rangeSeekbar1);

        final TextView tvMin = (TextView) findViewById(R.id.minimo);
        final TextView tvMax = (TextView) findViewById(R.id.maximo);

        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText("Desde $"+String.valueOf(minValue));
                tvMax.setText("Hasta $"+String.valueOf(maxValue));
            }
        });

        rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
            }
        });
    }

}
