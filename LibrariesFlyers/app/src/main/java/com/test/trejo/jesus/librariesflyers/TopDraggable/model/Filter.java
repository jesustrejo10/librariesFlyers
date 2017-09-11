package com.test.trejo.jesus.librariesflyers.TopDraggable.model;

/**
 * Created by roger on 07/09/17.
 */

public class Filter {

    //    Estrellas
    private boolean OneStar;
    private boolean TwoStar;
    private boolean TheeeStar;
    private boolean FourStar;
    private boolean FiveStar;

    //    Precios
    private String PriceMin;
    private String PriceMax;

    //    Servicios
    private boolean AriConditioning;
    private boolean AirportShufle;
    private boolean IndoorPool;
    private boolean Pets;
    private boolean PAFitness;
    private boolean WiFI;

    //    Regimen
    private boolean OnlyLodging;
    private boolean BreakFast;
    private boolean HalfPension;
    private boolean FullBoard;
    private boolean AllInclusive;


    public boolean isOneStar() {
        return OneStar;
    }

    public void setOneStar(boolean oneStar) {
        OneStar = oneStar;
    }

    public boolean isTwoStar() {
        return TwoStar;
    }

    public void setTwoStar(boolean twoStar) {
        TwoStar = twoStar;
    }

    public boolean isTheeeStar() {
        return TheeeStar;
    }

    public void setTheeeStar(boolean theeeStar) {
        TheeeStar = theeeStar;
    }

    public boolean isFourStar() {
        return FourStar;
    }

    public void setFourStar(boolean fourStar) {
        FourStar = fourStar;
    }

    public boolean isFiveStar() {
        return FiveStar;
    }

    public void setFiveStar(boolean fiveStar) {
        FiveStar = fiveStar;
    }

    public String getPriceMin() {
        return PriceMin;
    }

    public void setPriceMin(String priceMin) {
        PriceMin = priceMin;
    }

    public String getPriceMax() {
        return PriceMax;
    }

    public void setPriceMax(String priceMax) {
        PriceMax = priceMax;
    }

    public boolean isAriConditioning() {
        return AriConditioning;
    }

    public void setAriConditioning(boolean ariConditioning) {
        AriConditioning = ariConditioning;
    }

    public boolean isAirportShufle() {
        return AirportShufle;
    }

    public void setAirportShufle(boolean airportShufle) {
        AirportShufle = airportShufle;
    }

    public boolean isIndoorPool() {
        return IndoorPool;
    }

    public void setIndoorPool(boolean indoorPool) {
        IndoorPool = indoorPool;
    }

    public boolean isPets() {
        return Pets;
    }

    public void setPets(boolean pets) {
        Pets = pets;
    }

    public boolean isPAFitness() {
        return PAFitness;
    }

    public void setPAFitness(boolean PAFitness) {
        this.PAFitness = PAFitness;
    }

    public boolean isWiFI() {
        return WiFI;
    }

    public void setWiFI(boolean wiFI) {
        WiFI = wiFI;
    }

    public boolean isOnlyLodging() {
        return OnlyLodging;
    }

    public void setOnlyLodging(boolean onlyLodging) {
        OnlyLodging = onlyLodging;
    }

    public boolean isBreakFast() {
        return BreakFast;
    }

    public void setBreakFast(boolean breakFast) {
        BreakFast = breakFast;
    }

    public boolean isHalfPension() {
        return HalfPension;
    }

    public void setHalfPension(boolean halfPension) {
        HalfPension = halfPension;
    }

    public boolean isFullBoard() {
        return FullBoard;
    }

    public void setFullBoard(boolean fullBoard) {
        FullBoard = fullBoard;
    }

    public boolean isAllInclusive() {
        return AllInclusive;
    }

    public void setAllInclusive(boolean allInclusive) {
        AllInclusive = allInclusive;
    }
}