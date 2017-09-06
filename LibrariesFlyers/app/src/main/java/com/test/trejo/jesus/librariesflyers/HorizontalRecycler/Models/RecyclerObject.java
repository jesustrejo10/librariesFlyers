package com.test.trejo.jesus.librariesflyers.HorizontalRecycler.Models;

/**
 * Created by jesus on 22/08/17.
 */

public class RecyclerObject {

    private String urlImage;
    private String description;
    private String detailMessage;
    private int id;
    private int order;

    public RecyclerObject() {
    }

    public RecyclerObject(String description, int id) {
        this.description = description;
        this.id = id;
    }

    public RecyclerObject(String urlImage, String description, String detailMessage, int id, int order) {
        this.urlImage = urlImage;
        this.description = description;
        this.detailMessage = detailMessage;
        this.id = id;
        this.order = order;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }
}