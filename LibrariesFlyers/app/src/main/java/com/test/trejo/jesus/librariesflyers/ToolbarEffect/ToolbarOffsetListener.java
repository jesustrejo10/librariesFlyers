package com.test.trejo.jesus.librariesflyers.ToolbarEffect;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.test.trejo.jesus.librariesflyers.R;


/**
 * Created by nelso on 12/9/2017.
 */

public class ToolbarOffsetListener implements AppBarLayout.OnOffsetChangedListener {
    private final Resources res;
    private Toolbar toolbar;
    private View toolbarContent;
    private TextView toolbarTitle;


    public ToolbarOffsetListener(Toolbar toolbar, View toolbarContent, TextView toolbarTitle) {
        this.toolbar = toolbar;
        this.toolbarContent = toolbarContent;
        this.toolbarTitle = toolbarTitle;
        res = toolbar.getContext().getResources();
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        final float difference = (float) Math.abs(verticalOffset) / (float) appBarLayout.getTotalScrollRange();
        final boolean isCollapsed = Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange();
        final boolean isExpanded = (verticalOffset == 0);

        final int toolbarColor = res.getColor(R.color.flyers_primary);

        if (isCollapsed) {
            toolbarContent.setAlpha(1f);
            toolbarTitle.setVisibility(View.GONE);
            toolbarContent.setVisibility(View.VISIBLE);
            toolbar.setBackgroundColor(res.getColor(R.color.black));
        } else if (isExpanded) {
            toolbarTitle.setAlpha(1f);
            toolbarTitle.setVisibility(View.VISIBLE);
            toolbarContent.setVisibility(View.GONE);
            toolbar.setBackgroundColor(toolbarColor);
        } else {
            changeTransparencyOfTitles(difference);

            final float amount = 1 - difference;
            final int enlightenedColor = getEnlightenedColor(toolbarColor, amount);
            toolbar.setBackgroundColor(enlightenedColor);
        }
    }

    private void changeTransparencyOfTitles(float difference) {
        if (toolbarTitle.getVisibility() == View.GONE)
            toolbarTitle.setVisibility(View.VISIBLE);
        if (toolbarContent.getVisibility() == View.GONE)
            toolbarContent.setVisibility(View.VISIBLE);

        toolbarTitle.setAlpha(1 - difference);
        toolbarContent.setAlpha(difference);
    }

    private int getEnlightenedColor(int color, float amount) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] = Math.min(1.0f, amount * hsv[2]);
        return Color.HSVToColor(hsv);
    }
}
