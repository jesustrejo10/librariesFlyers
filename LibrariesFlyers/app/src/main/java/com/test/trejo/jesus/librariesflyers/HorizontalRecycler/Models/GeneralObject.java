package com.test.trejo.jesus.librariesflyers.HorizontalRecycler.Models;

import java.util.ArrayList;

/**
 * Created by jesus on 04/09/17.
 */

public class GeneralObject {

    String principalTittle;
    ArrayList<Hotel> mHotels;
    Activity mActivity;
    Activity mRentalCars;
    Activity mTraslados;
    ArrayList<RecyclerObject> mOffers;

    public GeneralObject() {
    }

    public String getPrincipalTittle() {
        return principalTittle;
    }

    public ArrayList<Hotel> getmHotels() {
        return mHotels;
    }

    public Activity getmActivity() {
        return mActivity;
    }

    public Activity getmRentalCars() {
        return mRentalCars;
    }

    public Activity getmTraslados() {
        return mTraslados;
    }

    public ArrayList<RecyclerObject> getmOffers() {
        return mOffers;
    }
}
