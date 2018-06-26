package com.cysion.simple.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cysion.simple.R;
import com.cysion.simple.ui.TopBar;

public class SmsActivity extends AppCompatActivity {

    private TopBar mTopBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        mTopBar = (TopBar) findViewById(R.id.rl_topbar);
        mTopBar.setTitle("短信验证");
        mTopBar.setOnTopBarClickListener(new TopBar.OnTopBarClickListener() {
            @Override
            public void onIconClicked(View aView, TopBar.Pos aPosition) {
                if (aPosition == TopBar.Pos.LEFT) {
                    finish();
                }
            }
        });
    }
}
