package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.test.trejo.jesus.librariesflyers.BaseActivity;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.Models.RecyclerObject;
import com.test.trejo.jesus.librariesflyers.R;
import com.test.trejo.jesus.librariesflyers.TopDraggable.presenter.TopDraggablePresenter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;
import butterknife.OnLongClick;

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

    @Bind(R.id.layout_categoria)
    LinearLayout mCategoryLayout;

    @Bind(R.id.precios_layout)
    LinearLayout mPricesLayout;

    private OuterFilterAdapter mAdapter;

    private TopDraggableContract.Presenter mPresenter;

    private boolean statusPrices = Boolean.FALSE;
    private boolean statusCategory = Boolean.FALSE;

    @Override
    public int getLayout() {
        return R.layout.activity_top_draggable;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        setToolbar(mToolbar);
        setTitle(getResources().getString(R.string.hotels_available));

        mPresenter = new TopDraggablePresenter(this);//Instanciar e inyectar vista

        mPanel.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPanelState();
            }
        });

//        mPanel.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
//            @Override
//            public void onPanelSlide(View panel, float slideOffset) {
//                if (panel.getPaddingBottom() != 0) {
//                    panel.setPadding(panel.getPaddingLeft(), panel.getPaddingTop(), panel.getPaddingRight(), 0);
//                }
//            }
//
//            @Override
//            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
//                int paddingPx = (int) getPixels(TypedValue.COMPLEX_UNIT_DIP, 50);
//                panel.setPadding(panel.getPaddingLeft(), panel.getPaddingTop(), panel.getPaddingRight(), 100);
//            }
//        });

    }

    public static float getPixels(int unit, float size) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return TypedValue.applyDimension(unit, size, metrics);
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

    }

    @OnLongClick(R.id.layout_categoria) // Para evitar el setOnLongClickListener
    public boolean clickLayoutCategory() {
        if (!statusCategory) {
            mCategoryLayout.setBackgroundColor(Color.parseColor("#d8d8d8"));
            statusCategory = true;
        } else {
            mCategoryLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            statusCategory = false;
        }
        return false;
    }

    @OnLongClick(R.id.precios_layout)
    public boolean clickLayoutPrice() {
        if (!statusPrices) {
            mPricesLayout.setBackgroundColor(Color.parseColor("#66afe9"));
            statusPrices = true;
        } else {
            mPricesLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            statusPrices = false;
        }
        return false;
    }

    @OnClick(R.id.main_layout) // Para evitar el setOnClickListener
    public void onClickLayoutMain() {
        setPanelState();
    }

    private void setPanelState() {
        if (mPanel != null) {
            mPanel.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        }
        throw new NullPointerException("SlidingUpPanelLayout tiene que se diferente de nulo");
    }
}