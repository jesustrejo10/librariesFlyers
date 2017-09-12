package com.test.trejo.jesus.librariesflyers.TopDraggable.model;

/**
 * Created by roger on 11/09/17.
 */

public class Sort {

    private boolean lowestPrice;

    private boolean higherPrice;

    private boolean oneToFiveStar;
    private boolean FiveToOneStar;

    public boolean isLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(boolean lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public boolean isHigherPrice() {
        return higherPrice;
    }

    public void setHigherPrice(boolean higherPrice) {
        this.higherPrice = higherPrice;
    }

    public boolean isOneToFiveStar() {
        return oneToFiveStar;
    }

    public boolean isFiveToOneStar() {
        return FiveToOneStar;
    }

    public void setOneToFiveStar(boolean oneToFiveStar) {
        this.oneToFiveStar = oneToFiveStar;
    }

    public void setFiveToOneStar(boolean fiveToOneStar) {
        FiveToOneStar = fiveToOneStar;
    }
}