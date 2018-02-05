package com.cysion.baselib.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.DisplayMetrics;

/**
 * Created by cysion on 2017\12\22 0022.
 * 主要放置相关的配置信息，简短使用
 */

public class Box {

    private static Context ctx;
    private static boolean isDebug;
    private static int width;
    private static int height;
    private static Configuration cfg;
    private static Resources res;

    //Application创建时就需要调用此方法
    public static void init(Context aContext, boolean aIsDebug) {
        ctx = aContext.getApplicationContext();
        isDebug = aIsDebug;
        initSize();
        res = ctx.getResources();
        cfg = res.getConfiguration();
    }

    private static void initSize() {
        DisplayMetrics dm = ctx.getResources().getDisplayMetrics();
        width = dm.widthPixels;
        height = dm.heightPixels;
    }

    //上下文
    public static Context ctx() {
        return ctx;
    }
    //是否调试模式
    public static boolean isDebug() {
        return isDebug;
    }
    //屏幕宽
    public static int width() {
        return width;
    }
    //屏幕高
    public static int height() {
        return height;
    }
    //app配置
    public static Configuration cfg() {
        return cfg;
    }
    //resources
    public static Resources res() {
        return res;
    }

    //string
    public static String str(int sid) {
        return res.getString(sid);
    }
    //color
    public static int color(int sid) {
        return res.getColor(sid);
    }
    //drawable
    public static Drawable img(int sid) {
        return res.getDrawable(sid);
    }
    //version code
    public static int vcode() {
        if (ctx == null) {
            return 999999;
        }
        PackageManager packManager = ctx.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packManager.getPackageInfo(ctx.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 999999;
    }
    //wifi mac address
    public String mac() {
        // start get mac address
        WifiManager wifiMan = (WifiManager) ctx.getSystemService(Context.WIFI_SERVICE);
        if (wifiMan != null) {
            WifiInfo wifiInf = wifiMan.getConnectionInfo();
            if (wifiInf != null && wifiInf.getMacAddress() != null) {
                // 48位，如FA:34:7C:6D:E4:D7
                return wifiInf.getMacAddress();
            }
        }
        return null;
    }
    //version name
    public static String vName() throws PackageManager.NameNotFoundException {
        if (ctx == null) {
            return "999999";
        }

        PackageManager packManager = ctx.getPackageManager();
        PackageInfo packageInfo = packManager.getPackageInfo(ctx.getPackageName(), 0);
        return packageInfo.versionName;
    }

}
