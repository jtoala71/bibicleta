package com.asovel.bibicleta.Interface_Usuario.MenuBuscador;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

import com.asovel.bibicleta.R;

/**
 * Clase de utilidades
 */
public class Buscador_Utils {

    public static void setBadgeCount(Context context, LayerDrawable icon, int count) {

        Buscador_BadgeDrawable badge;

        // Reusar drawable
        Drawable reuse = icon.findDrawableByLayerId(R.id.ic_badge);
        if (reuse != null && reuse instanceof Buscador_BadgeDrawable) {
            badge = (Buscador_BadgeDrawable) reuse;
        } else {
            badge = new Buscador_BadgeDrawable(context);
        }

        badge.setCount(count);
        icon.mutate();
        icon.setDrawableByLayerId(R.id.ic_badge, badge);
    }
}