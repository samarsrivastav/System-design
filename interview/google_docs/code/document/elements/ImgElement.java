package google_docs.code.document.elements;

import google_docs.code.document.DocumentElement;

public class ImgElement implements DocumentElement {
    private String imageUrl;

    public ImgElement(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public void render() {
        System.out.println("Rendering image from URL: " + imageUrl);
    }
    
}
