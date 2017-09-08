package com.test.trejo.jesus.librariesflyers.utils;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.test.trejo.jesus.librariesflyers.TopDraggable.OuterFilterViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roger on 08/09/17.
 */

public class FilterCheckBox {

    /**
     * Agregar los checkbox filtros a un arreglo
     *
     * @param holder @{@link OuterFilterViewHolder}
     * @return Arreglo de checkbox
     */
    public static List<CheckBox> addCheckboxFilterToArray(@NonNull OuterFilterViewHolder holder, CompoundButton.OnCheckedChangeListener listener) {
        List<CheckBox> mCheckBoxListFilter = new ArrayList<>();
        mCheckBoxListFilter.add(holder.getOneStar());
        mCheckBoxListFilter.add(holder.getTwoStar());
        mCheckBoxListFilter.add(holder.getTheeeStar());
        mCheckBoxListFilter.add(holder.getFourStar());
        mCheckBoxListFilter.add(holder.getFiveStar());

        mCheckBoxListFilter.add(holder.getAriConditioning());
        mCheckBoxListFilter.add(holder.getAirportShufle());
        mCheckBoxListFilter.add(holder.getIndoorPool());
        mCheckBoxListFilter.add(holder.getPets());
        mCheckBoxListFilter.add(holder.getPAFitness());

        mCheckBoxListFilter.add(holder.getWiFI());
        mCheckBoxListFilter.add(holder.getOnlyLodging());
        mCheckBoxListFilter.add(holder.getBreakFast());
        mCheckBoxListFilter.add(holder.getHalfPension());
        mCheckBoxListFilter.add(holder.getFullBoard());
        mCheckBoxListFilter.add(holder.getAllInclusive());

        setChangeListener(mCheckBoxListFilter, listener);

        return mCheckBoxListFilter;
    }

    private static void setChangeListener(List<CheckBox> mCheckBoxListFilter, CompoundButton.OnCheckedChangeListener listener) {
        for (CheckBox cb : mCheckBoxListFilter) {
            cb.setOnCheckedChangeListener(listener);
        }
    }

    public static void clearCheckBox(List<CheckBox> mCheckBoxListFilter) {
        for (CheckBox cb : mCheckBoxListFilter) {
            Log.d("BOX", cb.toString());
            cb.setChecked(false);
        }
    }


}