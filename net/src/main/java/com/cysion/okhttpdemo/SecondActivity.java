package com.cysion.okhttpdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void bindService(View view) {
        Log.e("flag--", "bindService(SecondActivity.java:25)-->>");
        bindService(new Intent(this, RemoteService.class), mServiceConnection, BIND_AUTO_CREATE);
    }

    private Messenger mMessenger;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.e("flag--", "handleMessage(SecondActivity.java:33)-->>" + msg.what);
        }
    };
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("flag--", "onServiceConnected(SecondActivity.java:40)-->>");
            mMessenger = new Messenger(service);
            Message msg = Message.obtain();
            msg.what = 110;
            msg.replyTo = new Messenger(mHandler);
            try {
                mMessenger.send(msg);
            } catch (RemoteException aE) {
                aE.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("flag--", "onServiceDisconnected(SecondActivity.java:54)-->>");
        }
    };
}
