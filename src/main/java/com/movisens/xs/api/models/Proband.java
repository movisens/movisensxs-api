package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.Date;

@Generated("org.jsonschema2pojo")
public class Proband {

    @Expose
    private Date coupleDate;
    @Expose
    private String coupleURL;
    @Expose
    private Integer currentDevice;
    @Expose
    private String currentVersion;
    @Expose
    private Date endDate;
    @Expose
    private Integer id;
    @Expose
    private Date startDate;
    @Expose
    private String status;

    public Date getCoupleDate() {
        return coupleDate;
    }

    public String getCoupleURL() {
        return coupleURL;
    }

    public Integer getCurrentDevice() {
        return currentDevice;
    }

    /**
     * @return The currentVersion
     */
    public String getCurrentVersion() {
        return currentVersion;
    }

    public Date getEndDate() {
        return endDate;
    }

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    public void setCoupleDate(Date coupleDate) {
        this.coupleDate = coupleDate;
    }

    public void setCoupleURL(String coupleURL) {
        this.coupleURL = coupleURL;
    }

    public void setCurrentDevice(Integer currentDevice) {
        this.currentDevice = currentDevice;
    }

    /**
     * @param currentVersion The currentVersion
     */
    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

}