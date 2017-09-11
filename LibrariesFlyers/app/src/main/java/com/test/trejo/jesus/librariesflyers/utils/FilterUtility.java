package com.test.trejo.jesus.librariesflyers.utils;

import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.List;

/**
 * Created by roger on 08/09/17.
 */

public class FilterUtility {

    /**
     * Aplicar eventos a los todos los @{@link CheckBox} de los filtros
     *
     * @param mCheckBoxListFilter @{@link List}
     * @param listener            @{@link CompoundButton#setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener)}
     */
    public static void setChangeListener(List<CheckBox> mCheckBoxListFilter, CompoundButton.OnCheckedChangeListener listener) {
        for (CheckBox cb : mCheckBoxListFilter) {
            cb.setOnCheckedChangeListener(listener);
        }
    }

    /**
     * Borrar los estados de la lista @{@link CheckBox}
     *
     * @param mCheckBoxListFilter @{@link List}
     */
    public static void setClearCheckBox(List<CheckBox> mCheckBoxListFilter) {
        for (CheckBox cb : mCheckBoxListFilter) {
            cb.setChecked(Boolean.FALSE);
        }
    }

}