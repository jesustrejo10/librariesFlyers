package com.test.trejo.jesus.librariesflyers.utils;

import android.animation.ObjectAnimator;
import android.view.View;

import com.github.aakira.expandablelayout.Utils;

/**
 * Created by roger on 08/09/17.
 */

public class ExpandableAnimation {

    /**
     * Asignar animación a las imagenes de los expandable
     *
     * @param target @{@link View} Vista asignare animación
     * @param from   Desde que grado comienza la animación
     * @param to     Hasta donde termina la animación
     * @return Objeto con animación
     */
    public static ObjectAnimator createRotateAnimator(final View target, final float from, final float to) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotation", from, to);
        animator.setDuration(300);
        animator.setInterpolator(Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR));
        return animator;
    }

}