package com.cysion.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.cysion.simple.bean.ReqAP;
import com.cysion.simple.bean.ReqKC;
import com.cysion.simple.bean.ReqKV;
import com.cysion.simple.bean.RespAP;
import com.cysion.simple.bean.RespKC;
import com.cysion.simple.bean.RespKV;
import com.cysion.simple.entity.Packages;
import com.cysion.simple.entity.Result;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.io.InputStream;

public class XStreamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xstream);

    }

    public void xml2Bean(View view) {
        String fileName = "packageupdate.xml";
        InputStream in = null;
        try {
            in = getResources().getAssets().open(fileName);
            XStream xStream = new XStream();
            xStream.alias("result", Result.class);
            xStream.alias("package", Packages.class);
            xStream.addImplicitCollection(Result.class,"packages");
            Result result = (Result) xStream.fromXML(in);
            Log.i("flag--", "XStreamActivity.xml2Bean(XStreamActivity.java:34)--" + "version = " + result.getVersion() + "\nupgradeMode = " + result.getUpgradeMode());
            Log.i("flag--", "XStreamActivity.xml2Bean(XStreamActivity.java:35)--" + new Gson().toJson(result.getPackages()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bean2Xml(View view) {
        Result result = new Result();
        result.setUpgradeMode(121);
        result.setVersion("12100");
        Packages packages = new Packages();
        packages.setDesc("bean");
        packages.setLevel(2);
        packages.setSize(100);
        packages.setUrl("http://www.baidu.com");
//        result.setPackages(packages);
        XStream xStream = new XStream();
        xStream.alias("result", Result.class);
        String toXML = xStream.toXML(result);
        Log.i("flag--","XStreamActivity.bean2Xml(XStreamActivity.java:53)--"+toXML);

    }


    public void req1(View view) {
        String fileName = "req_ap.xml";
        InputStream in = null;
        try {
            in = getResources().getAssets().open(fileName);
            XStream xStream = new XStream();
            xStream.alias("REQUEST", ReqAP.class);
            xStream.alias("HEAD", ReqAP.HEADBean.class);
            xStream.alias("BODY", ReqAP.BODYBean.class);
            ReqAP result = (ReqAP) xStream.fromXML(in);
            Log.i("flag--","XStreamActivity.req2obj(XStreamActivity.java:72)--"+(new Gson().toJson(result)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void resp1(View view) {
        String fileName = "resp_ap.xml";
        InputStream in = null;
        try {
            in = getResources().getAssets().open(fileName);
            XStream xStream = new XStream();
            xStream.alias("RESPONSE", RespAP.class);
            xStream.alias("HEAD", RespAP.HEADBean.class);
            xStream.alias("BODY", RespAP.BODYBean.class);
            xStream.alias("SUBACCT", String.class);
            RespAP result = (RespAP) xStream.fromXML(in);
            Log.i("flag--","XStreamActivity.req2obj(XStreamActivity.java:72)--"+(new Gson().toJson(result)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void req2(View view) {
        String fileName = "req_kc.xml";
        InputStream in = null;
        try {
            in = getResources().getAssets().open(fileName);
            XStream xStream = new XStream();
            xStream.alias("CREATENOTEKEY", ReqKC.class);
            xStream.alias("HEAD", ReqKC.HEADBean.class);
            xStream.alias("BODY", ReqKC.BODYBean.class);
            ReqKC result = (ReqKC) xStream.fromXML(in);
            Log.i("flag--","XStreamActivity.req2obj(XStreamActivity.java:72)--"+(new Gson().toJson(result)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void resp2(View view) {
        String fileName = "resp_kc.xml";
        InputStream in = null;
        try {
            in = getResources().getAssets().open(fileName);
            XStream xStream = new XStream();
            xStream.alias("CREATENOTEKEY", RespKC.class);
            xStream.alias("HEAD", RespKC.HEADBean.class);
            xStream.alias("BODY", RespKC.BODYBean.class);
            RespKC result = (RespKC) xStream.fromXML(in);
            Log.i("flag--","XStreamActivity.req2obj(XStreamActivity.java:72)--"+(new Gson().toJson(result)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void req3(View view) {
        String fileName = "req_kv.xml";
        InputStream in = null;
        try {
            in = getResources().getAssets().open(fileName);
            XStream xStream = new XStream();
            xStream.alias("NOTEKEYVALIDATE", ReqKV.class);
            xStream.alias("HEAD", ReqKV.HEADBean.class);
            xStream.alias("BODY", ReqKV.BODYBean.class);
            ReqKV result = (ReqKV) xStream.fromXML(in);
            Log.i("flag--","XStreamActivity.req2obj(XStreamActivity.java:72)--"+(new Gson().toJson(result)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resp3(View view) {
        String fileName = "resp_kv.xml";
        InputStream in = null;
        try {
            in = getResources().getAssets().open(fileName);
            XStream xStream = new XStream();
            xStream.alias("NOTEKEYVALIDATE", RespKV.class);
            xStream.alias("HEAD", RespKV.HEADBean.class);
            xStream.alias("BODY", RespKV.BODYBean.class);
            RespKV result = (RespKV) xStream.fromXML(in);
            Log.i("flag--","XStreamActivity.req2obj(XStreamActivity.java:72)--"+(new Gson().toJson(result)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
