package com.cysion.sampleclient;

import android.util.Log;

import transaction.Cals;

/**
 * Created by Cysion Liu on 2017/8/29.
 */

public class Plugin implements Cals {
    public Plugin() {
        Log.e("flag--", "instance initializer(Plugin.java:11)-->>");
    }


    @Override
    public int cal(int a, int b) {
        return a+b;
    }
}
