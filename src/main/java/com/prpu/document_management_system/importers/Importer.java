package com.prpu.document_management_system.importers;

import com.prpu.document_management_system.Document;

import java.io.File;
import java.io.IOException;

interface Importer {

    Document importFile(File file) throws IOException;

}
