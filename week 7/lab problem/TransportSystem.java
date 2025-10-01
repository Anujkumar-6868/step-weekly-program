// File: TransportSystem.java
class Vehicle {
    public void dispatch() { System.out.println("Generic transport."); }
}
class Bus extends Vehicle {
    public void dispatch() { System.out.println("Bus dispatched -> Fixed route, capacity tracked."); }
}
class Taxi extends Vehicle {
    public void dispatch() { System.out.println("Taxi dispatched -> Door-to-door, fare by distance."); }
}
class Train extends Vehicle {
    public void dispatch() { System.out.println("Train dispatched -> Runs on schedule, multiple cars."); }
}
class Bike extends Vehicle {
    public void dispatch() { System.out.println("Bike dispatched -> Eco-friendly short trips."); }
}

public class TransportSystem {
    public static void main(String[] args) {
        Vehicle v;
        v = new Bus(); v.dispatch();
        v = new Taxi(); v.dispatch();
        v = new Train(); v.dispatch();
        v = new Bike(); v.dispatch();
    }
}

