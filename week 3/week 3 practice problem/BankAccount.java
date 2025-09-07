public class BankAccount {
    // Static variables (shared across all accounts)
    static String bankName;
    static int totalAccounts = 0;
    static double interestRate;

    // Instance variables
    String accountNumber;
    String accountHolder;
    double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++;
    }

    // Static methods
    public static void setBankName(String name) { bankName = name; }
    public static void setInterestRate(double rate) { interestRate = rate; }
    public static int getTotalAccounts() { return totalAccounts; }
    public static void displayBankInfo() {
        System.out.println("Bank: " + bankName + ", Total Accounts: " + totalAccounts + ", Interest Rate: " + interestRate + "%");
    }

    // Instance methods
    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
        else System.out.println("Insufficient funds.");
    }
    public double calculateInterest() { return balance * interestRate / 100; }
    public void displayAccountInfo() {
        System.out.println("Account: " + accountNumber + ", Holder: " + accountHolder + ", Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount.setBankName("Java Bank");
        BankAccount.setInterestRate(5.0);

        BankAccount acc1 = new BankAccount("A001", "Alice", 1000);
        BankAccount acc2 = new BankAccount("A002", "Bob", 2000);

        acc1.deposit(500);
        acc2.withdraw(300);

        acc1.displayAccountInfo();
        acc2.displayAccountInfo();

        BankAccount.displayBankInfo();
    }
}
