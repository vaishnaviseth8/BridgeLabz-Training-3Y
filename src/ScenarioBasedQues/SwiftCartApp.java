package ScenarioBasedQues;

import java.util.ArrayList;
import java.util.List;

public class SwiftCartApp {
    public static void main(String[] args) {
        PerishableProduct milk = new PerishableProduct("Milk", 2.0, "Dairy", 5);
        NonPerishableProduct soap = new NonPerishableProduct("Soap", 1.5, "Cleaning");

        List<Product> initialProducts = new ArrayList<>();
        initialProducts.add(milk);
        initialProducts.add(soap);

        Cart cart = new Cart(initialProducts);
        cart.addProduct(new PerishableProduct("Eggs", 3.0, "Poultry", 12));
        cart.addProduct(new NonPerishableProduct("Rice", 10.0, "Grains"));

        cart.printCartDetails();

        double bill = cart.generateBill();
        System.out.println("Total bill after discount: $" + bill);
    }
}

interface ICheckout {
    double generateBill();
    double applyDiscount();
}

abstract class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    protected void setPrice(double price) { this.price = price; }

    public abstract double applyDiscount();
}

class PerishableProduct extends Product {
    private int shelfLifeDays;

    public PerishableProduct(String name, double price, String category, int shelfLifeDays) {
        super(name, price, category);
        this.shelfLifeDays = shelfLifeDays;
    }

    @Override
    public double applyDiscount() {
        // Perishable products have 10% discount if shelf life <= 5 days
        if (shelfLifeDays <= 5) {
            double discountedPrice = getPrice() * 0.9;
            setPrice(discountedPrice);
            return discountedPrice;
        }
        return getPrice();
    }
}

class NonPerishableProduct extends Product {
    public NonPerishableProduct(String name, double price, String category) {
        super(name, price, category);
    }

    @Override
    public double applyDiscount() {
        // Flat 5% discount on non-perishable products
        double discountedPrice = getPrice() * 0.95;
        setPrice(discountedPrice);
        return discountedPrice;
    }
}

class Cart implements ICheckout {
    private List<Product> products;
    private double totalPrice;

    public Cart() {
        this.products = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public Cart(List<Product> initialProducts) {
        this.products = new ArrayList<>(initialProducts);
        this.totalPrice = 0.0;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    private void updateTotalPrice() {
        totalPrice = 0.0;
        for (Product p : products) {
            totalPrice += p.getPrice();
        }
    }

    @Override
    public double generateBill() {
        updateTotalPrice();
        double discount = applyDiscount();
        return totalPrice - discount;
    }

    @Override
    public double applyDiscount() {
        double discountTotal = 0.0;
        for (Product p : products) {
            double originalPrice = p.getPrice() / (1 - getDiscountRate(p)); // reverse calculation
            double discountedPrice = p.applyDiscount();
            discountTotal += (originalPrice - discountedPrice);
        }
        updateTotalPrice();
        return discountTotal;
    }

    private double getDiscountRate(Product p) {
        if (p instanceof PerishableProduct) {
            PerishableProduct pp = (PerishableProduct) p;
            if (pp.shelfLifeDays <= 5) {
                return 0.10;
            }
            return 0.0;
        } else if (p instanceof NonPerishableProduct) {
            return 0.05;
        }
        return 0.0;
    }

    public void printCartDetails() {
        System.out.println("Cart Contents:");
        for (Product p : products) {
            System.out.println("- " + p.getName() + ": $" + String.format("%.2f", p.getPrice()) + " (" + p.getCategory() + ")");
        }
        updateTotalPrice();
        System.out.println("Total Price (before discount): $" + String.format("%.2f", totalPrice));
    }
}

