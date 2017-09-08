package com.test.trejo.jesus.librariesflyers.TopDraggable.presenter;

import android.support.annotation.NonNull;

import com.test.trejo.jesus.librariesflyers.App;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.Models.RecyclerObject;
import com.test.trejo.jesus.librariesflyers.R;
import com.test.trejo.jesus.librariesflyers.TopDraggable.TopDraggableContract;

import java.util.ArrayList;

/**
 * Created by roger on 06/09/17.
 */

public class TopDraggablePresenter implements TopDraggableContract.Presenter {

    public final static String TAG = TopDraggablePresenter.class.getSimpleName();

    private final TopDraggableContract.View mView;

    /**
     * @param mView View inyectada
     */
    public TopDraggablePresenter(@NonNull TopDraggableContract.View mView) {
        if (mView == null) {
            throw new NullPointerException("Vista no puede ser nula");
        }
        this.mView = mView;
        this.mView.setPresenter(this); // Inyectar presenter desde si mismo
    }

    @Override
    public void start() {
        mView.setLoadRecycler(this.loadRecycler());
    }

    /**
     * @return Datos simulados
     */
    private ArrayList<RecyclerObject> loadRecycler() {
        ArrayList<RecyclerObject> mDataSet = new ArrayList<>();
        mDataSet.add(new RecyclerObject(App.getContext().getResources().getString(R.string.stars), 1));
        mDataSet.add(new RecyclerObject(App.getContext().getResources().getString(R.string.prices), 2));
        mDataSet.add(new RecyclerObject(App.getContext().getResources().getString(R.string.services), 3));
        mDataSet.add(new RecyclerObject(App.getContext().getResources().getString(R.string.regimen), 4));
        mDataSet.add(new RecyclerObject(App.getContext().getResources().getString(R.string.hotel_shain), 5));
        return mDataSet;
    }
}