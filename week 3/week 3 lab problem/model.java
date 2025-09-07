class model {
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;
    private static int totalVehicles = 0;
    private static double totalRevenue = 0;
    private static String companyName;
    private static int rentalDays = 0;
    private static int counter = 1;

    public Vehicle(String brand, String model, double rentPerDay) {
        this.vehicleId = generateVehicleId();
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        totalVehicles++;
    }

    private static String generateVehicleId() {
        return "V" + String.format("%03d", counter++);
    }

    public double calculateRent(int days) {
        double rent = rentPerDay * days;
        totalRevenue += rent;
        rentalDays += days;
        return rent;
    }

    public void rentVehicle(int days) {
        if (isAvailable) {
            isAvailable = false;
            double rent = calculateRent(days);
            System.out.println(vehicleId + " rented for " + days + " days. Rent: " + rent);
        } else {
            System.out.println(vehicleId + " is not available.");
        }
    }

    public void returnVehicle() {
        isAvailable = true;
        System.out.println(vehicleId + " returned successfully.");
    }

    public void displayVehicleInfo() {
        System.out.println(vehicleId + " - " + brand + " " + model + 
                " | Rent/Day: " + rentPerDay + 
                " | Available: " + isAvailable);
    }

    // Static methods
    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static double getAverageRentPerDay() {
        return rentalDays == 0 ? 0 : totalRevenue / rentalDays;
    }

    public static void displayCompanyStats() {
        System.out.println("Company: " + companyName + 
                " | Total Vehicles: " + totalVehicles + 
                " | Revenue: " + totalRevenue + 
                " | Avg Rent/Day: " + getAverageRentPerDay());
    }

    public static void main(String[] args) {
        Vehicle.setCompanyName("Speedy Rentals");

        Vehicle v1 = new Vehicle("Toyota", "Camry", 2000);
        Vehicle v2 = new Vehicle("Honda", "Civic", 1500);

        v1.displayVehicleInfo();
        v2.displayVehicleInfo();

        v1.rentVehicle(5);
        v2.rentVehicle(3);
        v1.returnVehicle();

        Vehicle.displayCompanyStats();
    }
}
