package OOPSDesignPrinciple;

import java.util.*;

class Item {
    private String name;
    private double quantity;
    private double pricePerUnit;

    public Item(String name, double quantity, double pricePerUnit) {
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public double getTotalPrice() {
        return quantity * pricePerUnit;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }
}

class Shopper {
    private String name;
    private List<Item> items;

    public Shopper(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void buyItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public void checkout(ReceiptPrinter printer) {
        printer.printReceipt(this);
    }
}

class ReceiptPrinter {
    public void printReceipt(Shopper shopper) {
        System.out.println("\n--- Receipt ---");
        System.out.println("Shopper: " + shopper.getName());
        double total = 0;

        for (Item item : shopper.getItems()) {
            double cost = item.getTotalPrice();
            System.out.println("- " + item.getName() + " (" + item.getQuantity() + " @ $" + item.getPricePerUnit() + "/unit): $" + cost);
            total += cost;
        }

        System.out.println("Total: $" + total);
    }
}

public class GroceryStoreApp {
    public static void main(String[] args) {
        Shopper shopper = new Shopper("Alice");
        shopper.buyItem(new Item("Apples", 2.0, 3.0));  // 2 kg @ $3/kg
        shopper.buyItem(new Item("Milk", 1.0, 2.0));    // 1 liter @ $2/liter

        ReceiptPrinter printer = new ReceiptPrinter();
        shopper.checkout(printer);
    }
}

