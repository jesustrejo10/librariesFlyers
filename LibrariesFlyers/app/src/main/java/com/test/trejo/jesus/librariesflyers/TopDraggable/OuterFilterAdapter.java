package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.Models.RecyclerObject;
import com.test.trejo.jesus.librariesflyers.R;
import com.test.trejo.jesus.librariesflyers.utils.FilterCheckBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jesus on 29/08/17.
 */

public class OuterFilterAdapter extends RecyclerView.Adapter<OuterFilterViewHolder> implements FilterListener {

    private final static String TAG = OuterFilterAdapter.class.getSimpleName();

    private Context mContext;
    private boolean mListStatusStar = Boolean.FALSE;
    private boolean mListStatusPrice = Boolean.FALSE;
    private boolean mListStatusService = Boolean.FALSE;
    private boolean mListStatusRegime = Boolean.FALSE;

    private Filter mFilter = null;

    private ArrayList<RecyclerObject> mRecyclerObjects;
    private List<CheckBox> mCheckBoxListFilter;
    final Handler mHandler = new Handler();

    public OuterFilterAdapter(ArrayList<RecyclerObject> recyclerObjects, Context context) {
        this.mRecyclerObjects = recyclerObjects;
        this.mContext = context;
    }

    @Override
    public OuterFilterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.outer_filter_item, parent, false);
        return new OuterFilterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final OuterFilterViewHolder holder, final int position) {

        mFilter = new Filter();

        final RecyclerObject object = mRecyclerObjects.get(position);
        holder.getDetailName().setText(object.getDescription());

        mCheckBoxListFilter = FilterCheckBox.addCheckboxFilterToArray(holder, this);

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
        return mRecyclerObjects.size();
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    @Override
    public void clearFilter() {
        Log.d(TAG, "clearFilter");
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                FilterCheckBox.clearCheckBox(mCheckBoxListFilter);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public void clearStatus() {
        Log.d(TAG, "clearStatus");

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {

//            Estrellas
            case R.id.checkbox_one_star:
                if (isChecked) {
                    mFilter.setOneStar(Boolean.TRUE);
                    Log.d(TAG, "mFilter.setOneStar(Boolean.TRUE);");
                } else {
                    mFilter.setOneStar(Boolean.FALSE);
                    Log.d(TAG, "mFilter.setOneStar(Boolean.FALSE);");
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
                } else {

                }
            case R.id.checkbox_breakfast:
                if (isChecked) {
                } else {

                }
            case R.id.checkbox_half_pension:
                if (isChecked) {
                } else {

                }
            case R.id.checkbox_full_board:
                if (isChecked) {
                } else {

                }
            case R.id.checkbox_all_inclusive:
                if (isChecked) {
                } else {

                }
        }
    }


    private void statusMainContainerStar(OuterFilterViewHolder holder) {
        if (mListStatusStar) {
            mListStatusStar = Boolean.FALSE;
            holder.getContainerFilter().setVisibility(View.GONE);
            holder.getExpandIcon().animate().rotation(360).start();
        } else {
            mListStatusStar = Boolean.TRUE;
            holder.getContainerFilter().setVisibility(View.VISIBLE);
            holder.getExpandIcon().animate().rotation(180).start();
        }
    }

    private void statusMainContainerPrice(OuterFilterViewHolder holder) {
        if (mListStatusPrice) {
            mListStatusPrice = Boolean.FALSE;
            holder.getContainerFilter().setVisibility(View.GONE);
            holder.getExpandIcon().animate().rotation(360).start();
        } else {
            mListStatusPrice = Boolean.TRUE;
            holder.getContainerFilter().setVisibility(View.VISIBLE);
            holder.getExpandIcon().animate().rotation(180).start();
        }
    }

    private void statusMainContainerService(OuterFilterViewHolder holder) {
        if (mListStatusService) {
            mListStatusService = Boolean.FALSE;
            holder.getContainerFilter().setVisibility(View.GONE);
            holder.getExpandIcon().animate().rotation(360).start();
        } else {
            mListStatusService = Boolean.TRUE;
            holder.getContainerFilter().setVisibility(View.VISIBLE);
            holder.getExpandIcon().animate().rotation(180).start();
        }
    }

    private void statusMainContainerRegime(OuterFilterViewHolder holder) {
        if (mListStatusRegime) {
            mListStatusRegime = Boolean.FALSE;
            holder.getContainerFilter().setVisibility(View.GONE);
            holder.getExpandIcon().animate().rotation(360).start();
        } else {
            mListStatusRegime = Boolean.TRUE;
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

}