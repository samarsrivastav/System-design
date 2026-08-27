package food_delivery_app_2.model;

import java.util.List;
import java.util.UUID;


public class Restraunt {
    private UUID id;
    private String name;
    private String address;
    private List<MenuItem> menuItems;

    public Restraunt(String name, String address, List<MenuItem> menuItems) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.address = address;
        this.menuItems = menuItems;
    }
    public String getAddress() {
        return address;
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }
}
