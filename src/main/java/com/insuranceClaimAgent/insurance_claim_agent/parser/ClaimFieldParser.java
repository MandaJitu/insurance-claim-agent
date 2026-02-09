package com.insuranceClaimAgent.insurance_claim_agent.parser;

import com.insuranceClaimAgent.insurance_claim_agent.model.ClaimData;

import javax.swing.*;
import java.util.Map;

public class ClaimFieldParser {

    public static ClaimData parse(Map<String, String> formMap) {
        ClaimData data = new ClaimData();

        data.policyNumber = formMap.get("Text7");
        data.policyHolderName = formMap.get("NAME CONTACT");
        data.incidentDate = formMap.get("Text1");
        if(formMap.get("Check Box5").equals("Yes")){
            data.incidentTime = formMap.get("Text4")+" AM";
        }else{
            data.incidentTime = formMap.get("Text4")+" PM";
        }
        data.location = formMap.get("STREET LOCATION OF LOSS");
        data.description = formMap.get("DESCRIPTION OF ACCIDENT ACORD 101 Additional Remarks Schedule may be attached if more space is required");
        data.estimatedDamage = formMap.get("ESTIMATE AMOUNT_2");
        data.claimType = formMap.get("TYPE BODY");

        return data;
    }

}

