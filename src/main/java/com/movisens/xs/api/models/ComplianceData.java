package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;

public class ComplianceData {
    @Expose
    private String name;
    @Expose
    private String complianceLevel;
    @Expose
    private String message;
    @Expose
    private boolean includeInMail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComplianceLevel() {
        return complianceLevel;
    }

    public void setComplianceLevel(String complianceLevel) {
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
