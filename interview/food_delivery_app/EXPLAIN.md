# Food Delivery App — Simplified Code Overview

This file contains simplified versions of the source files in the `food_delivery_app` folder. Imports, getters, and setters are removed — only fields and core methods/constructors remain to explain each part.

---

## FoodDelivery.java
```java
public class FoodDelivery {
    public static void main(String[] args) {
        // application entry
    }
}
```

## services/RestaurantService.java
```java
public class RestaurantService {
    private RestaurantRepository restaurantRepository;

    private RestaurantService() {
        restaurantRepository = new RestaurantRepository();
    }

    public void registerRestaurant(Restaurant restaurant) { /* delegates to repository */ }

    public List<Restaurant> browseRestaurants() { /* returns list from repository */ }
}
```

## services/OrderService.java
```java
public class OrderService {
    private OrderContext orderContext;

    public void placeOrder() {
        this.orderContext = new OrderContext();
    }

    public void updateOrderStatus(String status) {
        if (status.equalsIgnoreCase("cancelled")) {
            orderContext.cancel(orderContext);
        } else {
            orderContext.next(orderContext);
        }
    }
}
```

## services/statePattern/OrderContext.java
```java
public class OrderContext {
    public OrderState orderState;

    public OrderContext() { this.orderState = new CreatedState(this); }

    public void cancel(OrderContext orderContext) { orderState.cancel(this); }
    public void next(OrderContext orderContext) { orderState.next(this); }
    public void getCurrentState() { orderState.getCurrentState(); }
}

interface OrderState {
    void cancel(OrderContext orderContext);
    void next(OrderContext orderContext);
    void getCurrentState();
}

class CreatedState implements OrderState {
    private OrderContext orderContext;
    public CreatedState(OrderContext orderContext) { this.orderContext = orderContext; }
    public void cancel(OrderContext orderContext) { /* transition to cancelled */ }
    public void next(OrderContext orderContext) { /* transition to accepted */ }
    public void getCurrentState() { /* print/create state */ }
}
```

## repository/RestaurantRepository.java
```java
public class RestaurantRepository {
    List<Restaurant> restaurants;

    public void addRestaurant(Restaurant restaurant) { /* add to list */ }
    public List<Restaurant> getRestaurants() { /* return list */ }
}
```

## model/Restaurant.java
```java
public class Restaurant {
    private String id;
    private String name;
    private List<MenuItem> menuItems;

    public Restaurant() {}
    public Restaurant(String id, String name, List<MenuItem> menuItems) { /* ... */ }
}
```

## model/MenuItem.java
```java
public class MenuItem {
    private String id;
    private String name;
    private double price;

    public MenuItem() {}
    public MenuItem(String id, String name) { /* ... */ }
}
```

## model/CartItem.java
```java
public class CartItem {
    private MenuItem menuItem;
    private int quantity;

    public CartItem() {}
    public CartItem(MenuItem menuItem, int quantity) { /* ... */ }
}
```

## model/Cart.java
```java
public class Cart {
    private List<CartItem> items;

    public Cart() {}
    public Cart(List<CartItem> items) { /* ... */ }
    public void addItem(CartItem item) { /* add item */ }
}
```

## model/User.java
```java
public class User {
    private String id;
    private String name;
    private String phone;

    public User() {}
    public User(String id, String name, String phone) { /* ... */ }
}
```

## model/Customer.java
```java
public class Customer extends User {
    private Cart cart;

    public Customer() { super(); }
    public Customer(String id, String name, String phone, Cart cart) { /* ... */ }
}
```

## model/OrderItem.java
```java
public class OrderItem {
    private MenuItem menuItem;
    private int quantity;

    public OrderItem() {}
    public OrderItem(MenuItem menuItem, int quantity) { /* ... */ }
}
```

## model/Order.java
```java
public class Order {
    private String id;
    private List<OrderItem> items;
    private Restaurant restaurant;
    private Customer customer;
    private OrderStatus status;

    public Order() {}
    public Order(String id, List<OrderItem> items, Restaurant restaurant, Customer customer, OrderStatus status) { /* ... */ }
}
```

## model/OrderStatus.java
```java
public enum OrderStatus {
    CREATED,
    ACCEPTED,
    PREPARING,
    OUT_FOR_DELIVERY,
    DELIVERED,
    CANCELLED
}
```

---
