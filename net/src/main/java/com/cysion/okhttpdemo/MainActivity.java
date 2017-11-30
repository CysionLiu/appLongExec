package com.cysion.okhttpdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private OkHttpClient mClient;
    private LinearLayout mRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("flag--", "onCreate(MainActivity.java:37)-->>" + Build.ID);
        mClient = new OkHttpClient.Builder().build();
        mRoot = (LinearLayout) findViewById(R.id.ly_gloabal);
        SharedPreferences demo = getSharedPreferences("demo", 0);
        demo.edit().putString("demo", "hello").commit();
        String[] strings = fileList();
        Log.e("flag--", "onCreate(MainActivity.java:29)-->>" + strings.length);
        for (int i = 0; i < strings.length; i++) {
            Log.e("flag--", "onCreate(MainActivity.java:30)-->>" + strings);
        }
        getFilesDir();
        getExternalFilesDir("");

    }

    @StringDef({
            "sd", "as"
    })
    public @interface Str {

    }

    public void get01(View view) {

        Picasso.with(this).load(R.id.ly_gloabal).placeholder(R.mipmap.ic_launcher).into(new ImageView(this));
        Request request = new Request.Builder().url(RestUrl.HTTP_GET).get().build();
        Call call = mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("flag--", "onFailure(MainActivity.java:33)-->>" + call.request().url());
                Log.e("flag--", "onFailure(MainActivity.java:34)-->>" + e.getMessage());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("flag--", "onResponse(MainActivity.java:39)-->>" + call.request().url());
                Log.e("flag--", "onResponse(MainActivity.java:40)-->>" + response.body().string());

            }
        });
        Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(myIntent, ActivityOptionsCompat.makeScaleUpAnimation(findViewById(R.id.post01), 200, 220, 90, 160).toBundle());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public void post01(View view) {

        Person per1 = new Person();
        per1.setName("op");
        Person per2 = new Person();
        per2.setName("kl");
        List<Person> arr1 = new ArrayList<>();
        List<Person> arr2 = new ArrayList<>();

        arr1.add(per1);
        arr1.add(per2);
        Log.e("flag--", "post01(MainActivity.java:87)-->>" + arr1.hashCode());

        arr2.add(per1);
        arr2.add(per2);
        Log.e("flag--", "post01(MainActivity.java:91)-->>" + per1.hashCode());
        Log.e("flag--", "post01(MainActivity.java:92)-->>" + per2.hashCode());
        Log.e("flag--", "post01(MainActivity.java:93)-->>" + arr2.hashCode());
        Log.e("flag--", "post01(MainActivity.java:94)-->>" + (Integer.MAX_VALUE + 1));
        Log.e("flag--", "post01(MainActivity.java:95)-->>" + Integer.MAX_VALUE);
        Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(myIntent);
    }

    public void post02(View view) {
//        new MyDialogFragment().show(getSupportFragmentManager(),"fs");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // For a little polish, specify a transition animation
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        // To make it fullscreen, use the 'content' root view as the container
        // for the fragment, which is always the root view for the activity
        transaction.add(R.id.ly_gloabal, new MyDialogFragment())
                .addToBackStack(null).commit();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("tongzhi");
        builder.setContentText("这是个通知");
// Creates an Intent for the Activity
        Intent notifyIntent =
                new Intent(this, SecondActivity.class);
// Sets the Activity to start in a new, empty task
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
// Creates the PendingIntent
        PendingIntent notifyPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        notifyIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

// Puts the PendingIntent into the notification builder
        builder.setAutoCancel(true);
        builder.setContentIntent(notifyPendingIntent);
// Notifications are issued by sending them to the
// NotificationManager system service.
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// Builds an anonymous Notification object from the builder, and
// passes it to the NotificationManager
        mNotificationManager.notify(100, builder.build());
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getMessage(String msg) {

    }
}
