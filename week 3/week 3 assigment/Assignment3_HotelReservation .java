// Assignment3_HotelReservation.java
class Room {
    String roomNumber, roomType;
    double pricePerNight;
    boolean isAvailable;
    int maxOccupancy;

    Room(String num, String type, double price, int occ) {
        roomNumber = num; roomType = type; pricePerNight = price;
        maxOccupancy = occ; isAvailable = true;
    }
}

class Guest {
    String guestId, guestName, phoneNumber, email;

    Guest(String id, String name, String phone, String email) {
        this.guestId = id; this.guestName = name;
        this.phoneNumber = phone; this.email = email;
    }
}

class Booking {
    String bookingId;
    Guest guest;
    Room room;
    String checkIn, checkOut;
    double totalAmount;

    static int totalBookings = 0;
    static double hotelRevenue = 0;
    static String hotelName = "DreamStay Hotel";

    Booking(String id, Guest g, Room r, String in, String out) {
        bookingId = id; guest = g; room = r;
        checkIn = in; checkOut = out;
        totalAmount = r.pricePerNight * 2; // assume 2 nights
        r.isAvailable = false;
        totalBookings++; hotelRevenue += totalAmount;
    }

    void cancelReservation() {
        room.isAvailable = true;
        System.out.println("Booking " + bookingId + " cancelled.");
    }

    void display() {
        System.out.println("Booking: " + bookingId + " | Guest: " + guest.guestName + " | Room: " + room.roomNumber);
    }
}

public class Assignment3_HotelReservation {
    public static void main(String[] args) {
        Room r1 = new Room("101", "Deluxe", 3000, 2);
        Room r2 = new Room("102", "Suite", 5000, 4);

        Guest g1 = new Guest("G1", "Anita", "9999999999", "anita@mail.com");

        Booking b1 = new Booking("B1", g1, r1, "01-09-25", "03-09-25");
        b1.display();

        System.out.println("Hotel Revenue: " + Booking.hotelRevenue);
    }
}
