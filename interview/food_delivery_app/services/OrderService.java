package food_delivery_app.services;

import food_delivery_app.model.Order;
import food_delivery_app.model.OrderStatus;
import food_delivery_app.services.notificationService.NotificationService;
import food_delivery_app.services.statePattern.OrderContext;

public class OrderService {
    private OrderContext orderContext;
    private NotificationService notificationService;
    public OrderService() {
        notificationService = new NotificationService();
    }
    public void placeOrder() {
        this.orderContext = new OrderContext();// this will place the order to the initial state (CreatedState)
    }
    public void updateOrderStatus(Order order, OrderStatus status) {
        if(status == OrderStatus.CANCELLED) {
            orderContext.cancel(orderContext);
        }else {
            System.out.println("Moving to next state...");
            orderContext.setStatus(orderContext, status);
        }
        notificationService.send(order);
    }
    
}
    