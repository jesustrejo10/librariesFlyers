package com.test.trejo.jesus.librariesflyers.TopDraggable.search;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.test.trejo.jesus.librariesflyers.BaseActivity;
import com.test.trejo.jesus.librariesflyers.R;
import com.test.trejo.jesus.librariesflyers.TopDraggable.model.Expandables;
import com.test.trejo.jesus.librariesflyers.TopDraggable.model.Filter;
import com.test.trejo.jesus.librariesflyers.TopDraggable.model.Sort;
import com.test.trejo.jesus.librariesflyers.TopDraggable.presenter.SearchHotelPresenter;
import com.test.trejo.jesus.librariesflyers.utils.Colors;
import com.test.trejo.jesus.librariesflyers.utils.ExpandableOpenClose;
import com.test.trejo.jesus.librariesflyers.utils.FilterUtility;
import com.test.trejo.jesus.librariesflyers.utils.SortUtility;
import com.test.trejo.jesus.librariesflyers.utils.StatesPanel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import worker8.com.github.radiogroupplus.RadioGroupPlus;


public class SearchHotelActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, RadioGroupPlus.OnCheckedChangeListener, SearchHotelContract.View {

    public final static String TAG = SearchHotelActivity.class.getSimpleName();

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

    //################################################ Filtros de Estrellas
    @Bind(R.id.checkbox_one_star)
    CheckBox oneStar;
    @Bind(R.id.checkbox_two_star)
    CheckBox twoStar;
    @Bind(R.id.checkbox_three_star)
    CheckBox theeeStar;
    @Bind(R.id.checkbox_four_star)
    CheckBox fourStar;
    @Bind(R.id.checkbox_five_star)
    CheckBox fiveStar;

    //################################################ Filtros de Precios
    @Bind(R.id.range_seekbar_price)
    CrystalRangeSeekbar rangeSeekbarPrice;

    @Bind(R.id.minimo)
    TextView priceMin;

    @Bind(R.id.maximo)
    TextView priceMax;

    //################################################ Filtros de Servicios
    @Bind(R.id.checkbox_air_conditioning)
    CheckBox ariConditioning;

    @Bind(R.id.checkbox_airport_shufle)
    CheckBox airportShufle;

    @Bind(R.id.checkbox_indoor_pool)
    CheckBox indoorPool;

    @Bind(R.id.checkbox_pets_welcome)
    CheckBox pets;

    @Bind(R.id.checkbox_spa_fitness)
    CheckBox paFitness;

    @Bind(R.id.checkbox_wi_fi)
    CheckBox wiFI;

    //################################################ Filtros de Regime
    @Bind(R.id.checkbox_only_lodging)
    CheckBox onlyLodging;

    @Bind(R.id.checkbox_breakfast)
    CheckBox breakFast;

    @Bind(R.id.checkbox_half_pension)
    CheckBox halfPension;

    @Bind(R.id.checkbox_full_board)
    CheckBox fullBoard;

    @Bind(R.id.checkbox_all_inclusive)
    CheckBox allInclusive;


    //################################################ Ordenar
    @Bind(R.id.radio_button_lowest_price)
    RadioButton lowestPrice;

    @Bind(R.id.radio_button_higher_price)
    RadioButton higherPrice;

    @Bind(R.id.radio_button_one_star)
    RadioButton rbOneStart;

    @Bind(R.id.radio_button_two_star)
    RadioButton rbTwoStart;

    @Bind(R.id.radio_button_three_star)
    RadioButton rbThreeStart;

    @Bind(R.id.radio_button_four_star)
    RadioButton rbFourStart;

    @Bind(R.id.radio_button_five_star)
    RadioButton rbFiveStart;

    @Bind(R.id.radio_group_plus_price)
    RadioGroupPlus radioGroupPlusPrice;

