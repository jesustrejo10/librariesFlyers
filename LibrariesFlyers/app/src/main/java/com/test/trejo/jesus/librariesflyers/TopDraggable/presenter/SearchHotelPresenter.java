package com.test.trejo.jesus.librariesflyers.TopDraggable.presenter;

import android.support.annotation.NonNull;

import com.test.trejo.jesus.librariesflyers.TopDraggable.search.SearchHotelContract;

/**
 * Created by roger on 06/09/17.
 */

public class SearchHotelPresenter implements SearchHotelContract.Presenter {

    public final static String TAG = SearchHotelPresenter.class.getSimpleName();

    private final SearchHotelContract.View mView;

    /**
     * @param mView View inyectada
     */
    public SearchHotelPresenter(@NonNull SearchHotelContract.View mView) {
        this.mView = mView;
        this.mView.setPresenter(this); // Inyectar presenter desde si mismo
        this.mView.setupInit();
    }

    @Override
    public void start() {
        mView.setupPanel();
        mView.setupExpandable();
        mView.setRangePrice();
    }

}