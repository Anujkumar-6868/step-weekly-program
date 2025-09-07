class Book {
    String title;
    String author;
    String isbn;
    boolean isAvailable;

    // 1. Default constructor
    Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.isbn = "0000";
        this.isAvailable = true;
    }

    // 2. Constructor with title and author
    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isbn = "0000";
        this.isAvailable = true;
    }

    // 3. Full constructor
    Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " borrowed successfully.");
        } else {
            System.out.println(title + " is already borrowed!");
        }
    }

    void returnBook() {
        isAvailable = true;
        System.out.println(title + " returned successfully.");
    }

    void displayBookInfo() {
        System.out.println("📖 Book -> Title: " + title + ", Author: " + author +
                ", ISBN: " + isbn + ", Available: " + isAvailable);
    }

    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("Java Programming", "Herbert Schildt", "12345", true);

        b1.displayBookInfo();
        b2.displayBookInfo();
        b3.displayBookInfo();

        b2.borrowBook();
        b2.displayBookInfo();
        b2.returnBook();
        b2.displayBookInfo();
    }
}
