package food_delivery_app_2;

import java.util.ArrayList;
import java.util.List;

import food_delivery_app_2.managers.OrderManager;
import food_delivery_app_2.model.MenuItem;
import food_delivery_app_2.model.Restraunt;
import food_delivery_app_2.model.User;
import food_delivery_app_2.model.order_type.DeliveryOrder;
import food_delivery_app_2.strategy.PaymentService;
import food_delivery_app_2.strategy.payment_options.CardPayment;

public class FoodDeliveryApp {

    public static void main(String[] args) {
        User user = new User("John Doe");

        List<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem("Pizza", 10.99));
        items.add(new MenuItem("Pasta", 8.99));

        Restraunt restaurant = new Restraunt("Pizza Place", "123 Main St", items);
        restaurant.addMenuItem(new MenuItem("Biryani", 12.49));

        PaymentService paymentService = new PaymentService(new CardPayment());
        OrderManager orderManager = new OrderManager();

        DeliveryOrder deliveryOrder = new DeliveryOrder(user, restaurant, items, paymentService.getPaymentStrategy());
        orderManager.addOrder(deliveryOrder);

        System.out.println("Order created successfully for user: " + user.getName());
        System.out.println("Order count: " + orderManager.getOrders().size());
    }
}
