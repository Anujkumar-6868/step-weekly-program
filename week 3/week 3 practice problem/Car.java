public class Car {
    // Instance variables (attributes)
    String brand;
    String model;
    int year;
    String color;
    boolean isRunning;

    // Constructor
    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false; // default engine state
    }

    // Methods
    public void startEngine() {
        isRunning = true;
        System.out.println(brand + " " + model + " engine started.");
    }

    public void stopEngine() {
        isRunning = false;
        System.out.println(brand + " " + model + " engine stopped.");
    }

    public void displayInfo() {
        System.out.println("Car Info: " + brand + " " + model + " (" + year + "), Color: " + color + ", Running: " + isRunning);
    }

    public int getAge() {
        int currentYear = java.time.Year.now().getValue();
        return currentYear - year;
    }

    public static void main(String[] args) {
        // Creating 3 different cars
        Car car1 = new Car("Toyota", "Corolla", 2018, "White");
        Car car2 = new Car("Tesla", "Model 3", 2022, "Black");
        Car car3 = new Car("Ford", "Mustang", 2015, "Red");

        // Demonstrating behavior
        car1.startEngine();
        car1.displayInfo();
        System.out.println("Age: " + car1.getAge() + " years\n");

        car2.displayInfo();
        car2.startEngine();
        car2.stopEngine();

        car3.displayInfo();
        System.out.println("Age: " + car3.getAge() + " years");

        // Real-world analogy in comments:
        // Each Car object is like a real car: they share similar properties (brand, model, etc.)
        // but each has its own independent state (engine running or not).
    }
}
