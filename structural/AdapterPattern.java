package structural;
interface PaymentGateway {
    void pay();
}
class PayUGateway implements PaymentGateway{
    @Override
    public void pay() {
        System.out.println("Paying via PayU Gateway");
    }
}
class RazorPayApi {
    public void makePayment(){
        System.out.println("Making payment via Razorpay API");
    }
}
class RazorpayAdaptor implements PaymentGateway{
    private RazorPayApi razorPayApi;

    public RazorpayAdaptor(){
        this.razorPayApi = new RazorPayApi();
    }
    @Override
    public void pay(){
        razorPayApi.makePayment();
    }
}
class CheckoutService {
    private PaymentGateway paymentGateway;

    public CheckoutService(PaymentGateway paymentGateway){
        this.paymentGateway= paymentGateway; 
    }
    public void Checkout(){
        paymentGateway.pay();
    }
}
public class AdapterPattern {
    public static void main(String[] args) {
        CheckoutService checkoutService = new CheckoutService(new PayUGateway());
        checkoutService.Checkout();
    }
}
