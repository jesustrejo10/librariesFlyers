package com.test.trejo.jesus.librariesflyers.utils;

import android.widget.RadioButton;

import java.util.List;

import worker8.com.github.radiogroupplus.RadioGroupPlus;

/**
 * Created by roger on 11/09/17.
 */

public class SortUtility {

    /**
     * Limpiar los estados de los @{@link RadioButton} de los ordenar
     *
     * @param radioGroupPlus @{@link RadioGroupPlus}
     */
    public static void setClearRadioGroup(RadioGroupPlus radioGroupPlus) {
        radioGroupPlus.clearCheck();
    }

    public static void setClearSortListener(List<RadioButton> mRadioButtonListOrder) {
        for (RadioButton rb : mRadioButtonListOrder) {
            rb.setEnabled(Boolean.FALSE);
        }
    }

    /**
     * Asignar evento al @{@link RadioGroupPlus}
     *
     * @param radioGroupPlus @{@link RadioGroupPlus}
     * @param listener       @{@link RadioGroupPlus#setOnCheckedChangeListener(RadioGroupPlus.OnCheckedChangeListener)}
     */
    public static void setSortRadioGroupListener(RadioGroupPlus radioGroupPlus, RadioGroupPlus.OnCheckedChangeListener listener) {
        radioGroupPlus.setOnCheckedChangeListener(listener);
    }


}