package food_delivery_app_2.model.order_type;

import java.util.List;

import food_delivery_app_2.model.User;
import food_delivery_app_2.strategy.PaymentStrategy;
import food_delivery_app_2.model.MenuItem;
import food_delivery_app_2.model.Order;
import food_delivery_app_2.model.Restraunt;

public class DeliveryOrder extends Order {

    public DeliveryOrder(User user, Restraunt restaurant, List<MenuItem> items, PaymentStrategy paymentStrategy) {
        super(user, restaurant, items, paymentStrategy);
    }
    
    public String getOrderType() {
        return "Delivery";
    }
}
