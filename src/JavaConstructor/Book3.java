package JavaConstructor;

class Book3 {
    public String ISBN;
    protected String title;
    private String author;

    public Book3(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class EBook extends Book3 {
    private double fileSizeMB;

    public EBook(String ISBN, String title, String author, double fileSizeMB) {
        super(ISBN, title, author);
        this.fileSizeMB = fileSizeMB;
    }

    public void displayDetails() {
        System.out.println("ISBN     : " + ISBN);     // public - accessible
        System.out.println("Title    : " + title);     // protected - accessible in subclass
        System.out.println("Author   : " + getAuthor()); // private - accessed via public method
        System.out.println("File Size: " + fileSizeMB + " MB");
    }
}

