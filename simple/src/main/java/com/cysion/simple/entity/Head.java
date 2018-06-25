package com.cysion.simple.entity;

/**
 * Created by Administrator on 2018\6\25 0025.
 */

public class Head {
    private String CODE;
    private String SID;
    private String TIMESTAMP;
    private String SERVICEID;

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String aCODE) {
        CODE = aCODE;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String aSID) {
        SID = aSID;
    }

    public String getTIMESTAMP() {
        return TIMESTAMP;
    }

    public void setTIMESTAMP(String aTIMESTAMP) {
        TIMESTAMP = aTIMESTAMP;
    }

    public String getSERVICEID() {
        return SERVICEID;
    }

    public void setSERVICEID(String aSERVICEID) {
        SERVICEID = aSERVICEID;
    }
}
