package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Compliance {

    @Expose
    List<ComplianceData> data;
    @Expose
    private boolean notifyByEmail;

    public List<ComplianceData> getData() {
        return data;
    }

    public void setData(List<ComplianceData> data) {
        this.data = data;
    }

    public boolean isNotifyByEmail() {
        return notifyByEmail;
    }

    public void setNotifyByEmail(boolean notifyByEmail) {
        this.notifyByEmail = notifyByEmail;
    }
}
