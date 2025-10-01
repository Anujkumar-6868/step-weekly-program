public class Drain {
    abstract static class Vehicle {
        protected int speed;
        protected String fuelType;
        public Vehicle(int speed, String fuelType) {
            this.speed = speed;
            this.fuelType = fuelType;
        }
        public abstract void startEngine();
    }
    interface Maintainable {
        void serviceInfo();
    }
    static class Car extends Vehicle implements Maintainable {
        public Car(int speed, String fuelType) {
            super(speed, fuelType);
        }
        public void startEngine() {
            System.out.println("Car engine started. Speed: " + speed + "km/h. Fuel: " + fuelType);
        }
        public void serviceInfo() {
            System.out.println("Service required every 10,000 km or 1 year.");
        }
    }
    public static void main(String[] args) {
        Car car = new Car(120, "Petrol");
        car.startEngine();
        car.serviceInfo();
    }
}
