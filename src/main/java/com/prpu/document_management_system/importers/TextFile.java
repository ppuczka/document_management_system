package com.prpu.document_management_system.importers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static com.prpu.document_management_system.Attributes.PATH;
import static java.util.stream.Collectors.toList;

public class TextFile {

    private File file;

    private final Map<String, String> attributes;
    private final List<String> lines;


    public TextFile(File file) throws IOException {
        this.attributes = new HashMap<>();
        this.attributes.put(PATH, file.getPath());
        this.lines = Files.lines(file.toPath()).collect(toList());
    }

    int addLines(
            final int start,
            final Predicate<String> isEnd,
            final String attributeName) {

        final StringBuilder accumulator = new StringBuilder();
        int lineNumber;
        for (lineNumber = start; lineNumber < lines.size(); lineNumber++) {
            final String line = lines.get(lineNumber);
            if (isEnd.test(line)) {
                break;
            }

            accumulator.append(line);
            accumulator.append("\n");
        }
        attributes.put(attributeName, accumulator.toString().trim());
        return lineNumber;
    }

    void addLineSuffix(final String prefix, final String attributeName) {
        for (String line : lines) {
            if (line.startsWith(prefix)) {
                attributes.put(attributeName, line.substring(prefix.length()));
                break;
            }
        }
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}