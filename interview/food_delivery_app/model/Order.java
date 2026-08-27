package food_delivery_app.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private List<OrderItem> items = new ArrayList<>();
    private Restaurant restruant;
    private Customer customer;
    private OrderStatus status;

    public Order() {}

    public Order(String id, List<OrderItem> items, Restaurant restruant, Customer customer, OrderStatus status) {
        this.id = id;
        this.items = items;
        this.restruant = restruant;
        this.customer = customer;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Restaurant getRestaurant() {
        return restruant;
    }

    public void setRestaurant(Restaurant restruant) {
        this.restruant = restruant;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
