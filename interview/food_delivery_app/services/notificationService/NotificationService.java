package food_delivery_app.services.notificationService;
import food_delivery_app.model.Customer;
import food_delivery_app.model.Order;

interface Notification {
    void sendNotification(Customer customer,String message);
}
class SMSNotification implements Notification {
    @Override
    public void sendNotification(Customer customer,String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}
class EmailNotification implements Notification {
    @Override
    public void sendNotification(Customer customer,String message) {
        System.out.println("Sending Email notification: " + message);
    }
} 
interface NotificationChannel {
    void send(Order status);
}
public class NotificationService implements NotificationChannel {
    
    @Override
    public void send(Order order) {
        String message = "Your order with ID " + order.getId() + " is now " + order.getStatus();
        // For simplicity, we are sending both SMS and Email notifications
        Notification smsNotification = new SMSNotification();
        Notification emailNotification = new EmailNotification();
        Customer customer = order.getCustomer();
        smsNotification.sendNotification(customer,message);
        emailNotification.sendNotification(customer,message);
    }
}