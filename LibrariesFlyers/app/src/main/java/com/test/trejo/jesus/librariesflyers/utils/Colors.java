package com.test.trejo.jesus.librariesflyers.utils;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.widget.ImageView;

/**
 * Created by roger on 11/09/17.
 */

public class Colors {

    public static void applyColorFilter(@NonNull ImageView imageView) {
        int color = Color.parseColor("#878787"); //The color u want
        imageView.setColorFilter(color);
    }

}