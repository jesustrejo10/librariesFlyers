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

    private int estrella = 0;

    private ArrayList<RecyclerObject> recyclerObjects;
    List<CheckBox> selectedcheckBox = new ArrayList<CheckBox>();

    private OuterFilterViewHolder outerFilterViewHolder;

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
        outerFilterViewHolder = holder;
        final RecyclerObject object = recyclerObjects.get(position);
        holder.getDetailName().setText(object.getDescription());

        holder.getOneStar().setOnCheckedChangeListener(this);
        holder.getTwoStar().setOnCheckedChangeListener(this);
        holder.getTheeeStar().setOnCheckedChangeListener(this);
        holder.getFourStar().setOnCheckedChangeListener(this);
        holder.getFiveStar().setOnCheckedChangeListener(this);

        holder.getAriConditioning().setOnCheckedChangeListener(this);
        holder.getAirportShufle().setOnCheckedChangeListener(this);
        holder.getIndoorPool().setOnCheckedChangeListener(this);
        holder.getPets().setOnCheckedChangeListener(this);
        holder.getPAFitness().setOnCheckedChangeListener(this);
        holder.getWiFI().setOnCheckedChangeListener(this);

        holder.getOnlyLodging().setOnCheckedChangeListener(this);
        holder.getBreakFast().setOnCheckedChangeListener(this);
        holder.getHalfPension().setOnCheckedChangeListener(this);
        holder.getFullBoard().setOnCheckedChangeListener(this);
        holder.getAllInclusive().setOnCheckedChangeListener(this);


        selectedcheckBox.add(holder.getOneStar());
        selectedcheckBox.add(holder.getTwoStar());
        selectedcheckBox.add(holder.getTheeeStar());
        selectedcheckBox.add(holder.getFourStar());
        selectedcheckBox.add(holder.getFiveStar());
        selectedcheckBox.add(holder.getAriConditioning());
        selectedcheckBox.add(holder.getAirportShufle());
        selectedcheckBox.add(holder.getIndoorPool());
        selectedcheckBox.add(holder.getPets());
        selectedcheckBox.add(holder.getPAFitness());
        selectedcheckBox.add(holder.getWiFI());
        selectedcheckBox.add(holder.getOnlyLodging());
        selectedcheckBox.add(holder.getBreakFast());
        selectedcheckBox.add(holder.getHalfPension());
        selectedcheckBox.add(holder.getFullBoard());
        selectedcheckBox.add(holder.getAllInclusive());


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
                    estrella = 1;
                    Toast.makeText(mContext, "Si 1 estrella", Toast.LENGTH_SHORT).show();
                } else {
                    estrella = 2;
                    Toast.makeText(mContext, "No 1 estrella", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkbox_two_star:
                if (isChecked) {
                    Toast.makeText(mContext, "Si 2 estrella", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "No 2 estrella", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkbox_three_star:
                if (isChecked) {
                    Toast.makeText(mContext, "Si 3 estrella", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "No 3 estrella", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkbox_four_star:
                if (isChecked) {
                    Toast.makeText(mContext, "Si 4 estrella", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "No 4 estrella", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkbox_five_star:
                if (isChecked) {
                    Toast.makeText(mContext, "Si 5 estrella", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "No 5 estrella", Toast.LENGTH_SHORT).show();
                }
                break;

//            Servicios
            case R.id.checkbox_air_conditioning:
                if (isChecked) {
                    Toast.makeText(mContext, "checkbox_air_conditioning", Toast.LENGTH_SHORT).show();
                } else {

                }
                break;
            case R.id.checkbox_airport_shufle:
                if (isChecked) {
                    Toast.makeText(mContext, "checkbox_airport_shufle", Toast.LENGTH_SHORT).show();
                } else {

                }
                break;
            case R.id.checkbox_indoor_pool:
                if (isChecked) {
                    Toast.makeText(mContext, "checkbox_indoor_pool", Toast.LENGTH_SHORT).show();
                } else {

                }
                break;
            case R.id.checkbox_pets_welcome:
                if (isChecked) {
                    Toast.makeText(mContext, "checkbox_pets_welcome", Toast.LENGTH_SHORT).show();
                } else {

                }
                break;
            case R.id.checkbox_spa_fitness:
                if (isChecked) {
                    Toast.makeText(mContext, "checkbox_spa_fitness", Toast.LENGTH_SHORT).show();
                } else {

                }
                break;
            case R.id.checkbox_wi_fi:
                if (isChecked) {
                    Toast.makeText(mContext, "checkbox_wi_fi", Toast.LENGTH_SHORT).show();
                } else {

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

    public int getEstrella() {
        return estrella;
    }

    public void clearFiler() {
        for (CheckBox cb : selectedcheckBox) {
            cb.setChecked(false);
        }
    }

}