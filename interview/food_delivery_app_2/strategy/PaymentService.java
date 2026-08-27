package food_delivery_app_2.strategy;

public class PaymentService {
    private PaymentStrategy paymentStrategy;

    public PaymentService() {
        
    }
    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }
    public void processPayment(double amount) {
        paymentStrategy.processPayment(amount);
    }
}
