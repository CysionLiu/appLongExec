package com.cysion.simple.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.cysion.simple.R;
import com.cysion.simple.ui.LoginView;

public class MyLoginActivity extends AppCompatActivity {

    private LoginView mLoginBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);
        mLoginBox = (LoginView) findViewById(R.id.ll_login_view);
        mLoginBox.setViewListener(new LoginView.ViewListener() {
            @Override
            public void toLogin(String user, String pwd) {
                Intent myIntent = new Intent(MyLoginActivity.this, SmsActivity.class);
                startActivity(myIntent);
            }

            @Override
            public void forgetPwd() {
                Toast.makeText(MyLoginActivity.this, "forgetPwd", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
