package com.test.trejo.jesus.librariesflyers.utils;

import android.widget.ImageView;

import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import static com.test.trejo.jesus.librariesflyers.utils.ExpandableAnimation.createRotateAnimator;

/**
 * Created by roger on 08/09/17.
 */

public class ExpandableOpenClose {

    public static void setExpandableListener(ExpandableRelativeLayout expandableRelativeLayout, final ImageView imageView) {
        expandableRelativeLayout.setListener(new ExpandableLayoutListenerAdapter() {
            @Override
            public void onPreOpen() {
                createRotateAnimator(imageView, 0f, 180f).start();
            }

            @Override
            public void onPreClose() {
                createRotateAnimator(imageView, 180f, 0f).start();
            }
        });
    }

}