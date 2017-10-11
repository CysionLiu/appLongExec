package com.cysion.sampleclient;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * Created by Cysion Liu on 2017/8/30.
 */

public class MusicPlayerService extends Binder {
    @Override
    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        return super.onTransact(code, data, reply, flags);
    }

    public void start(){

    }
    public void stop(){

    }
}
