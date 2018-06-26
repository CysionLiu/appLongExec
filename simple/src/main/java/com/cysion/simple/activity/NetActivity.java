package com.cysion.simple.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cysion.simple.Api;
import com.cysion.simple.R;
import com.cysion.simple.bean.ReqAP;
import com.cysion.simple.net.Caller;
import com.thoughtworks.xstream.XStream;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetActivity extends AppCompatActivity {

    String baseUrl = "http://172.16.168.105:8000/app/polls/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
        Caller.obj().init(baseUrl, new Caller.Injector() {
            @Override
            public Map<String, String> headers() {
                return new HashMap<String, String>();
            }
        });
    }

    public void get(View view) {
        Caller.obj().load(Api.class).getSimple().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(NetActivity.this, "onResponse--30", Toast.LENGTH_SHORT).show();
                Log.i("flag--", "NetActivity.onResponse(NetActivity.java:32)--" + response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(NetActivity.this, "onFailure--37", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void post(View view) {
        Caller.obj().load(Api.class).postSimple("android").enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(NetActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(NetActivity.this, "onFailure--63", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void xml(View view) {
        XStream xStream = new XStream();
        xStream.alias("REQUEST", ReqAP.class);
        xStream.alias("HEAD", ReqAP.HEADBean.class);
        xStream.alias("BODY", ReqAP.BODYBean.class);
        ReqAP.HEADBean headBean = new ReqAP.HEADBean();
        headBean.setSID("123123123");
        headBean.setCODE("code123");
        headBean.setSERVICEID("serid");
        headBean.setTIMESTAMP("" + System.currentTimeMillis());
        ReqAP.BODYBean bodyBean = new ReqAP.BODYBean();
        bodyBean.setLOGINPWD("pwd");
        bodyBean.setMAINACCT("administrator");
        ReqAP ap = new ReqAP();
        ap.setBODY(bodyBean);
        ap.setHEAD(headBean);
        String targetXml = xStream.toXML(ap);
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), targetXml);
        Caller.obj().load(Api.class).postXml(body).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(NetActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(NetActivity.this, "onFailure--99", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void json(View view) {

    }
}
