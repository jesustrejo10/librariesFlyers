package com.test.trejo.jesus.librariesflyers.utils;

import android.os.Handler;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

/**
 * Created by roger on 08/09/17.
 */

public class StatesPanel {

    private final static int TIME_PANEL = 100;

    /**
     * Cerrar filtro
     */
    public static void setPanelExpande(final SlidingUpPanelLayout mPanel) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPanel.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
            }
        }, TIME_PANEL);
    }

    /**
     * Cerrar filtro
     */
    public static void setPanelState(SlidingUpPanelLayout mPanel) {
        if (mPanel != null) mPanel.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
    }

    /**
     * Cerrar el panel de filtro
     */
    public static void closeSlidingPanelFilterOrOder(SlidingUpPanelLayout mPanel) {
        if (mPanel != null && (mPanel.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED || mPanel.getPanelState() == SlidingUpPanelLayout.PanelState.ANCHORED)) {
            mPanel.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        }
    }

}