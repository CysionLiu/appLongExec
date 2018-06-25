package com.cysion.simple.bean;

import java.util.List;

/**
 * Created by cysion on 2018\6\25 0025.
 * 1.1.1.1.	静态密码验证接口
 */

public class RespAP {

    /**
     * HEAD : {"CODE":"消息标志","SID":"消息序列号","TIMESTAMP":"时间戳","SERVICEID":"应用标识"}
     * BODY : {"KEY":"关键标志","ERRCODE":"错误代码","ERRDESC":"错误描述","MAINACCT":"42f","SUBACCTS":["从帐号登录名","从帐号登录名"],"MOBILE":"手机号"}
     */

    private HEADBean HEAD;
    private BODYBean BODY;

    public HEADBean getHEAD() {
        return HEAD;
    }

    public void setHEAD(HEADBean HEAD) {
        this.HEAD = HEAD;
    }

    public BODYBean getBODY() {
        return BODY;
    }

    public void setBODY(BODYBean BODY) {
        this.BODY = BODY;
    }

    public static class HEADBean {
        /**
         * CODE : 消息标志
         * SID : 消息序列号
         * TIMESTAMP : 时间戳
         * SERVICEID : 应用标识
         */

        private String CODE;
        private String SID;
        private String TIMESTAMP;
        private String SERVICEID;

        public String getCODE() {
            return CODE;
        }

        public void setCODE(String CODE) {
            this.CODE = CODE;
        }

        public String getSID() {
            return SID;
        }

        public void setSID(String SID) {
            this.SID = SID;
        }

        public String getTIMESTAMP() {
            return TIMESTAMP;
        }

        public void setTIMESTAMP(String TIMESTAMP) {
            this.TIMESTAMP = TIMESTAMP;
        }

        public String getSERVICEID() {
            return SERVICEID;
        }

        public void setSERVICEID(String SERVICEID) {
            this.SERVICEID = SERVICEID;
        }
    }

    public static class BODYBean {
        /**
         * KEY : 关键标志
         * ERRCODE : 错误代码
         * ERRDESC : 错误描述
         * MAINACCT : 42f
         * SUBACCTS : ["从帐号登录名","从帐号登录名"]
         * MOBILE : 手机号
         */

        private String KEY;
        private String ERRCODE;
        private String ERRDESC;
        private String MAINACCT;
        private String MOBILE;
        private List<String> SUBACCTS;

        public String getKEY() {
            return KEY;
        }

        public void setKEY(String KEY) {
            this.KEY = KEY;
        }

        public String getERRCODE() {
            return ERRCODE;
        }

        public void setERRCODE(String ERRCODE) {
            this.ERRCODE = ERRCODE;
        }

        public String getERRDESC() {
            return ERRDESC;
        }

        public void setERRDESC(String ERRDESC) {
            this.ERRDESC = ERRDESC;
        }

        public String getMAINACCT() {
            return MAINACCT;
        }

        public void setMAINACCT(String MAINACCT) {
            this.MAINACCT = MAINACCT;
        }

        public String getMOBILE() {
            return MOBILE;
        }

        public void setMOBILE(String MOBILE) {
            this.MOBILE = MOBILE;
        }

        public List<String> getSUBACCTS() {
            return SUBACCTS;
        }

        public void setSUBACCTS(List<String> SUBACCTS) {
            this.SUBACCTS = SUBACCTS;
        }
    }
}
