package net.skwh.simplelauncher;

import android.graphics.drawable.Drawable;

/**
 * Created by Evan on 11/29/15.
 */
public class AppDetail {
    CharSequence label;
    CharSequence packageName;
    Drawable icon;

    public AppDetail(CharSequence lb, CharSequence pN, Drawable in) {
        icon = in;
        label = lb;
        packageName = pN;
    }
}
