// Assignment2_ShoppingCart.java
import java.util.*;

public class Assignment2_ShoppingCart {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P101", "Laptop", 55000, "Electronics", 10),
            new Product("P102", "Phone", 25000, "Electronics", 15),
            new Product("P103", "Shirt", 1500, "Clothing", 50),
            new Product("P104", "Shoes", 3000, "Clothing", 20),
            new Product("P105", "Book", 500, "Stationery", 100)
        };

        ShoppingCart cart = new ShoppingCart("C001", "Ravi Kumar");

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Browse Products\n2. Add Product\n3. Remove Product\n4. View Cart\n5. Checkout\n6. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    for (Product p : products) p.display();
                    break;
                case 2:
                    System.out.print("Enter product ID: ");
                    String pid = sc.next();
                    Product found = Product.findProductById(products, pid);
                    if (found != null) {
                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();
                        cart.addProduct(found, qty);
                    }
                    break;
                case 3:
                    System.out.print("Enter product ID to remove: ");
                    String rid = sc.next();
                    cart.removeProduct(rid);
                    break;
                case 4:
                    cart.displayCart();
                    break;
                case 5:
                    cart.checkout();
                    break;
            }
        } while (choice != 6);
    }
}

class Product {
    String productId, productName, category;
    double price;
    int stockQuantity;
    static int totalProducts = 0;

    Product(String id, String name, double price, String cat, int qty) {
        this.productId = id; this.productName = name; this.price = price;
        this.category = cat; this.stockQuantity = qty;
        totalProducts++;
    }

    void display() {
        System.out.println(productId + " | " + productName + " | " + price + " | Stock: " + stockQuantity);
    }

    static Product findProductById(Product[] products, String id) {
        for (Product p : products) {
            if (p.productId.equals(id)) return p;
        }
        return null;
    }
}

class ShoppingCart {
    String cartId, customerName;
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Integer> quantities = new ArrayList<>();
    double cartTotal = 0;

    ShoppingCart(String id, String name) {
        this.cartId = id; this.customerName = name;
    }

    void addProduct(Product p, int qty) {
        products.add(p);
        quantities.add(qty);
        cartTotal += p.price * qty;
        System.out.println("Added " + qty + " x " + p.productName);
    }

    void removeProduct(String productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).productId.equals(productId)) {
                cartTotal -= products.get(i).price * quantities.get(i);
                products.remove(i);
                quantities.remove(i);
                System.out.println("Removed product " + productId);
                return;
            }
        }
    }

    void displayCart() {
        System.out.println("\n--- Cart ---");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).productName + " x " + quantities.get(i));
        }
        System.out.println("Total: " + cartTotal);
    }

    void checkout() {
        System.out.println("\n--- Checkout ---");
        displayCart();
        System.out.println("Thank you, " + customerName + "!");
        products.clear();
        quantities.clear();
        cartTotal = 0;
    }
}
