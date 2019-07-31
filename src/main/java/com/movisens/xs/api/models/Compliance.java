package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;

import java.util.LinkedList;
import java.util.List;

public class Compliance {

    @Expose
    List<ComplianceData> complianceDataList = new LinkedList<ComplianceData>();
    @Expose
    private boolean notifyByEmail;
    private Integer probandId;
    private String date;

    public Compliance(Integer probandId, String date) {
        this.probandId = probandId;
        this.date = date;
    }

    public Compliance(Integer probandId, String date, boolean notifyByEmail) {
        this(probandId, date);
        this.notifyByEmail = notifyByEmail;
    }

    public Compliance(Integer probandId, String date, boolean notifyByEmail, List<ComplianceData> complianceDataList) {
        this(probandId, date, notifyByEmail);
        this.complianceDataList = complianceDataList;
    }

    public List<ComplianceData> getComplianceData() {
        return complianceDataList;
    }

    public void setComplianceData(List<ComplianceData> data) {
        this.complianceDataList = data;
    }

    public void addComplianceData(List<ComplianceData> data) {
        this.complianceDataList.addAll(data);
    }

    public void addComplianceData(ComplianceData data) {
        this.complianceDataList.add(data);
    }

    public boolean isNotifyByEmail() {
        return notifyByEmail;
    }

    public void setNotifyByEmail(boolean notifyByEmail) {
        this.notifyByEmail = notifyByEmail;
    }
}
