package food_delivery_app_2.strategy.payment_options;

import food_delivery_app_2.strategy.PaymentStrategy;
public class UpiPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        // Implement UPI payment processing logic here
        System.out.println("Processing UPI payment of amount: " + amount);
    }
}
