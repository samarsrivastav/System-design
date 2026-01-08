package dependency_injection;

// class OrderService {
//     private InventoryService inventory = new InventoryService();
//     private PaymentService payment = new RazorpayPayment();
//     private NotificationService notification = new NotificationService();

//     public void checkout(Order order) {
//         inventory.blockItems(order);
//         payment.process(order);
//         notification.sendConfirmation(order);
//     }
// }