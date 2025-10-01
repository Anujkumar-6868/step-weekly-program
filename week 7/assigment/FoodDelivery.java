// File: FoodDelivery.java
class FoodDelivery {

    // Basic delivery
    public void calculateCharge(double distance) {
        double cost = distance * 10; // Rs.10 per km
        System.out.println("Basic Delivery: Distance = " + distance + " km, Cost = Rs." + cost);
    }

    // Premium delivery (distance + priority fee)
    public void calculateCharge(double distance, double priorityFee) {
        double cost = (distance * 10) + priorityFee;
        System.out.println("Premium Delivery: Distance = " + distance + " km, Priority Fee = Rs." + priorityFee + ", Total = Rs." + cost);
    }

    // Group delivery (distance + number of orders discount)
    public void calculateCharge(double distance, int numOrders) {
        double baseCost = distance * 10;
        double discount = numOrders * 2; // Rs.2 discount per order
        double cost = baseCost - discount;
        System.out.println("Group Delivery: Distance = " + distance + " km, Orders = " + numOrders + ", Total = Rs." + cost);
    }

    // Festival special (distance + discount percentage + free delivery over certain amount)
    public void calculateCharge(double distance, double discountPercent, double freeLimit) {
        double cost = distance * 10;
        if (cost > freeLimit) {
            System.out.println("Festival Delivery: Distance = " + distance + " km, Eligible for FREE Delivery!");
        } else {
            cost = cost - (cost * discountPercent / 100);
            System.out.println("Festival Delivery: Distance = " + distance + " km, Discount = " + discountPercent + "%, Total = Rs." + cost);
        }
    }

    public static void main(String[] args) {
        FoodDelivery fd = new FoodDelivery();
        fd.calculateCharge(5);
        fd.calculateCharge(5, 20);
        fd.calculateCharge(10, 3);
        fd.calculateCharge(15, 20, 200);
    }
}
