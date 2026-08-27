package food_delivery_app_2.model;

import java.util.UUID;

public class MenuItem {
    private UUID id;
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
