package google_docs.code.persistence.options;

import google_docs.code.persistence.Persistence;

public class SaveToDb implements Persistence {
    @Override
    public void saveDocument(String documentId, String content) {
        // Logic to save the document to a database
        System.out.println("Saving document with ID: " + documentId + " to the database.");
        // Database saving logic goes here
    }
    
}
