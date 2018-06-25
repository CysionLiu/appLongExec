package com.cysion.simple.bean;

/**
 * Created by cysion on 2018\6\25 0025.
 * 1.1.1.3.	密钥验证接口
 */

public class ReqKV {

    /**
     * HEAD : {"CODE":"消息标志","SID":"消息序列号","TIMESTAMP":"时间戳","SERVICEID":"应用标识"}
     * BODY : {"OPERATORID":"操作员4A主帐号","OPERATORIP":"操作员客户端IP","NOTEKEY":"密钥信息(加密)"}
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
         * OPERATORID : 操作员4A主帐号
         * OPERATORIP : 操作员客户端IP
         * NOTEKEY : 密钥信息(加密)
         */

        private String OPERATORID;
        private String OPERATORIP;
        private String NOTEKEY;

        public String getOPERATORID() {
            return OPERATORID;
        }

        public void setOPERATORID(String OPERATORID) {
            this.OPERATORID = OPERATORID;
        }

        public String getOPERATORIP() {
            return OPERATORIP;
        }

        public void setOPERATORIP(String OPERATORIP) {
            this.OPERATORIP = OPERATORIP;
        }

        public String getNOTEKEY() {
            return NOTEKEY;
        }

        public void setNOTEKEY(String NOTEKEY) {
            this.NOTEKEY = NOTEKEY;
        }
    }
}
