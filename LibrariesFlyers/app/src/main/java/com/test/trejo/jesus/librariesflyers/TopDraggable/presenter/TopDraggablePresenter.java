package com.test.trejo.jesus.librariesflyers.TopDraggable.presenter;

import android.support.annotation.NonNull;

import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.Models.RecyclerObject;
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

    }

    @Override
    public void loadRecycler() {
        ArrayList<RecyclerObject> mDataSet = new ArrayList<>();
        RecyclerObject test = new RecyclerObject();
        mDataSet.add(test);
        mDataSet.add(test);
        mDataSet.add(test);
        mDataSet.add(test);
    }
}