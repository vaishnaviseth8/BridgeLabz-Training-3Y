package EncapsulationPolymorphismInterfaceAbstractClass;

import java.util.*;

interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isAvailable = true;
    private String borrower;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    protected boolean isAvailable() {
        return isAvailable;
    }

    protected void setAvailable(boolean available) {
        isAvailable = available;
    }

    protected String getBorrower() {
        return borrower;
    }

    protected void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public abstract int getLoanDuration();

    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author +
                ", Available: " + (isAvailable ? "Yes" : "No") +
                (borrower != null ? ", Borrower: " + borrower : "");
    }
}

class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21; // 3 weeks
    }

    @Override
    public void reserveItem(String borrowerName) {
        if(isAvailable()) {
            setBorrower(borrowerName);
            setAvailable(false);
            System.out.println("Book reserved by " + borrowerName);
        } else {
            System.out.println("Book not available for reservation");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 1 week
    }

    @Override
    public void reserveItem(String borrowerName) {
        if(isAvailable()) {
            setBorrower(borrowerName);
            setAvailable(false);
            System.out.println("Magazine reserved by " + borrowerName);
        } else {
            System.out.println("Magazine not available for reservation");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 5; // 5 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if(isAvailable()) {
            setBorrower(borrowerName);
            setAvailable(false);
            System.out.println("DVD reserved by " + borrowerName);
        } else {
            System.out.println("DVD not available for reservation");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("B001", "Effective Java", "Joshua Bloch"));
        items.add(new Magazine("M001", "Time Magazine", "Various"));
        items.add(new DVD("D001", "Inception", "Christopher Nolan"));

        for(LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if(item instanceof Reservable) {
                Reservable reservable = (Reservable) item;
                System.out.println("Available: " + reservable.checkAvailability());
                reservable.reserveItem("John Doe");
                System.out.println("Available after reservation: " + reservable.checkAvailability());
            }
            System.out.println("---------------------------");
        }
    }
}

