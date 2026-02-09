package com.insuranceClaimAgent.insurance_claim_agent.extractor;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FnolExtractor {

    public static Map<String, String> extractText(String path) throws Exception {
        PDDocument document = PDDocument.load(new File(path));
        return extractFormFields(document);
    }
    private static Map<String, String> extractFormFields(PDDocument doc) {
        Map<String, String> map = new HashMap<>();
        PDAcroForm form = doc.getDocumentCatalog().getAcroForm();

        if (form != null) {
            for (PDField field : form.getFieldTree()) {
                map.put(field.getFullyQualifiedName(), field.getValueAsString());
            }
        }
        return map;
    }
}
