public class Problem3Main {
    abstract static class Vehicle {
        public abstract void start();
        public void stop() { System.out.println("Vehicle stopped."); }
    }

    interface Fuel {
        void refuel();
    }

    static class Car extends Vehicle implements Fuel {
        public void start() { System.out.println("Car started."); }
        public void refuel() { System.out.println("Car is being refueled."); }
    }

    public static void main(String[] args) {
        Car c = new Car();
        c.start();
        c.stop();
        c.refuel();
    }
}
