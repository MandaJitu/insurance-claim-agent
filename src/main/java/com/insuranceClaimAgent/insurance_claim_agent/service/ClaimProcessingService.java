package com.insuranceClaimAgent.insurance_claim_agent.service;

import com.insuranceClaimAgent.insurance_claim_agent.extractor.FnolExtractor;
import com.insuranceClaimAgent.insurance_claim_agent.model.ClaimData;
import com.insuranceClaimAgent.insurance_claim_agent.parser.ClaimFieldParser;
import com.insuranceClaimAgent.insurance_claim_agent.router.ClaimRouter;
import com.insuranceClaimAgent.insurance_claim_agent.validator.ClaimValidator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClaimProcessingService {

    public Map<String, Object> process(MultipartFile file) throws Exception {

        File tempFile = File.createTempFile("fnol", ".pdf");
        file.transferTo(tempFile);

        Map<String, String> textMap = FnolExtractor.extractText(tempFile.getAbsolutePath());

        ClaimData data = ClaimFieldParser.parse(textMap);
        List<String> missing = ClaimValidator.findMissing(data);
        String route = ClaimRouter.route(data, missing);

        Map<String, Object> response = new HashMap<>();
        response.put("extractedFields", data);
        response.put("missingFields", missing);
        response.put("recommendedRoute", route);
        response.put("reasoning", buildReason(missing));

        return response;
    }

    private String buildReason(List<String> missing) {
        if (!missing.isEmpty()) {
            return "Mandatory fields are missing";
        }
        return "Routing applied based on business rules";
    }
}