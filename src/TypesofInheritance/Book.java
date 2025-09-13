package TypesofInheritance;

class Book {
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Title           : " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name     : " + name);
        System.out.println("Biography       : " + bio);
        System.out.println("-------------------------------");
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Author a1 = new Author("The Time Machine", 1895, "H. G. Wells", "English writer known for science fiction novels.");
        Author a2 = new Author("Pride and Prejudice", 1813, "Jane Austen", "English novelist known for romantic fiction.");

        a1.displayInfo();
        a2.displayInfo();
    }
}

