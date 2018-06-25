package com.cysion.simple.entity;

/**
 * Created by Administrator on 2018\6\25 0025.
 */

public class Request2 {

    /**
     * HEAD : {"CODE":"1d","SID":"消息序列号","TIMESTAMP":"时间戳","SERVICEID":"应用标识"}
     * BODY : {"MAINACCT":"主帐号","LOGINPWD":"主帐号对应密码"}
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
         * CODE : 1d
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
         * MAINACCT : 主帐号
         * LOGINPWD : 主帐号对应密码
         */

        private String MAINACCT;
        private String LOGINPWD;

        public String getMAINACCT() {
            return MAINACCT;
        }

        public void setMAINACCT(String MAINACCT) {
            this.MAINACCT = MAINACCT;
        }

        public String getLOGINPWD() {
            return LOGINPWD;
        }

        public void setLOGINPWD(String LOGINPWD) {
            this.LOGINPWD = LOGINPWD;
        }
    }
}
