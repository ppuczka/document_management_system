package com.prpu.document_management_system.importers;

import com.prpu.document_management_system.Document;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.prpu.document_management_system.Attributes.*;

public class ImageImporter implements Importer {

    @Override
    public Document importFile(File importFile) throws IOException {
        final Map<String, String> attributes = new HashMap<>();
        attributes.put(PATH, importFile.getPath());

        final BufferedImage image = ImageIO.read(importFile);
        attributes.put(WIDTH, String.valueOf(image.getWidth()));
        attributes.put(HEIGHT, String.valueOf(image.getHeight()));
        attributes.put(TYPE, "Image");

        return new Document(attributes);
    }
}
