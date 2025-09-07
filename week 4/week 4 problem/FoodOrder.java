class FoodOrder {
    String customerName;
    String foodItem;
    int quantity;
    double price;

    static final double RATE = 150.0; // fixed price per item

    // 1. Default constructor
    FoodOrder() {
        this.customerName = "Unknown";
        this.foodItem = "Unknown";
        this.quantity = 0;
        this.price = 0.0;
    }

    // 2. Constructor with food item
    FoodOrder(String foodItem) {
        this.customerName = "Guest";
        this.foodItem = foodItem;
        this.quantity = 1;
        this.price = RATE;
    }

    // 3. Constructor with food item and quantity
    FoodOrder(String foodItem, int quantity) {
        this.customerName = "Guest";
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = quantity * RATE;
    }

    void printBill() {
        System.out.println("🍔 Order -> Customer: " + customerName + ", Food: " + foodItem +
                ", Qty: " + quantity + ", Total: " + price);
    }

    public static void main(String[] args) {
        FoodOrder o1 = new FoodOrder();
        FoodOrder o2 = new FoodOrder("Burger");
        FoodOrder o3 = new FoodOrder("Pizza", 3);

        o1.printBill();
        o2.printBill();
        o3.printBill();
    }
}
