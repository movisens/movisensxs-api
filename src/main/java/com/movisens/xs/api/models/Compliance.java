package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;

import java.util.LinkedList;
import java.util.List;

public class Compliance {

    @Expose
    List<ComplianceData> complianceData = new LinkedList<ComplianceData>();
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

    public Compliance(Integer probandId, String date, boolean notifyByEmail, List<ComplianceData> complianceData) {
        this(probandId, date, notifyByEmail);
        this.complianceData = complianceData;
    }

    public List<ComplianceData> getComplianceData() {
        return complianceData;
    }

    public void setComplianceData(List<ComplianceData> data) {
        this.complianceData = data;
    }

    public void addComplianceData(List<ComplianceData> data) {
        this.complianceData.addAll(data);
    }

    public void addComplianceData(ComplianceData data) {
        this.complianceData.add(data);
    }

    public boolean isNotifyByEmail() {
        return notifyByEmail;
    }

    public void setNotifyByEmail(boolean notifyByEmail) {
        this.notifyByEmail = notifyByEmail;
    }
}
