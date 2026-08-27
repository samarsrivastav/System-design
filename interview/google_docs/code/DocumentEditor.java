package google_docs.code;

import google_docs.code.document.Document;
import google_docs.code.document.elements.ImgElement;
import google_docs.code.document.elements.TextElement;
import google_docs.code.persistence.Persistence;

public class DocumentEditor {

    public static Document document;
    public static Persistence persistence;

    public DocumentEditor(Document document, Persistence persistence) {
        DocumentEditor.document = document;
        DocumentEditor.persistence = persistence;
    }
    
    public void addElementFactory(String elementType, String content) {
        if (elementType.equalsIgnoreCase("text")) {
            Document.addElement(new TextElement(content));
        } else if (elementType.equalsIgnoreCase("image")) {
            Document.addElement(new ImgElement(content));
        } else {
            System.out.println("Invalid element type. Please use 'text' or 'image'.");
        }
    }

    public void renderDocument() {
        Document.renderDocument();
    }
    public void saveDocument(String documentId, String content) {
        persistence.saveDocument(documentId, content);
    }

    //client code
    public static void main(String[] args) {
        System.out.println("Welcome to the Google Docs Document Editor!");
        // Additional code for document editing functionality can be added here
    }
}
