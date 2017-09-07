package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.Models.RecyclerObject;
import com.test.trejo.jesus.librariesflyers.R;

import java.util.ArrayList;

/**
 * Created by jesus on 29/08/17.
 */

public class OuterFilterAdapter extends RecyclerView.Adapter<OuterFilterViewHolder> {

    private Context mContext;
    private boolean listStatusStar = Boolean.FALSE;
    private boolean listStatusPrice = Boolean.FALSE;
    private boolean listStatusService = Boolean.FALSE;
    private ArrayList<RecyclerObject> recyclerObjects;

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
        final RecyclerObject object = recyclerObjects.get(position);
        holder.getDetailName().setText(object.getDescription());
        holder.getContainerFullLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (object.getId()) {
                    case 1:
                        statusMainContainerStar(holder);
                        holder.getContainerFilterStar().setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        Log.d("CLICK", "2");
                        statusMainContainerPrice(holder);
                        holder.getContainerFilterPrice().setVisibility(View.VISIBLE);
                        setRangePrice(holder);
                        break;
                    case 3:
                        Log.d("CLICK", "3");
                        statusMainContainerService(holder);
                        holder.getContainerFilterServices().setVisibility(View.VISIBLE);
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