package com.test.trejo.jesus.librariesflyers.TopDraggable.search;

import com.test.trejo.jesus.librariesflyers.BasePresenter;
import com.test.trejo.jesus.librariesflyers.BaseView;

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

    }

}