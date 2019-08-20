package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;

public class MonitoringCompliance extends Monitoring {

    public enum Category {
        FORMS, MOBILE_SENSING, SENSORS
    }

    @Expose
    private Category category;

    @Expose
    private Integer value;

    public MonitoringCompliance(long probandId, String date, MonitoringType type, String name, String message,
                                boolean includeInMail, Category category, Integer value) {
        super(probandId, date, type, name, message, includeInMail);
        this.category = category;
        this.value = value;
    }
}
