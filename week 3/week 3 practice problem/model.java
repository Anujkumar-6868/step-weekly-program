class model {
    protected String make, model;
    protected int year;
    protected double fuelLevel;

    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make; this.model = model; this.year = year; this.fuelLevel = fuelLevel;
    }

    public void startVehicle() { System.out.println(make + " " + model + " started."); }
    public void stopVehicle() { System.out.println(make + " " + model + " stopped."); }
    public void refuel(double amount) { fuelLevel += amount; }
    public void displayVehicleInfo() {
        System.out.println(make + " " + model + " (" + year + "), Fuel: " + fuelLevel);
    }

    public static void main(String[] args) {
        Vehicle v1 = new Car("Toyota", "Camry", 2020, 50);
        Vehicle v2 = new Truck("Volvo", "FH16", 2019, 100);
        Vehicle v3 = new Motorcycle("Honda", "CBR", 2021, 20);

        Vehicle[] vehicles = {v1, v2, v3};
        for (Vehicle v : vehicles) {
            v.startVehicle();
            v.displayVehicleInfo();
        }

        // Reusability: Base Vehicle class reused by Car/Truck/Motorcycle.
        // Extensibility: New vehicle types can extend Vehicle.
    }
}

// Child classes
class Car extends Vehicle { public Car(String m, String mo, int y, double f) { super(m, mo, y, f); } }
class Truck extends Vehicle { public Truck(String m, String mo, int y, double f) { super(m, mo, y, f); } }
class Motorcycle extends Vehicle { public Motorcycle(String m, String mo, int y, double f) { super(m, mo, y, f); } }
