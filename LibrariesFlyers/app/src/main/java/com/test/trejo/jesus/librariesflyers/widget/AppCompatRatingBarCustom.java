package com.test.trejo.jesus.librariesflyers.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;

import com.test.trejo.jesus.librariesflyers.R;

/**
 * Created by roger on 07/09/17.
 */

public class AppCompatRatingBarCustom extends android.support.v7.widget.AppCompatRatingBar {

    public AppCompatRatingBarCustom(Context context) {
        super(context);
        init(context);
    }

    public AppCompatRatingBarCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AppCompatRatingBarCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayerDrawable stars = (LayerDrawable) this.getProgressDrawable();
        DrawableCompat.setTint(stars.getDrawable(2), ContextCompat.getColor(context, R.color.star));
        stars.getDrawable(0).setColorFilter(ContextCompat.getColor(context, R.color.star), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(2).setColorFilter(ContextCompat.getColor(context, R.color.star), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(1).setColorFilter(ContextCompat.getColor(context, R.color.star), PorterDuff.Mode.SRC_ATOP);
    }
}