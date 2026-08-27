package food_delivery_app_2.model;

import java.util.List;

public class Cart {
    private List<MenuItem> items;
    private Restraunt restaurant;
    public Cart(List<MenuItem> items, Restraunt restaurant) {
        this.items = items;
        this.restaurant = restaurant;
    }
    public List<MenuItem> getItems() {
        return items;
    }
    public double getTotal(){
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
    public void addItem(MenuItem item) {
        items.add(item);
    }
}
