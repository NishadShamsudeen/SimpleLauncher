package net.skwh.simplelauncher;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        loadSettings();
        populateScreen();
    }

    private void loadSettings() {

    }

    private void populateScreen() {

    }

    public void showApps(View v) {
        Intent i = new Intent(this, AppsActivity.class);
        startActivity(i);
    }

    public void showSettings(View v) {
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
    }
}
