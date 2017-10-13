package com.cysion.simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class SimpleTouchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_touch);
        //默认decorview背景白色，普通vp背景无
        getWindow().getDecorView().setBackgroundColor(0x550000);
        findViewById(R.id.btn_touch).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("flag--","onTouch(SimpleTouchActivity.java:18)-->>"+event.getY());
                Log.e("flag--","onTouch(SimpleTouchActivity.java:19)-->>"+event.getRawY());
                return true;
            }
        });

    }
}
