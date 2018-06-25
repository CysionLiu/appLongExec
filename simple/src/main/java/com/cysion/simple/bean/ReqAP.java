package com.cysion.simple.bean;

import java.util.List;

/**
 * Created by cysion on 2018\6\25 0025.
 * 1.1.1.1.	静态密码验证接口
 */

public class ReqAP {

    /**
     * HEAD : {"CODE":[],"SID":"消息序列号","TIMESTAMP":"时间戳","SERVICEID":"应用标识"}
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
         * CODE : []
         * SID : 消息序列号
         * TIMESTAMP : 时间戳
         * SERVICEID : 应用标识
         */

        private String SID;
        private String TIMESTAMP;
        private String SERVICEID;
        private List<?> CODE;

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

        public List<?> getCODE() {
            return CODE;
        }

        public void setCODE(List<?> CODE) {
            this.CODE = CODE;
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
