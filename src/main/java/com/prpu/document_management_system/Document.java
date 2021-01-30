package com.prpu.document_management_system;

import java.util.Map;

public class Document {

    private final Map<String, String> attributes;

    public Document(final Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

}
