package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.test.trejo.jesus.librariesflyers.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jesus on 29/08/17.
 */

public class OuterFilterViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.full_layout)
    LinearLayout ContainerFullLayout;

    @Bind(R.id.detail_name)
    TextView DetailName;

    @Bind(R.id.expand_icon)
    ImageView ExpandIcon;

    @Bind(R.id.container_filter)
    LinearLayout ContainerFilter;

    //################################################ Filtros de Estrellas
    @Bind(R.id.filter_star)
    LinearLayout ContainerFilterStar;

    @Bind(R.id.checkbox_one_star)
    CheckBox OneStar;
    @Bind(R.id.checkbox_two_star)
    CheckBox TwoStar;
    @Bind(R.id.checkbox_three_star)
    CheckBox TheeeStar;
    @Bind(R.id.checkbox_four_star)
    CheckBox FourStar;
    @Bind(R.id.checkbox_five_star)
    CheckBox FiveStar;
    //################################################

    //################################################ Filtros de Precios
    @Bind(R.id.filter_price)
    LinearLayout ContainerFilterPrice;

    @Bind(R.id.range_seekbar_price)
    CrystalRangeSeekbar RangeSeekbarPrice;

    @Bind(R.id.minimo)
    TextView PriceMin;

    @Bind(R.id.maximo)
    TextView PriceMax;
    //################################################

    //################################################ Filtros de Servicios
    @Bind(R.id.filter_service)
    LinearLayout ContainerFilterServices;

    @Bind(R.id.checkbox_air_conditioning)
    CheckBox AriConditioning;

    @Bind(R.id.checkbox_airport_shufle)
    CheckBox AirportShufle;

    @Bind(R.id.checkbox_indoor_pool)
    CheckBox IndoorPool;

    @Bind(R.id.checkbox_pets_welcome)
    CheckBox Pets;

    @Bind(R.id.checkbox_spa_fitness)
    CheckBox PAFitness;

    @Bind(R.id.checkbox_wi_fi)
    CheckBox WiFI;

    //################################################

    //################################################ Filtros de Regime
    @Bind(R.id.filter_regime)
    LinearLayout ContainerFilterRegime;

    @Bind(R.id.checkbox_only_lodging)
    CheckBox OnlyLodging;

    @Bind(R.id.checkbox_breakfast)
    CheckBox BreakFast;

    @Bind(R.id.checkbox_half_pension)
    CheckBox HalfPension;

    @Bind(R.id.checkbox_full_board)
    CheckBox FullBoard;

    @Bind(R.id.checkbox_all_inclusive)
    CheckBox AllInclusive;

    //################################################


    public OuterFilterViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public LinearLayout getContainerFullLayout() {
        return ContainerFullLayout;
    }

    public TextView getDetailName() {
        return DetailName;
    }

    public ImageView getExpandIcon() {
        return ExpandIcon;
    }

    public LinearLayout getContainerFilter() {
        return ContainerFilter;
    }

    public LinearLayout getContainerFilterStar() {
        return ContainerFilterStar;
    }

//    public LinearLayout getContainerFilterPrice() {
//        return ContainerFilterPrice;
//    }
//
//    public CrystalRangeSeekbar getRangeSeekbarPrice() {
//        return RangeSeekbarPrice;
//    }

    public TextView getPriceMin() {
        return PriceMin;
    }

    public TextView getPriceMax() {
        return PriceMax;
    }

    public LinearLayout getContainerFilterServices() {
        return ContainerFilterServices;
    }

    public LinearLayout getContainerFilterRegime() {
        return ContainerFilterRegime;
    }

    public CheckBox getOneStar() {
        return OneStar;
    }

    public CheckBox getTwoStar() {
        return TwoStar;
    }

    public CheckBox getTheeeStar() {
        return TheeeStar;
    }

    public CheckBox getFourStar() {
        return FourStar;
    }

    public CheckBox getFiveStar() {
        return FiveStar;
    }

    public CheckBox getAriConditioning() {
        return AriConditioning;
    }

    public CheckBox getAirportShufle() {
        return AirportShufle;
    }

    public CheckBox getIndoorPool() {
        return IndoorPool;
    }

    public CheckBox getPets() {
        return Pets;
    }

    public CheckBox getPAFitness() {
        return PAFitness;
    }

    public CheckBox getWiFI() {
        return WiFI;
    }

    public CheckBox getOnlyLodging() {
        return OnlyLodging;
    }

    public CheckBox getBreakFast() {
        return BreakFast;
    }

    public CheckBox getHalfPension() {
        return HalfPension;
    }

    public CheckBox getFullBoard() {
        return FullBoard;
    }

    public CheckBox getAllInclusive() {
        return AllInclusive;
    }
}