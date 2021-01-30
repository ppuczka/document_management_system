package com.prpu.document_management_system;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class DocumentManagementSystemTest {

    private static final String RESOURCES = "src"
            + File.separator + "test" + File.separator + "resources" + File.separator;
    private static final String LETTER = RESOURCES + "patient.letter";
    private static final String REPORT = RESOURCES + "patient.report";
    private static final String XRAY = RESOURCES + "xray.jpg";
    private static final String INVOICE = RESOURCES + "patient.invoice";
    private static final String JOE_BLOGGS = "Joe Bloggs";

    private DocumentManagementSystem system = new DocumentManagementSystem();

    @Test
    void shouldImportFile() throws Exception {
        system.importFile(LETTER);
        final Document document = onlyDocument();
        assertAttributeEquals(document, Attributes.PATH, LETTER);
    }

    private void assertAttributeEquals(
            final Document document,
            final String attributeName,
            final String expectedValue) {
        assertEquals(
                "src\\test\\resources\\patient.letter",
                expectedValue,
                document.getAttribute(attributeName));
    }

    private Document onlyDocument() {
        final List<Document> documents = system.contents();
        Assertions.assertEquals(documents.size(), 1);
        return documents.get(0);
    }
}