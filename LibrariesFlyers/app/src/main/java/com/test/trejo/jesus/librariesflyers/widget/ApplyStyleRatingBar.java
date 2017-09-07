package com.test.trejo.jesus.librariesflyers.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.widget.RatingBar;

import com.test.trejo.jesus.librariesflyers.R;

/**
 * Created by roger on 07/09/17.
 */

public class ApplyStyleRatingBar {

    /**
     * Este método recibe un ratingBar y setea el color de los stars para que no tengan borde negro. Relleno pleno para las activas y transparente para las inactivas.
     */
    public static void setRatingBarStarsColor(RatingBar ratingBar, Context context) {
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        DrawableCompat.setTint(stars.getDrawable(2), ContextCompat.getColor(context, R.color.yellow));
        stars.getDrawable(0).setColorFilter(ContextCompat.getColor(context, R.color.yellow), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(2).setColorFilter(ContextCompat.getColor(context, R.color.yellow), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(1).setColorFilter(ContextCompat.getColor(context, R.color.yellow), PorterDuff.Mode.SRC_ATOP);
    }

}