package com.cysion.simple;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.util.Log;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class MyJobService extends JobService {
    @Override
    public boolean onStartJob(final JobParameters params) {
        Log.e("flag--", "onStartJob(MyJobService.java:15)-->>" + params.getExtras().getInt("test"));
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                Intent myIntent = new Intent(getApplicationContext(), FakeActivity.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(myIntent);
                jobFinished(params, true);
            }
        });
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.e("flag--", "onStopJob(MyJobService.java:21)-->>");
        return true;
    }
}
