package OOPSDesignPrinciple;

import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}

class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        System.out.println("Books in " + name + ":");
        for (Book book : books) {
            System.out.println(" - " + book);
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald");

        Library centralLibrary = new Library("Central Library");
        Library communityLibrary = new Library("Community Library");

        centralLibrary.addBook(book1);
        centralLibrary.addBook(book2);

        communityLibrary.addBook(book2);
        communityLibrary.addBook(book3);

        centralLibrary.showBooks();
        System.out.println();
        communityLibrary.showBooks();
    }
}

