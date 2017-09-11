package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.widget.CompoundButton;

import com.test.trejo.jesus.librariesflyers.TopDraggable.model.Filter;

/**
 * Created by roger on 08/09/17.
 */

public interface FilterListener extends CompoundButton.OnCheckedChangeListener {

    Filter getFilter();

    void clearFilter();

    void clearStatus();

}
