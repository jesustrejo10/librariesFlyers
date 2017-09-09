package com.test.trejo.jesus.librariesflyers.TopDraggable.search;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.test.trejo.jesus.librariesflyers.BaseActivity;
import com.test.trejo.jesus.librariesflyers.R;
import com.test.trejo.jesus.librariesflyers.utils.ExpandableOpenClose;
import com.test.trejo.jesus.librariesflyers.utils.StatesPanel;

import butterknife.Bind;
import butterknife.OnClick;

public class SearchHotelActivity extends BaseActivity {

    public final static String TAG = SearchHotelActivity.class.getSimpleName();

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.sliding_layout)
    SlidingUpPanelLayout mPanel;

    @Bind(R.id.scroll_view)
    ScrollView mScrollView;

    @Bind(R.id.expandableLayoutStart)
    ExpandableRelativeLayout expandableLayoutStart;

    @Bind(R.id.expandableLayoutPrice)
    ExpandableRelativeLayout expandableLayoutPrice;

    @Bind(R.id.expandableLayoutService)
    ExpandableRelativeLayout expandableLayoutService;

    @Bind(R.id.expandableLayoutRegime)
    ExpandableRelativeLayout expandableLayoutRegime;

    @Bind(R.id.expandableLayoutHotelShain)
    ExpandableRelativeLayout expandableLayoutHotelShain;

    @Bind(R.id.expandableLayoutPriceOrder)
    ExpandableRelativeLayout expandableLayoutPriceOrder;

    @Bind(R.id.expandableLayoutCategoryOrder)
    ExpandableRelativeLayout expandableLayoutCategoryOrder;

    @Bind(R.id.image_expand_start)
    ImageView imageExpandStart;

    @Bind(R.id.image_expand_price)
    ImageView imageExpandPrice;

    @Bind(R.id.image_expand_service)
    ImageView imageExpandService;

    @Bind(R.id.image_expand_regime)
    ImageView imageExpandRegime;

    @Bind(R.id.image_expand_hotel_shain)
    ImageView imageExpandHotelShain;

    @Bind(R.id.image_expand_price_order)
    ImageView imageExpandPriceOrder;

    @Bind(R.id.image_expand_category_order)
    ImageView imageExpandCategoryOrder;

    @Override
    public int getLayout() {
        return R.layout.activity_search_hotel;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        setToolbar(mToolbar);
        setTitle(getResources().getString(R.string.hotels_available));
        setupPanel();
        setupExpandable();
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
                StatesPanel.setPanelExpande(mPanel);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        StatesPanel.closeSlidingPanelFilterOrOder(mPanel);
        super.onBackPressed();
    }

    @OnClick(R.id.container_start)
    public void onClickContainerStart() {
        expandableLayoutStart.toggle();
    }

    @OnClick(R.id.container_price)
    public void onClickContainerPrice() {
        expandableLayoutPrice.toggle();
    }

    @OnClick(R.id.container_service)
    public void onClickContainerService() {
        expandableLayoutService.toggle();
    }

    @OnClick(R.id.container_regime)
    public void onClickContainerRegime() {
        expandableLayoutRegime.toggle();
    }

    @OnClick(R.id.container_hotel_shain)
    public void onClickContainerHotelShain() {
        expandableLayoutHotelShain.toggle();
    }

    @OnClick(R.id.container_price_order)
    public void onClickContainerPriceOrder() {
        expandableLayoutPriceOrder.toggle();
    }

    @OnClick(R.id.container_category_order)
    public void onClickContainerCategoryOrder() {
        expandableLayoutCategoryOrder.toggle();
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
                StatesPanel.setPanelState(mPanel);
            }
        });
    }

    /**
     * Configurar los @{@link com.github.aakira.expandablelayout.ExpandableLayoutListener}
     */
    private void setupExpandable() {
        ExpandableOpenClose.setExpandableListener(expandableLayoutStart, imageExpandStart);
        ExpandableOpenClose.setExpandableListener(expandableLayoutPrice, imageExpandPrice);
        ExpandableOpenClose.setExpandableListener(expandableLayoutService, imageExpandService);
        ExpandableOpenClose.setExpandableListener(expandableLayoutRegime, imageExpandRegime);
        ExpandableOpenClose.setExpandableListener(expandableLayoutHotelShain, imageExpandHotelShain);

        ExpandableOpenClose.setExpandableListener(expandableLayoutPriceOrder, imageExpandPriceOrder);
        ExpandableOpenClose.setExpandableListener(expandableLayoutCategoryOrder, imageExpandCategoryOrder);
    }


}