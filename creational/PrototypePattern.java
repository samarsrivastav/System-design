package creational;

import java.util.HashMap;
import java.util.Map;

interface EmailTemplate extends Cloneable{
    EmailTemplate clone();
    void setContent(String content);
    void send(String to);
}
class WelcomeEmail implements EmailTemplate{
    private String content;

    public WelcomeEmail(){
        this.content = "Welcome to our service!";
    }
    @Override
    public EmailTemplate clone(){
        try {
            return (WelcomeEmail) super.clone();
        } catch (Exception e) {
            throw new RuntimeException("Cloning not supported");
        }
    }
    public void setContent(String content){
        this.content = content;
    }
    @Override
    public void send(String to) {
        System.out.println("Sending to " + to + ": " + content);
    }
}
class EmailTemplateRegistry{
    private static final Map<String, EmailTemplate> templates = new HashMap<>();

    static {
        templates.put("welcome", new WelcomeEmail());
        // More templates can be added here
    }
    public static EmailTemplate getTemplate(String type){
        EmailTemplate template = templates.get(type);
        return template.clone();
    }
}
public class PrototypePattern {
    public static void main(String[] args) {
        EmailTemplate emailTemplate = EmailTemplateRegistry.getTemplate("welcome");
        emailTemplate.setContent("welcome here!");
        emailTemplate.send("jerry");
    }
}