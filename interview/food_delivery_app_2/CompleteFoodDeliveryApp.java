package food_delivery_app_2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CompleteFoodDeliveryApp {
    public static void main(String[] args) {
        User user = new User("John Doe");

        List<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem("Pizza", 10.99));
        items.add(new MenuItem("Pasta", 8.99));

        Restraunt restaurant = new Restraunt("Pizza Place", "123 Main St", items);
        restaurant.addMenuItem(new MenuItem("Biryani", 12.49));

        PaymentService paymentService = new PaymentService(new CardPayment());
        OrderFactory factory = new ScheduledOrder();

        Order order = factory.createOrder("Delivery", user, restaurant, items, paymentService.getPaymentStrategy());

        OrderManager orderManager = new OrderManager();
        orderManager.addOrder(order);

        System.out.println("Order placed for: " + user.getName());
        System.out.println("Order type: " + order.getOrderType());
        System.out.println("Total orders: " + orderManager.getOrders().size());
    }

    static class User {
        private final UUID id;
        private final String name;
        private Cart cart;

        public User(String name) {
            this.id = UUID.randomUUID();
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Cart getCart() {
            return cart;
        }

        public void setCart(Cart cart) {
            this.cart = cart;
        }
    }

    static class MenuItem {
        private final UUID id;
        private final String name;
        private final double price;

        public MenuItem(String name, double price) {
            this.id = UUID.randomUUID();
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    static class Cart {
        private final List<MenuItem> items;
        private final Restraunt restaurant;

        public Cart(List<MenuItem> items, Restraunt restaurant) {
            this.items = items;
            this.restaurant = restaurant;
        }

        public List<MenuItem> getItems() {
            return items;
        }

        public Restraunt getRestaurant() {
            return restaurant;
        }

        public void addItem(MenuItem item) {
            items.add(item);
        }

        public double getTotal() {
            double total = 0;
            for (MenuItem item : items) {
                total += item.getPrice();
            }
            return total;
        }
    }

    static class Restraunt {
        private final UUID id;
        private final String name;
        private final String address;
        private final List<MenuItem> menuItems;

        public Restraunt(String name, String address, List<MenuItem> menuItems) {
            this.id = UUID.randomUUID();
            this.name = name;
            this.address = address;
            this.menuItems = menuItems;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public List<MenuItem> getMenuItems() {
            return menuItems;
        }

        public void addMenuItem(MenuItem item) {
            menuItems.add(item);
        }
    }

    static abstract class Order {
        private final UUID id;
        private final User user;
        private final Restraunt restaurant;
        private final List<MenuItem> items;
        private final PaymentStrategy paymentStrategy;

        public Order(User user, Restraunt restaurant, List<MenuItem> items, PaymentStrategy paymentStrategy) {
            this.id = UUID.randomUUID();
            this.user = user;
            this.restaurant = restaurant;
            this.items = items;
            this.paymentStrategy = paymentStrategy;
        }

        public abstract String getOrderType();

        public User getUser() {
            return user;
        }

        public Restraunt getRestaurant() {
            return restaurant;
        }

        public List<MenuItem> getItems() {
            return items;
        }

        public PaymentStrategy getPaymentStrategy() {
            return paymentStrategy;
        }
    }

    static class DeliveryOrder extends Order {
        public DeliveryOrder(User user, Restraunt restaurant, List<MenuItem> items, PaymentStrategy paymentStrategy) {
            super(user, restaurant, items, paymentStrategy);
        }

        @Override
        public String getOrderType() {
            return "Delivery";
        }
    }

    static class PickUpOrder extends Order {
        public PickUpOrder(User user, Restraunt restaurant, List<MenuItem> items, PaymentStrategy paymentStrategy) {
            super(user, restaurant, items, paymentStrategy);
        }

        @Override
        public String getOrderType() {
            return "PickUp";
        }
    }

    static abstract class OrderFactory {
        public abstract Order createOrder(String orderType, User user, Restraunt restaurant, List<MenuItem> items, PaymentStrategy paymentStrategy);
    }

    static class ScheduledOrder extends OrderFactory {
        @Override
        public Order createOrder(String orderType, User user, Restraunt restaurant, List<MenuItem> items, PaymentStrategy paymentStrategy) {
            if ("PickUp".equalsIgnoreCase(orderType)) {
                return new PickUpOrder(user, restaurant, items, paymentStrategy);
            } else if ("Delivery".equalsIgnoreCase(orderType)) {
                return new DeliveryOrder(user, restaurant, items, paymentStrategy);
            }
            throw new IllegalArgumentException("Invalid order type: " + orderType);
        }
    }

    static class InstantOrder extends OrderFactory {
        @Override
        public Order createOrder(String orderType, User user, Restraunt restaurant, List<MenuItem> items, PaymentStrategy paymentStrategy) {
            if ("PickUp".equalsIgnoreCase(orderType)) {
                return new PickUpOrder(user, restaurant, items, paymentStrategy);
            } else if ("Delivery".equalsIgnoreCase(orderType)) {
                return new DeliveryOrder(user, restaurant, items, paymentStrategy);
            }
            throw new IllegalArgumentException("Invalid order type: " + orderType);
        }
    }

    interface PaymentStrategy {
        void processPayment(double amount);
    }

    static class PaymentService {
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
            if (paymentStrategy != null) {
                paymentStrategy.processPayment(amount);
            }
        }
    }

    static class CardPayment implements PaymentStrategy {
        @Override
        public void processPayment(double amount) {
            System.out.println("Processing card payment of amount: " + amount);
        }
    }

    static class UpiPayment implements PaymentStrategy {
        @Override
        public void processPayment(double amount) {
            System.out.println("Processing UPI payment of amount: " + amount);
        }
    }

    static class OrderManager {
        private final List<Order> orders = new ArrayList<>();

        public void addOrder(Order order) {
            orders.add(order);
        }

        public List<Order> getOrders() {
            return orders;
        }
    }

    static class RestaurantManager {
        private final List<Restraunt> restaurants = new ArrayList<>();

        public void addRestaurant(Restraunt restaurant) {
            restaurants.add(restaurant);
        }

        public List<Restraunt> getRestaurantsByLocation(String location) {
            List<Restraunt> result = new ArrayList<>();
            for (Restraunt restaurant : restaurants) {
                if (restaurant.getAddress().equals(location)) {
                    result.add(restaurant);
                }
            }
            return result;
        }
    }
}
