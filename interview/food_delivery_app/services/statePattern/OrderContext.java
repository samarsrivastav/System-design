package food_delivery_app.services.statePattern;

import food_delivery_app.model.OrderStatus;

public class OrderContext{
    public OrderState orderState;
    public OrderContext() {
        this.orderState = new CreatedState(this);
    }
    public void cancel(OrderContext orderContext) {
        orderState.cancel(this);
    }
    public void next(OrderContext orderContext) {
        orderState.next(this);
    }
    public void getCurrentState() {
        orderState.getCurrentState();  
    }
    public void setStatus(OrderContext orderContext, OrderStatus status) {
        orderState.setStatus(this, status.name());
    }
}
interface OrderState {
    
    void cancel(OrderContext orderContext);
    void next(OrderContext orderContext);
    void getCurrentState();
    void setStatus(OrderContext orderContext, String status);
}
class CreatedState implements OrderState {
    private OrderContext orderContext;
    public CreatedState(OrderContext orderContext) {
        this.orderContext = orderContext;
    }
    public void cancel(OrderContext orderContext) {
        System.out.println("Order cancelled.");
        orderContext.orderState = new CancelledState(orderContext);
    }
    public void next(OrderContext orderContext) {
        // Implementation for next state
        System.out.println("Order accepted.");
        orderContext.orderState = new AcceptedState(orderContext);
    }
    public void getCurrentState() {
        System.out.println("Current state: Created");
    }
    public void setStatus(OrderContext orderContext, String status) {
       orderContext.setStatus(orderContext, status);
    }
}
//similarly we can implement other states like AcceptedState, PreparingState, OutForDeliveryState, DeliveredState, CancelledState etc.