package food_delivery_app_2.model;

import java.util.List;
import java.util.UUID;

import food_delivery_app_2.strategy.PaymentStrategy;

public abstract class Order {
    private UUID id;
    private User user;
    private Restraunt restaurant;
    private List<MenuItem> items;
    private PaymentStrategy paymentStrategy;

    public Order(User user, Restraunt restaurant, List<MenuItem> items, PaymentStrategy paymentStrategy) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.restaurant = restaurant;
        this.items = items;
        this.paymentStrategy = paymentStrategy;
    }
    public abstract String getOrderType();

}
