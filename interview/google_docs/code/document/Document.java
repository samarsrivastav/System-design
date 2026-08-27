package google_docs.code.document;

import java.util.List;

public class Document {
    public static List<DocumentElement> documentElement;

    public static void addElement(DocumentElement element) {
        documentElement.add(element);
    }

    public static void renderDocument() {
        for (DocumentElement element : documentElement) {
            element.render();
        }
    }
}
