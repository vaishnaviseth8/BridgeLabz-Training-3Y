package ScenarioBasedQues;

import java.util.ArrayList;
import java.util.List;

public class BookBazaarApp {
    public static void main(String[] args) {
        User user = new User("Emily Clark", "emily@example.com");

        EBook ebook1 = new EBook("Clean Code", "Robert C. Martin", 30.0, 50, 10);
        PrintedBook printedBook1 = new PrintedBook("Design Patterns", "Erich Gamma", 45.0, 20, 5);

        Order order = new Order(user);
        order.addBook(ebook1, 2);
        order.addBook(printedBook1, 1);

        order.placeOrder();

        System.out.printf("Total Order Cost: $%.2f\n", order.calculateTotal());
    }
}

interface IDiscountable {
    double applyDiscount(double price, int quantity);
}

class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters only (no setters for immutability)
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

abstract class Book implements IDiscountable {
    protected String title;
    protected String author;
    protected double price;
    private int stock;

    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public int getStock() {
        return stock;
    }

    public void updateStock(int quantity) {
        if (quantity > 0 && stock >= quantity) {
            stock -= quantity;
        }
    }

    public double getPrice() {
        return price;
    }

    @Override
    public abstract double applyDiscount(double price, int quantity);
}

class EBook extends Book {
    private int digitalDiscount; // percentage discount for ebooks

    public EBook(String title, String author, double price, int stock, int digitalDiscount) {
        super(title, author, price, stock);
        this.digitalDiscount = digitalDiscount;
    }

    @Override
    public double applyDiscount(double price, int quantity) {
        double discountAmount = price * quantity * digitalDiscount / 100.0;
        return price * quantity - discountAmount;
    }
}

class PrintedBook extends Book {
    private int seasonalDiscount; // percentage discount for printed books

    public PrintedBook(String title, String author, double price, int stock, int seasonalDiscount) {
        super(title, author, price, stock);
        this.seasonalDiscount = seasonalDiscount;
    }

    @Override
    public double applyDiscount(double price, int quantity) {
        double discountAmount = price * quantity * seasonalDiscount / 100.0;
        return price * quantity - discountAmount;
    }
}

class Order {
    private User user;
    private List<OrderItem> items;
    private String status;

    public Order(User user) {
        this.user = user;
        this.items = new ArrayList<>();
        this.status = "Created";
    }

    public void addBook(Book book, int quantity) {
        if (book.getStock() >= quantity) {
            items.add(new OrderItem(book, quantity));
        } else {
            System.out.println("Not enough stock for " + book.getTitle());
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            Book book = item.getBook();
            int qty = item.getQuantity();
            total += book.applyDiscount(book.getPrice(), qty);
        }
        return total;
    }

    public void placeOrder() {
        if (items.isEmpty()) {
            System.out.println("Order has no items.");
            return;
        }
        for (OrderItem item : items) {
            item.getBook().updateStock(item.getQuantity());
        }
        status = "Placed";
        System.out.println("Order placed successfully for user: " + user.getName());
    }

    public String getStatus() {
        return status;
    }
}

class OrderItem {
    private Book book;
    private int quantity;

    public OrderItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }
}

