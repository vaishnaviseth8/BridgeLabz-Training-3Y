package EncapsulationPolymorphismInterfaceAbstractClass;

import java.util.*;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();
}

class Electronics extends Product implements Taxable {
    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.15;
    }

    @Override
    public String getTaxDetails() {
        return "Electronics tax at 15%";
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "Clothing tax at 5%";
    }
}

class Groceries extends Product {
    public Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

class ECommercePlatform {
    public static void printFinalPrices(List<Product> products) {
        for (Product p : products) {
            double tax = 0;
            String taxInfo = "No tax applicable";
            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
                taxInfo = ((Taxable) p).getTaxDetails();
            }
            double discount = p.calculateDiscount();
            double finalPrice = p.getPrice() + tax - discount;
            System.out.println("Product: " + p.getName());
            System.out.println("Price: $" + p.getPrice());
            System.out.println("Tax: $" + tax + " (" + taxInfo + ")");
            System.out.println("Discount: $" + discount);
            System.out.println("Final Price: $" + finalPrice);
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Electronics("E1001", "Smartphone", 800));
        products.add(new Clothing("C1001", "Jeans", 60));
        products.add(new Groceries("G1001", "Rice", 20));
        printFinalPrices(products);
    }
}

