package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.support.v7.widget.RecyclerView;
import android.view.View;
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

    //################################################

    //################################################ Filtros de Regime
    @Bind(R.id.filter_regime)
    LinearLayout ContainerFilterRegime;

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

    public LinearLayout getContainerFilterPrice() {
        return ContainerFilterPrice;
    }

    public CrystalRangeSeekbar getRangeSeekbarPrice() {
        return RangeSeekbarPrice;
    }

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
}