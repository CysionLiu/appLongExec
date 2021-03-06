package com.cysion.simple;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.cysion.simple.net.Caller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cysion Liu on 2017/10/13.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Log.d("flag--", "onActivityCreated(MyApp.java:19)-->>" + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.e("flag--", "onActivityStarted(MyApp.java:24)-->>" + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.d("flag--", "onActivityResumed(MyApp.java:29)-->>" + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Log.e("flag--", "onActivityPaused(MyApp.java:34)-->>" + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.d("flag--", "onActivityStopped(MyApp.java:39)-->>" + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.d("flag--", "onActivityDestroyed(MyApp.java:49)-->>" + activity.getClass().getSimpleName());
            }
        });
    }
}
