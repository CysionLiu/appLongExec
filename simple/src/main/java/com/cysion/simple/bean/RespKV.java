package com.cysion.simple.bean;

/**
 * Created by cysion on 2018\6\25 0025.
 * 1.1.1.3.	密钥验证接口
 */

public class RespKV {

    /**
     * HEAD : {"CODE":"消息标志","SID":"消息序列号","TIMESTAMP":"时间戳","SERVICEID":"应用标识"}
     * BODY : {"RSP":"验证结果","ERRDESC":"错误描述"}
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
         * RSP : 验证结果
         * ERRDESC : 错误描述
         */

        private String RSP;
        private String ERRDESC;

        public String getRSP() {
            return RSP;
        }

        public void setRSP(String RSP) {
            this.RSP = RSP;
        }

        public String getERRDESC() {
            return ERRDESC;
        }

        public void setERRDESC(String ERRDESC) {
            this.ERRDESC = ERRDESC;
        }
    }
}
