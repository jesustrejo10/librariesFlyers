package com.test.trejo.jesus.librariesflyers.utils;

import android.animation.ObjectAnimator;
import android.view.View;

import com.github.aakira.expandablelayout.Utils;

/**
 * Created by roger on 08/09/17.
 */

public class ExpandableAnimation {

    public static ObjectAnimator createRotateAnimator(final View target, final float from, final float to) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotation", from, to);
        animator.setDuration(300);
        animator.setInterpolator(Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR));
        return animator;
    }

}