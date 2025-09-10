package Inheritance;

public class Product {
    static double discount = 10.0;

    private String productName;
    private double price;
    private int quantity;
    private final String productID;

    public Product(String productName, double price, int quantity, String productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
        }
    }

    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 85000.00, 1, "P001");
        Product p2 = new Product("Headphones", 2500.00, 2, "P002");

        p1.displayProductDetails();
        p2.displayProductDetails();

        Product.updateDiscount(15.0);

        System.out.println("\nAfter updating discount:\n");

        p1.displayProductDetails();
        p2.displayProductDetails();
    }
}

