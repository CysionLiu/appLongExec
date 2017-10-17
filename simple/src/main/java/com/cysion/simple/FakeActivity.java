package com.cysion.simple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

public class FakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("flag--", "onCreate(FakeActivity.java:12)-->>");
        Window window = getWindow();
        window.setGravity(Gravity.LEFT | Gravity.TOP);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = 10;
        attributes.x = 220;
        window.getDecorView().setBackgroundColor(0x99ff0000);
        attributes.y = 220;
        attributes.height = 10;
        attributes.alpha = 0.9f;
        window.setAttributes(attributes);
        finishSelf();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("flag--", "onNewIntent(FakeActivity.java:19)-->>");
        finishSelf();
    }

    private void finishSelf() {
//        getWindow().getDecorView().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Log.d("flag--", "run(FakeActivity.java:23)-->>关闭activity");
//                finish();
//            }
//        }, 3000);
    }
}
