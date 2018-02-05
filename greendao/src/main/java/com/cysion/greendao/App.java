package com.cysion.greendao;

import android.app.Application;
import android.content.Context;

import com.cysion.greendao.dao.DaoMaster;
import com.cysion.greendao.dao.DaoSession;

/**
 * Created by Administrator on 2017\12\18 0018.
 */

public class App extends Application {
    private static Context app;
    public static final String DB_NAME = "green";
    private static DaoMaster.DevOpenHelper mOpenHelper;
    private static DaoMaster sDaoMaster;
    private static DaoSession dbSession;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        mOpenHelper = new DaoMaster.DevOpenHelper(this, DB_NAME);
        sDaoMaster = new DaoMaster(mOpenHelper.getWritableDatabase());
        dbSession = sDaoMaster.newSession();
    }

    public static Context app() {
        return app;
    }

    public static DaoMaster.DevOpenHelper dbhelper() {
        return mOpenHelper;
    }

    public static DaoMaster dbMaster() {
        return sDaoMaster;
    }

    public static DaoSession dbSession() {
        return dbSession;
    }
}
