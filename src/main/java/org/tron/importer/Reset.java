package org.tron.importer;

import java.io.IOException;

public class Reset {



  public static void main(String[] args) throws IOException {
    EsImporter esImporter = new EsImporter();
    esImporter.deleteIndex("statistics");

  }
}
