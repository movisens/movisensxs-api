package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

public class Proband {

    @Expose
    @NotNull
    private Integer id;
    @Expose
    @Nullable
    private Date startDate;
    @Expose
    @Nullable
    private Date endDate;
    @Expose
    @Nullable
    private String coupleURL;
    @Expose
    @Nullable
    private Date coupleDate;
    @Expose
    @Nullable
    private String currentVersion;

    @Expose
    private ProbandStatus status;

    public enum ProbandStatus {
        @SerializedName("running") RUNNING,
        @SerializedName("paused") PAUSED,
        @SerializedName("uncoupled") UNCOUPLED,
        @SerializedName("unknown") UNKNOWN,
        @SerializedName("finished") FINISHED
    }

    @Nullable
    public Date getCoupleDate() {
        return coupleDate;
    }

    @Nullable
    public String getCoupleURL() {
        return coupleURL;
    }

    @Nullable
    public String getCurrentVersion() {
        return currentVersion;
    }

    @Nullable
    public Date getEndDate() {
        return endDate;
    }

    @NotNull
    public Integer getId() {
        return id;
    }

    @Nullable
    public Date getStartDate() {
        return startDate;
    }

    public ProbandStatus getStatus() {
        return status;
    }

    public void setCoupleDate(Date coupleDate) {
        this.coupleDate = coupleDate;
    }

    public void setCoupleURL(String coupleURL) {
        this.coupleURL = coupleURL;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setStatus(ProbandStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Proband{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", coupleURL='" + coupleURL + '\'' +
                ", coupleDate=" + coupleDate +
                ", currentVersion='" + currentVersion + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Proband proband = (Proband) o;

        if (id != null ? !id.equals(proband.id) : proband.id != null) return false;
        if (startDate != null ? !startDate.equals(proband.startDate) : proband.startDate != null) return false;
        if (endDate != null ? !endDate.equals(proband.endDate) : proband.endDate != null) return false;
        if (coupleURL != null ? !coupleURL.equals(proband.coupleURL) : proband.coupleURL != null) return false;
        if (coupleDate != null ? !coupleDate.equals(proband.coupleDate) : proband.coupleDate != null) return false;
        if (currentVersion != null ? !currentVersion.equals(proband.currentVersion) : proband.currentVersion != null)
            return false;
        if (status != null ? !status.equals(proband.status) : proband.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (coupleURL != null ? coupleURL.hashCode() : 0);
        result = 31 * result + (coupleDate != null ? coupleDate.hashCode() : 0);
        result = 31 * result + (currentVersion != null ? currentVersion.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}