package structural;
class PaymentSystem {
    public void processPayment(String paymentType, double amount) {
        System.out.println("Processing " + paymentType + " payment of amount: " + amount);
    }
}

class EmailSystem {
    public void sendEmail(String to, String subject, String body) {
        System.out.println("Sending email to " + to + " with subject: " + subject);
    }
}

class ReservationSystem {
    public void sendNotification(String message) {
        System.out.println("Sending notification: " + message);
    }
}

class LoyalityProgram {
    public void addPoints(String customerId, int points) {
        System.out.println("Adding " + points + " points to customer: " + customerId);
    }
}

// ========= Facade =========
class HotelBookingFacade {
    private PaymentSystem paymentSystem;
    private EmailSystem emailSystem;
    private ReservationSystem reservationSystem;
    private LoyalityProgram loyalityProgram;
    public HotelBookingFacade() {
        this.paymentSystem = new PaymentSystem();
        this.emailSystem = new EmailSystem();
        this.reservationSystem = new ReservationSystem();
        this.loyalityProgram = new LoyalityProgram();
    }
    public void bookRoom(String customerId, String email, double amount) {
        paymentSystem.processPayment("Credit Card", amount);
        reservationSystem.sendNotification("Room booked for customer: " + customerId);
        emailSystem.sendEmail(email, "Booking Confirmation", "Your room has been booked successfully.");
        loyalityProgram.addPoints(customerId, 100);
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        HotelBookingFacade hotelBookingFacade = new HotelBookingFacade();
        hotelBookingFacade.bookRoom("C001", "customer@example.com", 500.0);
    }
}
