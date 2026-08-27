package google_docs.code.persistence.options;

import google_docs.code.persistence.Persistence;

public class SavetoFile implements Persistence {
    @Override
    public void saveDocument(String documentId, String content) {
        // Logic to save the document to a file
        System.out.println("Saving document with ID: " + documentId + " to a file.");
        // File saving logic goes here
    }
    
}
