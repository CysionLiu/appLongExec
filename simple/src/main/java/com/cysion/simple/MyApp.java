package com.cysion.simple;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

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
                Log.e("flag--", "onActivityCreated(MyApp.java:19)-->>" + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.e("flag--", "onActivityStarted(MyApp.java:24)-->>" + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.e("flag--", "onActivityResumed(MyApp.java:29)-->>" + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Log.e("flag--", "onActivityPaused(MyApp.java:34)-->>" + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.e("flag--", "onActivityStopped(MyApp.java:39)-->>" + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Log.e("flag--", "onActivitySaveInstanceState(MyApp.java:44)-->>" + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.e("flag--", "onActivityDestroyed(MyApp.java:49)-->>" + activity.getClass().getSimpleName());
            }
        });
    }
}
