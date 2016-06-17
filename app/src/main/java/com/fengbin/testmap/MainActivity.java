package com.fengbin.testmap;

import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;

public class MainActivity extends ActionBarActivity {
    private MapView map_view;
    private AMap aMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map_view = (MapView)findViewById(R.id.map_view);
        map_view.onCreate(savedInstanceState);
        init();
        ToggleButton tb = (ToggleButton) findViewById(R.id.tb);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    aMap.setMapType(AMap.MAP_TYPE_SATELLITE);
                }else {
                    aMap.setMapType(AMap.MAP_TYPE_NORMAL);
                }
            }
        });
    }

    private void init() {
        if(aMap == null) {
            aMap = map_view.getMap();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        map_view.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        map_view.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        map_view.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        map_view.onSaveInstanceState(outState);
    }
}
