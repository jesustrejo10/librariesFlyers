package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

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

    public final static String TAG = TopDraggableActivity.class.getSimpleName();

    public final static int TIME_PANEL = 100;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.sliding_layout)
    SlidingUpPanelLayout mPanel;

    @Bind(R.id.main_layout)
    LinearLayout mMainLayout;

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Bind(R.id.layout_category)
    LinearLayout mCategoryLayout;

    @Bind(R.id.precios_layout)
    LinearLayout mPricesLayout;

    @Bind(R.id.scroll_view)
    NestedScrollView mScrollView;

    private OuterFilterAdapter mAdapter;

    private TopDraggableContract.Presenter mPresenter;

    private boolean mStatusPrices = Boolean.FALSE;
    private boolean mStatusCategory = Boolean.FALSE;

    @Override
    public int getLayout() {
        return R.layout.activity_top_draggable;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        setToolbar(mToolbar);
        setTitle(getResources().getString(R.string.hotels_available));

        mPresenter = new TopDraggablePresenter(this);
        setupPanel();

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
        switch (item.getItemId()) {
            case R.id.action_filter:
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPanel.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                    }
                }, TIME_PANEL);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        closeSlidingPanelFilterOrOder();
        super.onBackPressed();
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

//    @OnLongClick(R.id.layout_category)
//    public boolean clickLayoutCategory() {
//        if (!mStatusCategory) {
//            mCategoryLayout.setBackgroundColor(Color.parseColor("#d8d8d8"));
//            mStatusCategory = Boolean.TRUE;
//        } else {
//            mCategoryLayout.setBackgroundColor(Color.parseColor("#ffffff"));
//            mStatusCategory = Boolean.FALSE;
//        }
//        return false;
//    }
//
//    @OnLongClick(R.id.precios_layout)
//    public boolean clickLayoutPrice() {
//        if (!mStatusPrices) {
//            mPricesLayout.setBackgroundColor(Color.parseColor("#66afe9"));
//            mStatusPrices = Boolean.TRUE;
//        } else {
//            mPricesLayout.setBackgroundColor(Color.parseColor("#ffffff"));
//            mStatusPrices = Boolean.FALSE;
//        }
//        return false;
//    }

    @OnClick(R.id.main_layout)
    public void onClickLayoutMain() {
        setPanelState();
    }

    @OnClick(R.id.cancel)
    public void onClickCancelFilterOrOrder() {
        mAdapter.clearFilter();
        mAdapter.clearStatus();
        closeSlidingPanelFilterOrOder();
    }

    @OnClick(R.id.apply)
    public void onClickApplyFilterOrOrder() {
        closeSlidingPanelFilterOrOder();
        if (mAdapter != null) {
            if (mAdapter.getFilter() != null) {
                Toast.makeText(getApplicationContext(), "Filtros", Toast.LENGTH_SHORT).show();
            } else {
                Log.d(TAG, "Filter is null");
            }
        } else {
            Log.d(TAG, "Adapter is null");
        }
    }

    /**
     * Configuración del @{@link SlidingUpPanelLayout}
     */
    private void setupPanel() {
        mPanel.setDragView(mScrollView);
        mPanel.setTouchEnabled(false);
        mPanel.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPanelState();
            }
        });
    }

    /**
     * Cerrar filtro
     */
    private void setPanelState() {
        if (mPanel != null) mPanel.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
    }

    /**
     * Cerrar el panel de filtro
     */
    private void closeSlidingPanelFilterOrOder() {
        if (mPanel != null && (mPanel.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED || mPanel.getPanelState() == SlidingUpPanelLayout.PanelState.ANCHORED)) {
            mPanel.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        }
    }

}