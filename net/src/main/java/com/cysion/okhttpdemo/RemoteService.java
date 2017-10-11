package com.cysion.okhttpdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class RemoteService extends Service {

    private Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.e("flag--", "handleMessage(RemoteService.java:17)-->>" + msg.what);
            if (msg.replyTo != null) {
                Messenger messenger = msg.replyTo;
                Message msg222 = Message.obtain();
                msg222.what = 9090;
                try {
                    messenger.send(msg222);
                } catch (RemoteException aE) {
                    aE.printStackTrace();
                }
            }

        }
    };

    public RemoteService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Messenger messenger = new Messenger(myHandler);
        Log.d("flag--", "onBind(RemoteService.java:22)-->>" + "onBind");
        return messenger.getBinder();
    }
}
