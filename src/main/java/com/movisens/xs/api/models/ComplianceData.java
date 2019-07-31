package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;

public class ComplianceData {

    @Expose
    private String name;
    @Expose
    private ComplianceLevel complianceLevel;
    @Expose
    private String message;
    @Expose
    private boolean includeInMail;

    public ComplianceData(String name, ComplianceLevel complianceLevel, String message, boolean includeInMail) {
        this.name = name;
        this.complianceLevel = complianceLevel;
        this.message = message;
        this.includeInMail = includeInMail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ComplianceLevel getComplianceLevel() {
        return complianceLevel;
    }

    public void setComplianceLevel(ComplianceLevel complianceLevel) {
        this.complianceLevel = complianceLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isIncludeInMail() {
        return includeInMail;
    }

    public void setIncludeInMail(boolean includeInMail) {
        this.includeInMail = includeInMail;
    }
}
