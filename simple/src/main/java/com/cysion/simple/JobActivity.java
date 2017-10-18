package com.cysion.simple;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class JobActivity extends AppCompatActivity {

    private JobScheduler mScheduler;
    private JobInfo mInfo;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        mScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        JobInfo.Builder builder = new JobInfo.Builder(100, new ComponentName(getPackageName(), MyJobService.class.getName()));
        PersistableBundle persistableBundle = new PersistableBundle();
        builder.setExtras(persistableBundle);
        persistableBundle.putInt("test", 112);
        mInfo = builder.setPeriodic(2000).build();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void startJob(View view) {
        if (mScheduler.schedule(mInfo) < 0) {
            Toast.makeText(JobActivity.this, "开启job失败", Toast.LENGTH_SHORT).show();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void stopJob(View view) {
        mScheduler.cancel(100);
    }

}
