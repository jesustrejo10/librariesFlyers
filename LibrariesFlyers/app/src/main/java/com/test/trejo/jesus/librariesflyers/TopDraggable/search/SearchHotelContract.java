package com.test.trejo.jesus.librariesflyers.TopDraggable.search;

import android.support.annotation.NonNull;

import com.test.trejo.jesus.librariesflyers.BasePresenter;
import com.test.trejo.jesus.librariesflyers.BaseView;
import com.test.trejo.jesus.librariesflyers.TopDraggable.model.Filter;
import com.test.trejo.jesus.librariesflyers.TopDraggable.model.Sort;

/**
 * Created by roger on 06/09/17.
 */

public interface SearchHotelContract {

    interface View extends BaseView<Presenter> {

        void setupInit();

        void setupPanel();

        void setupExpandable();

        void setRangePrice();
    }

    interface Presenter extends BasePresenter {

        void sendFilterAndSort(@NonNull Filter mFilter, @NonNull Sort mSort);

    }

}