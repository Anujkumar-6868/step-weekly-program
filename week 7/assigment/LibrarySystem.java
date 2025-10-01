// File: LibrarySystem.java
class LibraryUser {
    void access() {
        System.out.println("General library access granted.");
    }
}

class Student extends LibraryUser {
    void access() {
        System.out.println("Student: Borrow books & access computers.");
    }
}

class Faculty extends LibraryUser {
    void access() {
        System.out.println("Faculty: Reserve books & access research databases.");
    }
}

class Guest extends LibraryUser {
    void access() {
        System.out.println("Guest: Can only browse books.");
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        LibraryUser u1 = new Student();  // upcasting
        LibraryUser u2 = new Faculty();  // upcasting
        LibraryUser u3 = new Guest();    // upcasting

        u1.access();
        u2.access();
        u3.access();
    }
}

