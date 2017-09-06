package com.test.trejo.jesus.librariesflyers.TopDraggable;

import android.support.annotation.NonNull;

import com.test.trejo.jesus.librariesflyers.BasePresenter;
import com.test.trejo.jesus.librariesflyers.BaseView;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.Models.RecyclerObject;

import java.util.ArrayList;

/**
 * Created by roger on 06/09/17.
 */

public interface TopDraggableContract {

    interface View extends BaseView<Presenter> {

        void setLoadRecycler(@NonNull ArrayList<RecyclerObject> mDataSet);

        void setRangeBar();

        void setLayouts();
    }

    interface Presenter extends BasePresenter {

    }

}