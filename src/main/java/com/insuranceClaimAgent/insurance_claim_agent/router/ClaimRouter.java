package com.insuranceClaimAgent.insurance_claim_agent.router;

import com.insuranceClaimAgent.insurance_claim_agent.model.ClaimData;

import java.util.List;

public class ClaimRouter {

    public static String route(ClaimData data, List<String> missing) {

        if (!missing.isEmpty()) {
            return "Manual Review";
        }

        if (data.description != null) {
            String d = data.description.toLowerCase();
            if (d.contains("fraud") || d.contains("staged") || d.contains("inconsistent")) {
                return "Investigation Flag";
            }
        }

        if ("injury".equalsIgnoreCase(data.claimType)) {
            return "Specialist Queue";
        }

        if (data.estimatedDamage != null && Integer.parseInt(data.estimatedDamage) < 25000) {
            return "Fast-track";
        }

        return "Standard Processing";
    }
}
