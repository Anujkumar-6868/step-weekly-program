class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private static int totalAccounts = 0;
    private static int counter = 1;

    // Constructor
    public BankAccount(String accountHolderName, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    // Static method to generate unique account numbers
    private static String generateAccountNumber() {
        return "ACC" + String.format("%03d", counter++);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + " to " + accountNumber);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrew: " + amount + " from " + accountNumber);
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Balance of " + accountNumber + ": " + balance);
    }

    // Display account info
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber +
                ", Holder: " + accountHolderName +
                ", Balance: " + balance);
    }

    // Static method
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    // Main method
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[3];

        accounts[0] = new BankAccount("Alice", 1000);
        accounts[1] = new BankAccount("Bob", 2000);
        accounts[2] = new BankAccount("Charlie", 1500);

        accounts[0].deposit(500);
        accounts[1].withdraw(300);
        accounts[2].checkBalance();

        for (BankAccount acc : accounts) {
            acc.displayAccountInfo();
        }

        System.out.println("Total accounts created: " + BankAccount.getTotalAccounts());
    }
}
