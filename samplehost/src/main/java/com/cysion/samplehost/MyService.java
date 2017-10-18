package com.cysion.samplehost;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.cysion.simple.Book;
import com.cysion.simple.IBookManager;
import com.cysion.simple.ICallBack;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class MyService extends Service {

    private CopyOnWriteArrayList<Book> mBooks;
    private ConcurrentHashMap<String, ICallBack> mICallBackMaps = new ConcurrentHashMap<>();

    public MyService() {
        Log.d("flag--", "MyService(MyService.java:20)-->>" + "服务创建成功");
        mBooks = new CopyOnWriteArrayList<>();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new IBookManager.Stub() {
            @Override
            public void addBook(Book book) throws RemoteException {
                mBooks.add(book);
                Log.d("flag--", "addBook(MyService.java:36)-->>" + "服务器端添加book" + book.toString());
                Set<String> strings = mICallBackMaps.keySet();
                for (String s :
                        strings) {
                    mICallBackMaps.get(s).notify(book);
                }

            }

            @Override
            public List<Book> getBooks() throws RemoteException {
                Log.d("flag--", "getBooks(MyService.java:45)-->>提供书籍列表");
                return mBooks;
            }

            @Override
            public void register(ICallBack callback, int callId) throws RemoteException {
                mICallBackMaps.put(String.valueOf(callId), callback);
                Log.d("flag--", "register(MyService.java:52)-->>注册监听器成功，id为" + callId);
            }
            @Override
            public void unRegister(int callId) throws RemoteException {
                mICallBackMaps.remove(String.valueOf(callId));
                Log.d("flag--", "unRegister(MyService.java:58)-->>解绑监听器成功" + callId);
            }
        };
    }
}
