package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class MonitoringRequest {

    @Expose
    private List<Monitoring> data = new ArrayList<Monitoring>();

    public MonitoringRequest() {
    }

    public void add(Monitoring monitoring) {
        data.add(monitoring);
    }

    public void addAll(List<Monitoring> monitorings) {
        data.addAll(monitorings);
    }

    public List<Monitoring> getData() {
        return data;
    }
}
