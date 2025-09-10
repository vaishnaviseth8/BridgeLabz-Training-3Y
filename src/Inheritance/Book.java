package Inheritance;

public class Book {
    static String libraryName = "City Central Library";

    private String title;
    private String author;
    private final String isbn;

    public Book(String title, String author, String isbn) {
        this.title = this.title = title;
        this.author = this.author = author;
        this.isbn = isbn;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book("Wings of Fire", "A.P.J. Abdul Kalam", "9788173711466");
        Book b2 = new Book("The Alchemist", "Paulo Coelho", "9780061122415");

        displayLibraryName();

        b1.displayBookDetails();
        b2.displayBookDetails();
    }
}

