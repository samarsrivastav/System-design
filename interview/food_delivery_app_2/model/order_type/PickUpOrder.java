package food_delivery_app_2.model.order_type;

import java.util.List;
import java.util.UUID;

import food_delivery_app_2.model.MenuItem;
import food_delivery_app_2.model.Order;
import food_delivery_app_2.model.Restraunt;
import food_delivery_app_2.model.User;
import food_delivery_app_2.strategy.PaymentStrategy;

public class PickUpOrder extends Order {

    public PickUpOrder(User user, Restraunt restaurant, List<MenuItem> items, PaymentStrategy paymentStrategy) {
        super(user, restaurant, items, paymentStrategy);
    }
    public String getOrderType() {
        return "PickUp";
    }
}
