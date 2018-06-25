package com.cysion.simple;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private List<Class<?>> mActivites;
    private List<String> strs;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
        }
        mActivites = fillData();
        strs = fillStrs();
        mListView = (ListView) findViewById(R.id.list);
        initListView();
    }

    private void initListView() {
        mListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return mActivites.size();
            }

            @Override
            public Object getItem(int position) {
                return mActivites.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.list_main_item, parent, false);
                TextView text = (TextView) convertView.findViewById(R.id.txt_main_item);
                text.setText(strs.get(position));
                return convertView;
            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(MainActivity.this, mActivites.get(position));
                startActivity(myIntent);
            }
        });

    }

    @NonNull
    private List<Class<?>> fillData() {
        List<Class<?>> temp = new ArrayList<>();
        temp.add(SimpleTouchActivity.class);
        temp.add(JobActivity.class);
        temp.add(AidlActivity.class);
        temp.add(NaviActivity.class);
        temp.add(XStreamActivity.class);
        return temp;
    }

    private List<String> fillStrs() {
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < mActivites.size(); i++) {
            strs.add(mActivites.get(i).getSimpleName());
        }
        return strs;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("flag--","onNewIntent(MainActivity.java:89)-->>");
    }
}
