package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;

public class MonitoringAlert extends Monitoring {
    @Expose
    private boolean isWarning = false;

    public MonitoringAlert(long probandId, String date, String name, String message, boolean includeInMail) {
        super(probandId, date, MonitoringType.ALERT, name, message, includeInMail);
    }
}
