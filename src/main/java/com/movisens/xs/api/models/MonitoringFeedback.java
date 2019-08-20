package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;

public class MonitoringFeedback extends Monitoring {
    @Expose
    public boolean sendAsInAppMessage = false;

    public MonitoringFeedback(long probandId, String date, MonitoringType type, String name,
                              String message, boolean includeInMail) {
        super(probandId, date, type, name, message, includeInMail);
    }
}
