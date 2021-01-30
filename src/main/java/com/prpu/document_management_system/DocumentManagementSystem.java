package com.prpu.document_management_system;

import com.prpu.document_management_system.importers.ImageImporter;
import com.prpu.document_management_system.importers.Importer;
import com.prpu.document_management_system.importers.LetterImporter;
import com.prpu.document_management_system.importers.ReportImporter;

import java.util.HashMap;
import java.util.Map;

public class DocumentManagementSystem {

    private final Map<String, Importer> extensionToImporter = new HashMap<>();

    public DocumentManagementSystem() {
        extensionToImporter.put("letter", new LetterImporter());
        extensionToImporter.put("report", new ReportImporter());
        extensionToImporter.put("image", new ImageImporter());
    }
}
