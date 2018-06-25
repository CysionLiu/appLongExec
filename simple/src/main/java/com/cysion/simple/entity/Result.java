package com.cysion.simple.entity;

import java.util.List;

/**
 * Created by Administrator on 2018\6\25 0025.
 */
public class Result {
    private String version;
    private int upgradeMode;

    private List<Packages> packages;

    public int getUpgradeMode() {
        return upgradeMode;
    }

    public void setUpgradeMode(int upgradeMode) {
        this.upgradeMode = upgradeMode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Packages> getPackages() {
        return packages;
    }

    public void setPackages(List<Packages> aPackages) {
        packages = aPackages;
    }
}
