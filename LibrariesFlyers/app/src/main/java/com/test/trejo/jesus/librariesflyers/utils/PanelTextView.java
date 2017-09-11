package com.test.trejo.jesus.librariesflyers.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by roger on 11/09/17.
 */

public class PanelTextView extends android.support.v7.widget.AppCompatTextView {

    public PanelTextView(Context context) {
        super(context);
        init(context);
    }

    public PanelTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PanelTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        Typeface face = Typeface.createFromAsset(context.getAssets(), "font/SFTextMedium.ttf");
        this.setTypeface(face);
    }
}
