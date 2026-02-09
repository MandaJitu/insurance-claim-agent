package com.insuranceClaimAgent.insurance_claim_agent.model;

public class ClaimData {

    public String policyNumber;
    public String policyHolderName;

    public String incidentDate;
    public String incidentTime;
    public String location;
    public String description;

    public String claimType;
    public String estimatedDamage;

    // getters & setters

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }

    public String getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(String incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getIncidentTime() {
        return incidentTime;
    }

    public void setIncidentTime(String incidentTime) {
        this.incidentTime = incidentTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getEstimatedDamage() {
        return estimatedDamage;
    }

    public void setEstimatedDamage(String estimatedDamage) {
        this.estimatedDamage = estimatedDamage;
    }
}

