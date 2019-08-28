package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class MonitoringRequest {

    @Expose
    private List<Monitoring> monitoringList = new ArrayList<Monitoring>();

    public MonitoringRequest() {
    }

    public void add(Monitoring monitoring) {
        monitoringList.add(monitoring);
    }

    public void addAll(List<Monitoring> monitorings) {
        monitoringList.addAll(monitorings);
    }
}
