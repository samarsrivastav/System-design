package google_docs.code.document.elements;

import google_docs.code.document.DocumentElement;

public class TextElement implements DocumentElement {
    private String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        System.out.println("Rendering text: " + text);
    }
    
}
