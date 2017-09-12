package com.test.trejo.jesus.librariesflyers.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.util.Hashtable;

/**
 * Created by roger on 12/09/17.
 */

public class TypeFace {

    private static final Hashtable<String, Typeface> typefaceCache = new Hashtable<>();

    /**
     * Cambiar tipo de letra
     *
     * @param context   @{@link Context}
     * @param assetPath Nombre de la letra
     * @return @{@link TypeFace}
     */
    public static Typeface getTypeface(Context context, String assetPath) { // Tipo de Letra
        synchronized (typefaceCache) {
            if (!typefaceCache.containsKey(assetPath)) {
                try {
                    Typeface t = Typeface.createFromAsset(context.getAssets(), "fonts/" + assetPath + ".ttf");
                    typefaceCache.put(assetPath, t);
                } catch (Exception e) {
                    Log.e("Typefaces", "Error en typeface '" + assetPath + "' Por " + e.getMessage());
                    return null;
                }
            }
            return typefaceCache.get(assetPath);
        }
    }

}