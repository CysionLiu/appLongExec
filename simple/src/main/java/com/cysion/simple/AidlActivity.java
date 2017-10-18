package com.cysion.simple;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.List;
import java.util.Random;

public class AidlActivity extends AppCompatActivity {
    IBookManager mIBookManager;
    private boolean isLinked = false;
    String[] bookNames = {"Android", "Java", "Python", "PHP", "Kotlin", "Go"};
    int[] bookPages = {1000, 800, 500, 300, 300, 200};

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("flag--", "onServiceConnected(AidlActivity.java:21)-->>" + "服务连接成功");
            mIBookManager = IBookManager.Stub.asInterface(service);
            isLinked = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isLinked = false;
        }
    };

    private boolean isLinked() {
        if (!isLinked) {
            Log.d("flag--", "isLinked(AidlActivity.java:35)-->>" + "还未链接服务，服务端在samplehost");
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
    }

    public void addBook(View view) {
        if (!isLinked()) {
            return;
        }
        int temp = new Random().nextInt(6);
        Book book = new Book(bookNames[temp], bookPages[temp]);
        try {
            mIBookManager.addBook(book);
            Log.d("flag--", "addBook(AidlActivity.java:41)-->>" + "客户端请求增加数据"+book);
        } catch (RemoteException aE) {
            aE.printStackTrace();
        }
    }

    public void unBindService(View view) {
        unbindService(mConnection);
    }

    public void bindService(View view) {
        Intent myIntent = new Intent();
        myIntent.setComponent(new ComponentName("com.cysion.samplehost", "com.cysion.samplehost.MyService"));
        bindService(myIntent, mConnection, BIND_AUTO_CREATE);
        Log.d("flag--", "bindService(AidlActivity.java:46)-->>请求绑定服务");
    }

    public void showBook(View view) {
        if (!isLinked()) {
            return;
        }
        try {
            List<Book> books = mIBookManager.getBooks();
            for (int i = 0; i < books.size(); i++) {
                Log.d("flag--", "客户端展示shwBook(AidlActivity.java:40)-->>" + books.get(i));
            }
        } catch (RemoteException aE) {
            aE.printStackTrace();
        }
    }

    public void setListener(View view) {
        if (!isLinked()) {
            return;
        }
        try {
            mIBookManager.register(mICallBack, 1000);
        } catch (RemoteException aE) {
            aE.printStackTrace();
        }

    }

    public void removeListener(View view) {
        try {
            mIBookManager.unRegister(1000);
        } catch (RemoteException aE) {

        }
    }

    private ICallBack mICallBack = new ICallBack() {
        @Override
        public void notify(Book book) throws RemoteException {
        }

        @Override
        public IBinder asBinder() {
            return new Stub() {
                @Override
                public void notify(Book book) throws RemoteException {
                    Log.d("flag--", "notify(AidlActivity.java:117)-->>监听回调" + book.toString());
                }
            };
        }
    };
}
