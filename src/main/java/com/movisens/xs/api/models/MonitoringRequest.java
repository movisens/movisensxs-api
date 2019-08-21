package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class MonitoringRequest {

    @Expose
    private List<Monitoring> monitoringList = new ArrayList<Monitoring>();

    public MonitoringRequest() {
    }
    public MonitoringRequest(List<Monitoring> monitoringList) {
        this.monitoringList = monitoringList;
    }

    public List<Monitoring> getMonitoringList() {
        return monitoringList;
    }

    public void setMonitoringList(List<Monitoring> monitoringList) {
        this.monitoringList = monitoringList;
    }

    public void add(Monitoring monitoring) {
        monitoringList.add(monitoring);
    }
}