    @Bind(R.id.radio_group_plus_category)
    RadioGroupPlus radioGroupPlusCategory;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.sliding_layout)
    SlidingUpPanelLayout mPanel;

    @Bind(R.id.scroll_view)
    ScrollView mScrollView;

    private List<CheckBox> mCheckBoxListFilter;
    private List<RadioButton> mRadioButtonListSort;
    private List<Expandables> mExpandablesList;
    private Filter mFilter;
    private Sort mSort;

    private SearchHotelContract.Presenter mPresenter;

    @Override
    public int getLayout() {
        return R.layout.activity_search_hotel;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        setToolbar(mToolbar);
        setTitle(getResources().getString(R.string.hotels_available));
        mPresenter = new SearchHotelPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(@NonNull SearchHotelContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setupInit() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mCheckBoxListFilter = new ArrayList<>();
                mRadioButtonListSort = new ArrayList<>();
                mExpandablesList = new ArrayList<>();
                mFilter = new Filter();
                mSort = new Sort();

                mExpandablesList.add(new Expandables(expandableLayoutStart, imageExpandStart));
                mExpandablesList.add(new Expandables(expandableLayoutPrice, imageExpandPrice));
                mExpandablesList.add(new Expandables(expandableLayoutService, imageExpandService));
                mExpandablesList.add(new Expandables(expandableLayoutRegime, imageExpandRegime));
                mExpandablesList.add(new Expandables(expandableLayoutHotelShain, imageExpandHotelShain));
                mExpandablesList.add(new Expandables(expandableLayoutPriceOrder, imageExpandPriceOrder));
                mExpandablesList.add(new Expandables(expandableLayoutCategoryOrder, imageExpandCategoryOrder));

                mCheckBoxListFilter.add(oneStar);
                mCheckBoxListFilter.add(twoStar);
                mCheckBoxListFilter.add(theeeStar);
                mCheckBoxListFilter.add(fourStar);
                mCheckBoxListFilter.add(fiveStar);

                mCheckBoxListFilter.add(ariConditioning);
                mCheckBoxListFilter.add(airportShufle);
                mCheckBoxListFilter.add(indoorPool);
                mCheckBoxListFilter.add(pets);
                mCheckBoxListFilter.add(paFitness);
                mCheckBoxListFilter.add(wiFI);

                mCheckBoxListFilter.add(onlyLodging);
                mCheckBoxListFilter.add(breakFast);
                mCheckBoxListFilter.add(halfPension);
                mCheckBoxListFilter.add(fullBoard);
                mCheckBoxListFilter.add(allInclusive);

                mRadioButtonListSort.add(lowestPrice);
                mRadioButtonListSort.add(higherPrice);
                mRadioButtonListSort.add(rbOneStart);
                mRadioButtonListSort.add(rbTwoStart);
                mRadioButtonListSort.add(rbThreeStart);
                mRadioButtonListSort.add(rbFourStart);
                mRadioButtonListSort.add(rbFiveStart);

                Colors.applyColorFilter(imageExpandStart);
                Colors.applyColorFilter(imageExpandPrice);
                Colors.applyColorFilter(imageExpandService);
                Colors.applyColorFilter(imageExpandRegime);
                Colors.applyColorFilter(imageExpandHotelShain);
                Colors.applyColorFilter(imageExpandPriceOrder);
            }
        });

        FilterUtility.setChangeListener(mCheckBoxListFilter, this);
        SortUtility.setSortRadioGroupListener(radioGroupPlusPrice, this);
        SortUtility.setSortRadioGroupListener(radioGroupPlusCategory, this);
    }

    @Override
    public void setupPanel() {
        mPanel.setDragView(mScrollView);
        mPanel.setTouchEnabled(false);
        mPanel.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatesPanel.setPanelState(mPanel);
            }
        });
    }

    @Override
    public void setupExpandable() {
        ExpandableOpenClose.setExpandable(mExpandablesList);
    }

    @Override
    public void setRangePrice() {
        rangeSeekbarPrice.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                mFilter.setPriceMax(String.valueOf(maxValue));
                mFilter.setPriceMin(String.valueOf(minValue));
                priceMax.setText(String.format("%s%s", getResources().getString(R.string.to), String.valueOf(maxValue)));
                priceMin.setText(String.format("%s%s", getResources().getString(R.string.from), String.valueOf(minValue)));
            }
        });
        rangeSeekbarPrice.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
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

    @Override
    public void onCheckedChanged(RadioGroupPlus radioGroupPlus, @IdRes int i) {
        if (i == R.id.radio_button_lowest_price) {
            mSort.setLowestPrice(Boolean.TRUE);
        } else {
            mSort.setLowestPrice(Boolean.FALSE);
        }
        if (i == R.id.radio_button_higher_price) {
            mSort.setHigherPrice(Boolean.TRUE);
        } else {
            mSort.setHigherPrice(Boolean.FALSE);
        }

        if (i == R.id.radio_button_one_star) {// 1 estrella
            mSort.setRbOneStart(Boolean.TRUE);
        } else {
            mSort.setRbOneStart(Boolean.FALSE);
        }

        if (i == R.id.radio_button_two_star) {// 2 estrella
            mSort.setRbTwoStart(Boolean.TRUE);
        } else {
            mSort.setRbTwoStart(Boolean.FALSE);
        }

        if (i == R.id.radio_button_three_star) {// 3 estrella
            mSort.setRbThreeStart(Boolean.TRUE);
        } else {
            mSort.setRbThreeStart(Boolean.FALSE);
        }

        if (i == R.id.radio_button_four_star) {// 4 estrella
            mSort.setRbFourStart(Boolean.TRUE);
        } else {
            mSort.setRbFourStart(Boolean.FALSE);
        }

        if (i == R.id.radio_button_five_star) {// 5 estrella
            mSort.setRbFiveStart(Boolean.TRUE);
        } else {
            mSort.setRbFiveStart(Boolean.FALSE);
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {

//            Estrellas
            case R.id.checkbox_one_star:
                if (isChecked) {
                    mFilter.setOneStar(Boolean.TRUE);
                } else {
                    mFilter.setOneStar(Boolean.FALSE);
                }
                break;
            case R.id.checkbox_two_star:
                if (isChecked) {
                    mFilter.setTwoStar(Boolean.TRUE);
                } else {
                    mFilter.setTwoStar(Boolean.FALSE);
                }
                break;
            case R.id.checkbox_three_star:
                if (isChecked) {
                    mFilter.setTheeeStar(Boolean.TRUE);
                } else {
                    mFilter.setTheeeStar(Boolean.FALSE);
                }
                break;
            case R.id.checkbox_four_star:
                if (isChecked) {
                    mFilter.setFourStar(Boolean.TRUE);
                } else {
                    mFilter.setFourStar(Boolean.FALSE);
                }
                break;
            case R.id.checkbox_five_star:
                if (isChecked) {
                    mFilter.setFiveStar(Boolean.TRUE);
                } else {
                    mFilter.setFiveStar(Boolean.FALSE);
                }
                break;

//            Servicios
            case R.id.checkbox_air_conditioning:
                if (isChecked) {
                    mFilter.setAriConditioning(Boolean.TRUE);
                } else {
                    mFilter.setAriConditioning(Boolean.FALSE);
                }
                break;
            case R.id.checkbox_airport_shufle:
                if (isChecked) {
                    mFilter.setAirportShufle(Boolean.TRUE);
                } else {
                    mFilter.setAirportShufle(Boolean.FALSE);
                }
                break;
            case R.id.checkbox_indoor_pool:
                if (isChecked) {
                    mFilter.setIndoorPool(Boolean.TRUE);
                } else {
                    mFilter.setIndoorPool(Boolean.FALSE);
                }
                break;
            case R.id.checkbox_pets_welcome:
                if (isChecked) {
                    mFilter.setPets(Boolean.TRUE);
                } else {
                    mFilter.setPets(Boolean.FALSE);
                }
                break;
            case R.id.checkbox_spa_fitness:
                if (isChecked) {
                    mFilter.setPAFitness(Boolean.TRUE);
                } else {
                    mFilter.setPAFitness(Boolean.FALSE);
                }
                break;
            case R.id.checkbox_wi_fi:
                if (isChecked) {
                    mFilter.setWiFI(Boolean.TRUE);
                } else {
                    mFilter.setWiFI(Boolean.FALSE);
                }
                break;

//            Regimen
            case R.id.checkbox_only_lodging:
                if (isChecked) {
                    mFilter.setOnlyLodging(Boolean.TRUE);
                } else {
                    mFilter.setOnlyLodging(Boolean.FALSE);
                }
            case R.id.checkbox_breakfast:
                if (isChecked) {
                    mFilter.setBreakFast(Boolean.TRUE);
                } else {
                    mFilter.setBreakFast(Boolean.FALSE);
                }
            case R.id.checkbox_half_pension:
                if (isChecked) {
                    mFilter.setHalfPension(Boolean.TRUE);
                } else {
                    mFilter.setHalfPension(Boolean.FALSE);
                }
            case R.id.checkbox_full_board:
                if (isChecked) {
                    mFilter.setFullBoard(Boolean.TRUE);
                } else {
                    mFilter.setFullBoard(Boolean.FALSE);
                }
            case R.id.checkbox_all_inclusive:
                if (isChecked) {
                    mFilter.setAllInclusive(Boolean.TRUE);
                } else {
                    mFilter.setAllInclusive(Boolean.FALSE);
                }
        }
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

    @OnClick(R.id.container_distance_order)
    public void onClickContainerDistanceOrder() {
        startActivity(new Intent(SearchHotelActivity.this, DistanceActivity.class));
//        clearCollapseAndResetView();
    }

    @OnClick(R.id.cancel)
    public void onClickCancelFilterOrOrder() {
        clearCollapseAndResetView();
    }

    @OnClick(R.id.apply)
    public void onClickApplyFilterOrOrder() {
        mPresenter.sendFilterAndSort(mFilter, mSort);
        clearCollapseAndResetView();
    }

    /**
     * Cerrar to-do, formatear los @{@link CheckBox} @{@link RadioButton}
     */
    private void clearCollapseAndResetView() {
        StatesPanel.closeSlidingPanelFilterOrOder(mPanel);
        FilterUtility.setClearCheckBox(mCheckBoxListFilter);
        SortUtility.setClearRadioGroup(radioGroupPlusCategory);
        SortUtility.setClearRadioGroup(radioGroupPlusPrice);
        ExpandableOpenClose.collapseExpandable(mExpandablesList);
    }

}