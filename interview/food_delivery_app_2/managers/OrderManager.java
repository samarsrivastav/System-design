package food_delivery_app_2.managers;

import java.util.ArrayList;
import java.util.List;

import food_delivery_app_2.model.Order;

public class OrderManager {
    //singleton class to manage orders
    private static OrderManager instance;
    private List<Order> orders;

    public OrderManager() {
        this.orders = new ArrayList<>();
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}
