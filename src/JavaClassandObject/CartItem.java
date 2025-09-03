package JavaClassandObject;

import java.util.ArrayList;

class CartItem {
    String itemName;
    double price;
    int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}

class ShoppingCart {
    ArrayList<CartItem> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(CartItem item) {
        // If item already exists, update quantity
        for (CartItem ci : items) {
            if (ci.itemName.equalsIgnoreCase(item.itemName)) {
                ci.quantity += item.quantity;
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(String itemName) {
        items.removeIf(ci -> ci.itemName.equalsIgnoreCase(itemName));
    }

    public double getTotalCost() {
        double total = 0;
        for (CartItem ci : items) {
            total += ci.getTotalPrice();
        }
        return total;
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Shopping cart is empty.");
            return;
        }
        System.out.println("Shopping Cart Items:");
        for (CartItem ci : items) {
            System.out.printf("%s - $%.2f x %d = $%.2f\n", ci.itemName, ci.price, ci.quantity, ci.getTotalPrice());
        }
        System.out.printf("Total Cost: $%.2f\n", getTotalCost());
    }
}

public class ShoppingCartSimulation {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(new CartItem("Apple", 0.99, 3));
        cart.addItem(new CartItem("Bread", 2.50, 1));
        cart.addItem(new CartItem("Milk", 1.99, 2));
        cart.displayCart();

        System.out.println("\nRemoving 'Bread' from cart...\n");
        cart.removeItem("Bread");
        cart.displayCart();
    }
}

