package food_delivery_app_2.strategy.payment_options;

import food_delivery_app_2.strategy.PaymentStrategy;

public class CardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        // Implement card payment processing logic here
        System.out.println("Processing card payment of amount: " + amount);
    }
    
}
