package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;
import java.util.List;

public class ComplianceRequest {

    @Expose
    private List<Compliance> complianceList;

    public ComplianceRequest() {
    }
    public ComplianceRequest(List<Compliance> complianceList) {
        this.complianceList = complianceList;
    }

    public List<Compliance> getComplianceList() {
        return complianceList;
    }

    public void setComplianceList(List<Compliance> complianceList) {
        this.complianceList = complianceList;
    }
}
