// File: HotelBooking.java
class HotelBooking {
    
    // Standard booking
    public void calculatePrice(String roomType, int nights) {
        double price = nights * basePrice(roomType);
        System.out.println("Standard Booking -> Room: " + roomType + 
                           ", Nights: " + nights + ", Price: " + price);
    }

    // Seasonal booking
    public void calculatePrice(String roomType, int nights, double seasonalMultiplier) {
        double price = nights * basePrice(roomType) * seasonalMultiplier;
        System.out.println("Seasonal Booking -> Room: " + roomType + 
                           ", Nights: " + nights + ", Price: " + price);
    }

    // Corporate booking
    public void calculatePrice(String roomType, int nights, double corporateDiscount, boolean mealPackage) {
        double price = nights * basePrice(roomType);
        price -= (price * corporateDiscount);
        if(mealPackage) price += 500; // fixed meal package
        System.out.println("Corporate Booking -> Room: " + roomType + 
                           ", Nights: " + nights + ", Price: " + price);
    }

    // Wedding booking
    public void calculatePrice(String roomType, int nights, int guestCount, double decorationFee, double cateringCost) {
        double price = nights * basePrice(roomType) + decorationFee + (guestCount * cateringCost);
        System.out.println("Wedding Package -> Room: " + roomType + 
                           ", Nights: " + nights + ", Guests: " + guestCount + ", Price: " + price);
    }

    private double basePrice(String roomType) {
        switch(roomType.toLowerCase()) {
            case "deluxe": return 3000;
            case "suite": return 5000;
            default: return 2000;
        }
    }

    public static void main(String[] args) {
        HotelBooking booking = new HotelBooking();
        booking.calculatePrice("Deluxe", 3);
        booking.calculatePrice("Suite", 2, 1.2);
        booking.calculatePrice("Deluxe", 5, 0.1, true);
        booking.calculatePrice("Suite", 2, 100, 2000, 500);
    }
}
