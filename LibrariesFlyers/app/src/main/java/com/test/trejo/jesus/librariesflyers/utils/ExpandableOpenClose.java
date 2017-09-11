package com.test.trejo.jesus.librariesflyers.utils;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.test.trejo.jesus.librariesflyers.TopDraggable.model.Expandables;

import java.util.List;

import static com.test.trejo.jesus.librariesflyers.utils.ExpandableAnimation.createRotateAnimator;

/**
 * Created by roger on 08/09/17.
 */

public class ExpandableOpenClose {

    /**
     * Cerrar todos los expandable
     *
     * @param expandablesList @{@link List}
     */
    public static void collapseExpandable(@NonNull List<Expandables> expandablesList) {
        for (Expandables expandables : expandablesList) {
            expandables.getExpandableRelativeLayout().collapse();
        }
    }

    /**
     * Asignar lista de expandable evento e image para ser cambiada
     *
     * @param expandablesList @{@link List}
     */
    public static void setExpandable(List<Expandables> expandablesList) {
        for (Expandables expandables : expandablesList) {
            setExpandableListener(expandables.getExpandableRelativeLayout(), expandables.getImageView());
        }
    }

    /**
     * Asignar Evento y cambio de image a los expandable
     *
     * @param expandableRelativeLayout @{@link ExpandableRelativeLayout}
     * @param imageView                @{@link ImageView}
     */
    private static void setExpandableListener(@NonNull ExpandableRelativeLayout expandableRelativeLayout, @NonNull final ImageView imageView) {
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