package JavaClassandObject;

public class Item {
    String itemCode;
    String itemName;
    double price;

    public Item(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Item Details:");
        System.out.println("Code  : " + itemCode);
        System.out.println("Name  : " + itemName);
        System.out.printf("Price : $%.2f\n", price);
    }

    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        Item item1 = new Item("I001", "Notebook", 2.50);
        item1.displayDetails();
        int quantity = 10;
        double total = item1.calculateTotalCost(quantity);
        System.out.printf("Total cost for %d items: $%.2f\n", quantity, total);
    }
}

