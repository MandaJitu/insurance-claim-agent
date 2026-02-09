package com.insuranceClaimAgent.insurance_claim_agent.validator;

import com.insuranceClaimAgent.insurance_claim_agent.model.ClaimData;

import java.util.ArrayList;
import java.util.List;

public class ClaimValidator {

    public static List<String> findMissing(ClaimData data) {
        List<String> missing = new ArrayList<>();

        if (data.policyNumber == null) missing.add("policyNumber");
        if (data.incidentDate == null) missing.add("incidentDate");
        if (data.location == null) missing.add("location");
        if (data.claimType == null) missing.add("claimType");

        return missing;
    }
}
