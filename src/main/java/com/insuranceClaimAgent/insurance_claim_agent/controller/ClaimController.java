package com.insuranceClaimAgent.insurance_claim_agent.controller;

import com.insuranceClaimAgent.insurance_claim_agent.service.ClaimProcessingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ClaimProcessingService service;

    public ClaimController(ClaimProcessingService service) {
        this.service = service;
    }

    @PostMapping("/process")
    public ResponseEntity<?> processClaim(
            @RequestParam("file") MultipartFile file) throws Exception {

        Map<String, Object> result = service.process(file);
        return ResponseEntity.ok(result);
    }
}