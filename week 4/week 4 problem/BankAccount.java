import java.util.Random;

class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    // 1. Default constructor
    BankAccount() {
        this.accountHolder = "Unknown";
        this.accountNumber = 0;
        this.balance = 0.0;
    }

    // 2. Constructor with name
    BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.accountNumber = new Random().nextInt(90000) + 10000; // 5-digit number
        this.balance = 0.0;
    }

    // 3. Constructor with name and initial balance
    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = new Random().nextInt(90000) + 10000;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println(accountHolder + " deposited " + amount + ". New Balance: " + balance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("❌ Insufficient funds for " + accountHolder);
        }
    }

    void displayAccount() {
        System.out.println("Account Holder: " + accountHolder + ", Acc No: " + accountNumber + ", Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount();
        BankAccount a2 = new BankAccount("Alice");
        BankAccount a3 = new BankAccount("Bob", 5000);

        a1.displayAccount();
        a2.displayAccount();
        a3.displayAccount();

        a2.deposit(2000);
        a3.withdraw(1500);
    }
}
