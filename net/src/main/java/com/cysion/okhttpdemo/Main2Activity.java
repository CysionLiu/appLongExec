package com.cysion.okhttpdemo;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Field;

public class Main2Activity extends AppCompatActivity {

    private WebView mView;
    private Point mPoint = new Point(1, 2);

    public void weixin(View view) {
        Intent intent = new Intent();
        intent.setAction("com.cysion.second");
        startActivity(intent);
        mView.post(new Runnable() {
            @Override
            public void run() {
            }
        });
    }

    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.e("flag--","onCreate(Main2Activity.java:41)-->>");

//        mView = (WebView) findViewById(R.id.web);
//        mView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                Log.e("flag--", "shouldOverrideUrlLoading(Main2Activity.java:75)-->>" + url);
//                view.loadUrl(url);
//                return true;
//            }
//        });
//        WebSettings wSet = mView.getSettings();
//        wSet.setJavaScriptEnabled(true);
//
//        mView.loadUrl("file:///android_asset/er.html");
    }


    public void eventShow(View view) {
//        Log.e("flag--", "eventShow(Main2Activity.java:49)-->>");
//        getSubscribers(EventBus.class);
        Intent intent = new Intent();
        intent.setAction("com.cysion.second");
        startActivity(intent);

    }

    public void getSubscribers(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            Log.e("flag--", "getSubscribers(Main2Activity.java:59)-->>" + field.getName());
        }
        //获取单个变量的值
        try {
            Field field = clazz.getDeclaredField("typesBySubscriber");
            field.setAccessible(true);
            Log.e("flag--", "getSubscribers(Main2Activity.java:69)-->>" + field.getName());
            try {
                Object point = field.get(EventBus.getDefault());
                Log.e("flag--", "getSubscribers(Main2Activity.java:71)-->>" + point.toString());
            } catch (IllegalAccessException aE) {
                aE.printStackTrace();
            }
        } catch (NoSuchFieldException aE) {
            aE.printStackTrace();
        }
        gets(UO,UI,1);

    }
    private void gets(@U int aUI,@M int x,@N int y){

    }

    public static final int UO = 683;
    public static final int UI = 685;
    @IntDef({UO, UI})
    @interface U {
    }

    @OnlyInt({UO,UI})
    @interface M{

    }
    @OnlyInt(11)
    @interface N{

    }
    Handler mHandler = new Handler();

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
