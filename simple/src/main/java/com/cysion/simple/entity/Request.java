package com.cysion.simple.entity;

/**
 * Created by Administrator on 2018\6\25 0025.
 */

public class Request {
    private Head HEAD;
    private Body BODY;

    public Head getHEAD() {
        return HEAD;
    }

    public void setHEAD(Head aHEAD) {
        HEAD = aHEAD;
    }

    public Body getBODY() {
        return BODY;
    }

    public void setBODY(Body aBODY) {
        BODY = aBODY;
    }
}
