package net.skwh.simplelauncher;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Evan on 11/29/15.
 */
public class AppPickerPreference extends Preference {
    public AppPickerPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onClick() {
        //open the AppsListActivity
    }
}
