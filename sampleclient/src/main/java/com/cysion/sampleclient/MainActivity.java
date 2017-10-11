package com.cysion.sampleclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e("flag--","run(MainActivity.java:16)-->>");
                new MusicPlayerService();
            }
        }, 1000);
    }
}
