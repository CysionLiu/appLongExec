package com.cysion.samplehost;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.util.List;

import dalvik.system.DexClassLoader;
import transaction.Cals;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void invokeClient(View view) {
        Intent intent = new Intent("com.cysion.client.main");
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> resolveInfos = packageManager.queryIntentActivities(intent, 0);
        if (resolveInfos != null && resolveInfos.size() > 0) {
            ResolveInfo resolveInfo = resolveInfos.get(0);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            String packageName = activityInfo.packageName;
            String apkPath = activityInfo.applicationInfo.sourceDir;
            String opdir = getApplicationInfo().dataDir;
            String libsrpath = activityInfo.applicationInfo.nativeLibraryDir;
            DexClassLoader loader = new DexClassLoader(apkPath, opdir, libsrpath, getClassLoader());
            //---
            try {
                Resources resourcesForApplication = packageManager.getResourcesForApplication(packageName);
                int identifier = resourcesForApplication.getIdentifier("names", null, packageName);
                String string = resourcesForApplication.getString(identifier);
                Log.e("flag--","invokeClient(MainActivity.java:44)-->>"+string);
            } catch (PackageManager.NameNotFoundException aE) {
                aE.printStackTrace();
            }
            //
            try {
                Log.e("flag--","invokeClient(MainActivity.java:37)-->>"+packageName);
                Class<?> aClass = loader.loadClass(packageName + ".Plugin");
                Object o = aClass.newInstance();
//                Class[] types = new Class[2];
//                types[0] = Integer.TYPE;
//                types[1] = Integer.TYPE;
//                Method cal = aClass.getMethod("cal", types);
//                Object invoke = cal.invoke(o, 12, 10);
//                Integer i = (Integer) invoke;
//                Log.e("flag--", "invokeClient(MainActivity.java:45)-->>" + i);
                Cals temp = (Cals) o;
                Log.e("flag--","invokeClient(MainActivity.java:49)-->>"+temp.cal(11,12));
            } catch (Exception aE) {
                aE.printStackTrace();
            }
        }
    }

    public void showSelf(View view) {
        String packageCodePath = getApplicationInfo().publicSourceDir;
        File file = new File(packageCodePath);
        if (file.exists()) {
            Log.e("flag--","showSelf(MainActivity.java:59)-->>");
            Log.e("flag--","showSelf(MainActivity.java:60)-->>"+file.isDirectory());
        }
        Log.e("flag--","showSelf(MainActivity.java:56)-->>"+packageCodePath);
    }
}
