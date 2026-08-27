package food_delivery_app_2.model;

import java.util.List;
import java.util.UUID;


public class User {
    private UUID id;
    private String name;
    private Cart cart;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public Cart getCart() {
        return cart;
    }
}
