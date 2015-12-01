package net.skwh.simplelauncher;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AppsActivity extends Activity {

    private List<AppDetail> apps;
    private GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps);

        loadApps();
        populateGridView();
        addClickListener();
    }

    private void loadApps() {
        PackageManager manager = getPackageManager();
        apps = new ArrayList<AppDetail>();

        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> availableActivities = manager.queryIntentActivities(i, 0);
        for (ResolveInfo ri:availableActivities) {
            AppDetail app = new AppDetail(ri.loadLabel(manager),ri.activityInfo.packageName,ri.activityInfo.loadIcon(manager));
            apps.add(app);
        }
    }

    private void populateGridView() {
        grid = (GridView)findViewById(R.id.apps_grid);
        ArrayAdapter<AppDetail> adapter = new ArrayAdapter<AppDetail>(this,R.layout.grid_item,apps) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.grid_item, null);
                }
                ImageView appIcon = (ImageView)convertView.findViewById(R.id.item_app_icon);
                TextView appName = (TextView)convertView.findViewById(R.id.item_app_name);

                appIcon.setImageDrawable(apps.get(position).icon);
                appName.setText(apps.get(position).label);

                return convertView;
            }
        };
        grid.setAdapter(adapter);
    }

    private void addClickListener() {
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos,
                                    long id) {
                Intent i = getPackageManager().getLaunchIntentForPackage(apps.get(pos).packageName.toString());
                AppsActivity.this.startActivity(i);
            }
        });
    }
}
