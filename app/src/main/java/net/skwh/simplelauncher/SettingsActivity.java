package net.skwh.simplelauncher;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Evan on 11/29/15.
 */
public class SettingsActivity extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
