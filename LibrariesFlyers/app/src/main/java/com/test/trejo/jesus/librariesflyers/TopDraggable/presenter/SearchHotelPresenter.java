package com.test.trejo.jesus.librariesflyers.TopDraggable.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.test.trejo.jesus.librariesflyers.TopDraggable.model.Filter;
import com.test.trejo.jesus.librariesflyers.TopDraggable.model.Sort;
import com.test.trejo.jesus.librariesflyers.TopDraggable.search.SearchHotelContract;

import static com.test.trejo.jesus.librariesflyers.utils.Preconditions.checkNotNull;


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
        checkNotNull(mView, "Vista no puede ser nulo");
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

    @Override
    public void sendFilterAndSort(@NonNull Filter mFilter, @NonNull Sort mSort) {
        checkNotNull(mFilter, "Filtro no puede ser nulo");
        checkNotNull(mSort, "Ordenar no puede ser nulo");


    }
}