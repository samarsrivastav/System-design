package food_delivery_app.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();
    private Restaurant restaurant;
    public Cart() {}

    public Cart(List<CartItem> items, Restaurant restaurant) {
        this.items = items;
        this.restaurant = restaurant;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public void addItem(CartItem item) {
        this.items.add(item);
    }
    public Restaurant getRestaurant() {
        return restaurant;
    }
}
