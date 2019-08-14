package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;

public class Compliance {

    @Expose
    private Integer probandId;
    @Expose
    private String date;
    @Expose
    private MonitoringType type;
    @Expose
    private String name;
    @Expose
    private String message;
    @Expose
    private boolean includeInMail;
    @Expose
    private String category;
    @Expose
    private Integer value;


    public Compliance(Integer probandId, String date, MonitoringType type, String name,
                      String message,
                      boolean includeInMail, String category, Integer value) {
        this.probandId = probandId;
        this.date = date;
        this.type = type;
        this.name = name;
        this.message = message;
        this.includeInMail = includeInMail;
        this.category = category;
        this.value = value;
    }

    public Compliance(Integer probandId, String date, MonitoringType type, String name,
                      String message, boolean includeInMail) {
        this.probandId = probandId;
        this.date = date;
        this.type = type;
        this.name = name;
        this.message = message;
        this.includeInMail = includeInMail;
    }
}
