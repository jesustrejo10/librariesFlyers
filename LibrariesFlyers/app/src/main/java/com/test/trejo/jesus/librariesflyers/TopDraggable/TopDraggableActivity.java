package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.test.trejo.jesus.librariesflyers.BaseActivity;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.Models.RecyclerObject;
import com.test.trejo.jesus.librariesflyers.R;
import com.test.trejo.jesus.librariesflyers.TopDraggable.presenter.TopDraggablePresenter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

public class TopDraggableActivity extends BaseActivity implements TopDraggableContract.View {

    public final static int TIME_PANEL = 100;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.sliding_layout)
    SlidingUpPanelLayout mPanel;

    @Bind(R.id.main_layout)
    LinearLayout mMainLayout;

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Bind(R.id.general_layout)
    LinearLayout mBarLayout;

    @Bind(R.id.rangeSeekbar1)
    CrystalRangeSeekbar rangeSeekbar;

    @Bind(R.id.minimo)
    TextView tvMin;

    @Bind(R.id.maximo)
    TextView tvMax;

    private OuterFilterAdapter mAdapter;

    private TopDraggableContract.Presenter mPresenter;

    @Override
    public int getLayout() {
        return R.layout.activity_top_draggable;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        setToolbar(mToolbar);
        setTitle(getResources().getString(R.string.hotels_available));

        mPanel.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPanelState();
            }
        });

        mPresenter = new TopDraggablePresenter(this);

//        this.manageRecyclerView();

    }


    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
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
                }, TIME_PANEL);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void setPresenter(@NonNull TopDraggableContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setLoadRecycler(@NonNull ArrayList<RecyclerObject> mDataSet) {
        mAdapter = new OuterFilterAdapter(mDataSet, getApplicationContext());
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void setRangeBar() {
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.format("%s%s", getResources().getString(R.string.from), String.valueOf(minValue)));
                tvMax.setText(String.format("%s%s", getResources().getString(R.string.to), String.valueOf(maxValue)));
            }
        });

        rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
            }
        });
    }

    @Override
    public void setLayouts() {

    }


    @OnClick(R.id.main_layout)
    public void onClickLayoutMain() {
        setPanelState();
    }

    @OnClick(R.id.general_layout)
    public void onClickGeneralLayout() {

    }

    private void setPanelState() {
        if (mPanel != null) {
            mPanel.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        }
        throw new NullPointerException("SlidingUpPanelLayout tiene que se diferente de nulo");
    }
}