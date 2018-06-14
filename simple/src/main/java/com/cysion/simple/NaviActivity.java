package com.cysion.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import devlight.io.library.ntb.NavigationTabBar;

public class NaviActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int[] colors = {0xff4cb7ff,0xff4cb7ff,0xff4cb7ff};
        setContentView(R.layout.activity_navi);
        final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        null,
                        colors[0]
                ).title("无")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        null,
                        colors[1]
                ).title("震动")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        null,
                        colors[2]
                ).title("铃声")
                        .build()
        );

        navigationTabBar.setModels(models);
        navigationTabBar.setModelIndex(0);
        navigationTabBar.setForceTopOffset(10);
//        navigationTabBar.setRevealOnFocusHint();
    }
}
