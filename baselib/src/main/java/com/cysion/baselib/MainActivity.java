package com.cysion.baselib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cysion.baselib.utils.Box;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Box.init(this,true);
        Log.e("flag--","onCreate(MainActivity.java:17)---->>"+getExternalCacheDir());
    }
}
