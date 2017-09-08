package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.Models.RecyclerObject;
import com.test.trejo.jesus.librariesflyers.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jesus on 29/08/17.
 */

public class OuterFilterAdapter extends RecyclerView.Adapter<OuterFilterViewHolder> implements CompoundButton.OnCheckedChangeListener {

    private Context mContext;
    private boolean listStatusStar = Boolean.FALSE;
    private boolean listStatusPrice = Boolean.FALSE;
    private boolean listStatusService = Boolean.FALSE;
    private boolean listStatusRegime = Boolean.FALSE;

    private Filter filter = null;

    private ArrayList<RecyclerObject> recyclerObjects;
    private List<CheckBox> checkBoxListFilter;

    public OuterFilterAdapter(ArrayList<RecyclerObject> recyclerObjects, Context context) {
        this.recyclerObjects = recyclerObjects;
        this.mContext = context;
    }

    @Override
    public OuterFilterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.outer_filter_item, parent, false);
        return new OuterFilterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final OuterFilterViewHolder holder, final int position) {

        filter = new Filter();
        checkBoxListFilter = new ArrayList<>();

        final RecyclerObject object = recyclerObjects.get(position);
        holder.getDetailName().setText(object.getDescription());

        checkBoxListFilter.add(holder.getOneStar());
        checkBoxListFilter.add(holder.getTwoStar());
        checkBoxListFilter.add(holder.getTheeeStar());
        checkBoxListFilter.add(holder.getFourStar());
        checkBoxListFilter.add(holder.getFiveStar());
        checkBoxListFilter.add(holder.getAriConditioning());
        checkBoxListFilter.add(holder.getAirportShufle());
        checkBoxListFilter.add(holder.getIndoorPool());
        checkBoxListFilter.add(holder.getPets());
        checkBoxListFilter.add(holder.getPAFitness());
        checkBoxListFilter.add(holder.getWiFI());
        checkBoxListFilter.add(holder.getOnlyLodging());
        checkBoxListFilter.add(holder.getBreakFast());
        checkBoxListFilter.add(holder.getHalfPension());
        checkBoxListFilter.add(holder.getFullBoard());
        checkBoxListFilter.add(holder.getAllInclusive());

        setChangeListener();

        holder.getContainerFullLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (object.getId()) {
                    case 1:
                        statusMainContainerStar(holder);
                        holder.getContainerFilterStar().setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        statusMainContainerPrice(holder);
                        holder.getContainerFilterPrice().setVisibility(View.VISIBLE);
                        setRangePrice(holder);
                        break;
                    case 3:
                        statusMainContainerService(holder);
                        holder.getContainerFilterServices().setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        statusMainContainerRegime(holder);
                        holder.getContainerFilterRegime().setVisibility(View.VISIBLE);
                        break;

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return recyclerObjects.size();
    }

    private void statusMainContainerStar(OuterFilterViewHolder holder) {
        if (listStatusStar) {
            listStatusStar = Boolean.FALSE;
            holder.getContainerFilter().setVisibility(View.GONE);
            holder.getExpandIcon().animate().rotation(360).start();
        } else {
            listStatusStar = Boolean.TRUE;
            holder.getContainerFilter().setVisibility(View.VISIBLE);
            holder.getExpandIcon().animate().rotation(180).start();
        }
    }

    private void statusMainContainerPrice(OuterFilterViewHolder holder) {
        if (listStatusPrice) {
            listStatusPrice = Boolean.FALSE;
            holder.getContainerFilter().setVisibility(View.GONE);
            holder.getExpandIcon().animate().rotation(360).start();
        } else {
            listStatusPrice = Boolean.TRUE;
            holder.getContainerFilter().setVisibility(View.VISIBLE);
            holder.getExpandIcon().animate().rotation(180).start();
        }
    }

    private void statusMainContainerService(OuterFilterViewHolder holder) {
        if (listStatusService) {
            listStatusService = Boolean.FALSE;
            holder.getContainerFilter().setVisibility(View.GONE);
            holder.getExpandIcon().animate().rotation(360).start();
        } else {
            listStatusService = Boolean.TRUE;
            holder.getContainerFilter().setVisibility(View.VISIBLE);
            holder.getExpandIcon().animate().rotation(180).start();
        }
    }

    private void statusMainContainerRegime(OuterFilterViewHolder holder) {
        if (listStatusRegime) {
            listStatusRegime = Boolean.FALSE;
            holder.getContainerFilter().setVisibility(View.GONE);
            holder.getExpandIcon().animate().rotation(360).start();
        } else {
            listStatusRegime = Boolean.TRUE;
            holder.getContainerFilter().setVisibility(View.VISIBLE);
            holder.getExpandIcon().animate().rotation(180).start();
        }
    }

    /**
     * Obtener el rango del filtro de los precios
     *
     * @param holder @{@link OuterFilterViewHolder}
     */
    private void setRangePrice(final OuterFilterViewHolder holder) {
        holder.getRangeSeekbarPrice().setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                holder.getPriceMax().setText(String.format("%s%s", mContext.getResources().getString(R.string.to), String.valueOf(maxValue)));
                holder.getPriceMin().setText(String.format("%s%s", mContext.getResources().getString(R.string.from), String.valueOf(minValue)));
            }
        });
        holder.getRangeSeekbarPrice().setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {

//            Estrellas
            case R.id.checkbox_one_star:
                if (isChecked) {
                    filter.setOneStar(Boolean.TRUE);
                    Toast.makeText(mContext, "Si 1 estrella", Toast.LENGTH_SHORT).show();
                } else {
                    filter.setOneStar(Boolean.FALSE);
                    Toast.makeText(mContext, "No 1 estrella", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkbox_two_star:
                if (isChecked) {
                    filter.setTwoStar(Boolean.TRUE);
                    Toast.makeText(mContext, "Si 2 estrella", Toast.LENGTH_SHORT).show();
                } else {
                    filter.setTwoStar(Boolean.FALSE);
                    Toast.makeText(mContext, "No 2 estrella", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkbox_three_star:
                if (isChecked) {
                    filter.setTheeeStar(Boolean.TRUE);
                    Toast.makeText(mContext, "Si 3 estrella", Toast.LENGTH_SHORT).show();
                } else {
                    filter.setTheeeStar(Boolean.FALSE);
                    Toast.makeText(mContext, "No 3 estrella", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkbox_four_star:
                if (isChecked) {
                    filter.setFourStar(Boolean.TRUE);
                    Toast.makeText(mContext, "Si 4 estrella", Toast.LENGTH_SHORT).show();
                } else {
                    filter.setFourStar(Boolean.FALSE);
                    Toast.makeText(mContext, "No 4 estrella", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkbox_five_star:
                if (isChecked) {
                    filter.setFiveStar(Boolean.TRUE);
                    Toast.makeText(mContext, "Si 5 estrella", Toast.LENGTH_SHORT).show();
                } else {
                    filter.setFiveStar(Boolean.FALSE);
                    Toast.makeText(mContext, "No 5 estrella", Toast.LENGTH_SHORT).show();
                }
                break;

//            Servicios
            case R.id.checkbox_air_conditioning:
                if (isChecked) {
                    filter.setAriConditioning(Boolean.TRUE);
                    Toast.makeText(mContext, "checkbox_air_conditioning", Toast.LENGTH_SHORT).show();
                } else {
                    filter.setAriConditioning(Boolean.FALSE);
                }
                break;
            case R.id.checkbox_airport_shufle:
                if (isChecked) {
                    filter.setAirportShufle(Boolean.TRUE);
                    Toast.makeText(mContext, "checkbox_airport_shufle", Toast.LENGTH_SHORT).show();
                } else {
                    filter.setAirportShufle(Boolean.FALSE);
                }
                break;
            case R.id.checkbox_indoor_pool:
                if (isChecked) {
                    filter.setIndoorPool(Boolean.TRUE);
                    Toast.makeText(mContext, "checkbox_indoor_pool", Toast.LENGTH_SHORT).show();
                } else {
                    filter.setIndoorPool(Boolean.FALSE);
                }
                break;
            case R.id.checkbox_pets_welcome:
                if (isChecked) {
                    filter.setPets(Boolean.TRUE);
                    Toast.makeText(mContext, "checkbox_pets_welcome", Toast.LENGTH_SHORT).show();
                } else {
                    filter.setPets(Boolean.FALSE);
                }
                break;
            case R.id.checkbox_spa_fitness:
                if (isChecked) {
                    filter.setPAFitness(Boolean.TRUE);
                    Toast.makeText(mContext, "checkbox_spa_fitness", Toast.LENGTH_SHORT).show();
                } else {
                    filter.setPAFitness(Boolean.FALSE);
                }
                break;
            case R.id.checkbox_wi_fi:
                if (isChecked) {
                    filter.setWiFI(Boolean.TRUE);
                    Toast.makeText(mContext, "checkbox_wi_fi", Toast.LENGTH_SHORT).show();
                } else {
                    filter.setWiFI(Boolean.FALSE);
                }
                break;

//            Regimen
            case R.id.checkbox_only_lodging:
                if (isChecked) {
                    Toast.makeText(mContext, "checkbox_only_lodging", Toast.LENGTH_SHORT).show();
                } else {

                }
            case R.id.checkbox_breakfast:
                if (isChecked) {
                    Toast.makeText(mContext, "checkbox_breakfast", Toast.LENGTH_SHORT).show();
                } else {

                }
            case R.id.checkbox_half_pension:
                if (isChecked) {
                    Toast.makeText(mContext, "checkbox_half_pension", Toast.LENGTH_SHORT).show();
                } else {

                }
            case R.id.checkbox_full_board:
                if (isChecked) {
                    Toast.makeText(mContext, "checkbox_full_board", Toast.LENGTH_SHORT).show();
                } else {

                }
            case R.id.checkbox_all_inclusive:
                if (isChecked) {
                    Toast.makeText(mContext, "checkbox_all_inclusive", Toast.LENGTH_SHORT).show();
                } else {

                }
        }
    }

    /**
     * Agregar @setOnCheckedChangeListener a los @{@link CheckBox} del filtros
     */
    private void setChangeListener() {
        for (CheckBox cb : checkBoxListFilter) {
            cb.setOnCheckedChangeListener(this);
        }
    }

    /**
     * Obtener los valores de los filtros
     *
     * @return @{@link Filter}
     */
    public Filter getFilter() {
        return filter;
    }

    /**
     * Limpiar @{@link CheckBox}
     */
    public void clearFiler() {
        for (CheckBox cb : checkBoxListFilter) {
            cb.setChecked(false);
        }
    }
}