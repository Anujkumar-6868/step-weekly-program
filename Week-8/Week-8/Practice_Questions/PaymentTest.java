// PaymentGateway.java
public interface PaymentGateway {
    void pay(double amount);
    void refund(double amount);
}

// CreditCardPayment.java
public class CreditCardPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Credit Card");
    }
    @Override
    public void refund(double amount) {
        System.out.println("Refund " + amount + " to Credit Card");
    }
}

// UPIPayment.java
public class UPIPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via UPI");
    }
    @Override
    public void refund(double amount) {
        System.out.println("Refund " + amount + " to UPI");
    }
}

// PaymentTest.java
public class PaymentTest {
    public static void main(String[] args) {
        PaymentGateway pg1 = new CreditCardPayment();
        pg1.pay(3000);
        pg1.refund(1000);

        PaymentGateway pg2 = new UPIPayment();
        pg2.pay(1500);
        pg2.refund(500);
    }
}
