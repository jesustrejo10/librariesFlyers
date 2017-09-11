package com.test.trejo.jesus.librariesflyers.TopDraggable.model;

import android.widget.ImageView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

/**
 * Created by roger on 11/09/17.
 */

/**
 * <p>
 * Modelo {@link Expandables}
 * </p>
 */
public class Expandables {

    private ExpandableRelativeLayout expandableRelativeLayout;
    private ImageView imageView;

    public Expandables(ExpandableRelativeLayout expandableRelativeLayout, ImageView imageView) {
        this.expandableRelativeLayout = expandableRelativeLayout;
        this.imageView = imageView;
    }

    public ExpandableRelativeLayout getExpandableRelativeLayout() {
        return expandableRelativeLayout;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
