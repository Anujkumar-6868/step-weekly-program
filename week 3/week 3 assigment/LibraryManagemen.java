// Assignment5_LibraryManagement.java
class Book {
    String bookId, title, author, isbn, category;
    boolean isIssued;

    Book(String id, String t, String a, String i, String c) {
        bookId = id; title = t; author = a; isbn = i; category = c;
        isIssued = false;
    }
}

class Member {
    String memberId, memberName, memberType;
    Book[] issuedBooks;
    int count;

    static int totalMembers = 0;
    static String libraryName = "Central Library";

    Member(String id, String name, String type) {
        memberId = id; memberName = name; memberType = type;
        issuedBooks = new Book[5]; count = 0;
        totalMembers++;
    }

    void issueBook(Book b) {
        if (!b.isIssued && count < issuedBooks.length) {
            issuedBooks[count++] = b;
            b.isIssued = true;
            System.out.println(memberName + " issued " + b.title);
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Book b1 = new Book("B1", "Java", "James", "123", "Tech");
        Book b2 = new Book("B2", "C++", "Stroustrup", "456", "Tech");

        Member m1 = new Member("M1", "Ravi", "Student");
        m1.issueBook(b1);
        m1.issueBook(b2);
    }
}
