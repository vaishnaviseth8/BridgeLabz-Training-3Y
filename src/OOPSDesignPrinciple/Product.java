package OOPSDesignPrinciple;

import java.util.*;

class Product {
    String name;
    double price;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String toString() {
        return name + " ($" + price + ")";
    }
}

class Order {
    String orderId;
    List<Product> products = new ArrayList<>();
    public Order(String orderId) {
        this.orderId = orderId;
    }
    public void addProduct(Product p) {
        products.add(p);
    }
    public void showOrder() {
        System.out.println("Order ID: " + orderId);
        for (Product p : products) {
            System.out.println(" - " + p);
        }
    }
}

class Customer {
    String name;
    List<Order> orders = new ArrayList<>();
    public Customer(String name) {
        this.name = name;
    }
    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed order " + order.orderId);
    }
    public void showOrders() {
        System.out.println("Customer: " + name);
        for (Order o : orders) {
            o.showOrder();
        }
    }
}

class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 999.99);
        Product p2 = new Product("Phone", 599.99);
        Product p3 = new Product("Headphones", 199.99);
        Customer cust1 = new Customer("Alice");
        Customer cust2 = new Customer("Bob");
        Order order1 = new Order("ORD001");
        order1.addProduct(p1);
        order1.addProduct(p3);
        Order order2 = new Order("ORD002");
        order2.addProduct(p2);
        Order order3 = new Order("ORD003");
        order3.addProduct(p3);
        cust1.placeOrder(order1);
        cust1.placeOrder(order2);
        cust2.placeOrder(order3);
        cust1.showOrders();
        cust2.showOrders();
    }
}

