package EncapsulationPolymorphismInterfaceAbstractClass;

import java.util.*;

interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity;
    }

    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem implements Discountable {
    private double discountPercentage = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        total -= total * discountPercentage / 100;
        return total;
    }

    @Override
    public void applyDiscount(double percentage) {
        if (percentage >= 0 && percentage <= 100) {
            discountPercentage = percentage;
        }
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Item Discount: " + discountPercentage + "%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double discountPercentage = 0;
    private double additionalCharge = 5.0; // fixed charge for non-veg items

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double baseTotal = getPrice() * getQuantity();
        baseTotal += additionalCharge * getQuantity();
        baseTotal -= baseTotal * discountPercentage / 100;
        return baseTotal;
    }

    @Override
    public void applyDiscount(double percentage) {
        if (percentage >= 0 && percentage <= 100) {
            discountPercentage = percentage;
        }
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount: " + discountPercentage + "%";
    }
}

class OnlineFoodDeliverySystem {
    public static void processOrder(List<FoodItem> order) {
        double totalAmount = 0;
        for (FoodItem item : order) {
            System.out.println(item.getItemDetails());
            if (item instanceof Discountable) {
                Discountable discountable = (Discountable) item;
                discountable.applyDiscount(10); // example discount
                System.out.println(discountable.getDiscountDetails());
            }
            double price = item.calculateTotalPrice();
            System.out.println("Total Price: $" + price);
            totalAmount += price;
            System.out.println("------------------");
        }
        System.out.println("Order Total: $" + totalAmount);
    }

    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Paneer Tikka", 8.0, 2));
        order.add(new NonVegItem("Chicken Biryani", 12.0, 1));
        processOrder(order);
    }
}

