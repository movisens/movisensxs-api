package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;

public class Monitoring {

    public enum MonitoringType {
        COMPLIANCE, ALERT
    }

    @Expose
    private long probandId;

    @Expose
    private String date;

    @Expose
    private MonitoringType type;

    @Expose
    private String name;

    @Expose
    private String message;

    @Expose
    private boolean includeInMail = false;


    public Monitoring(long probandId, String date, MonitoringType type, String name, String message,
                      boolean includeInMail) {
        this.probandId = probandId;
        this.date = date;
        this.type = type;
        this.name = name;
        this.message = message;
        this.includeInMail = includeInMail;
    }

    public long getProbandId() {
        return probandId;
    }

    public void setProbandId(long probandId) {
        this.probandId = probandId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public MonitoringType getType() {
        return type;
    }

    public void setType(MonitoringType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
