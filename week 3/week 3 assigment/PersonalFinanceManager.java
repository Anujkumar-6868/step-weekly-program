// PersonalFinanceManager.java
public class PersonalFinanceManager {
    public static void main(String[] args) {
        // Set bank name (static)
        PersonalAccount.setBankName("SavingsTrust Bank");

        // Create 3 accounts using constructor (initial deposit)
        PersonalAccount acc1 = new PersonalAccount("Anita Sharma", 10000.0);
        PersonalAccount acc2 = new PersonalAccount("Ravi Kumar", 5000.0);
        PersonalAccount acc3 = new PersonalAccount("Sana Roy", 20000.0);

        // Perform transactions on acc1
        acc1.addIncome(2500.0, "Salary - March");
        acc1.addExpense(1200.0, "Rent - March");
        acc1.addExpense(300.0, "Groceries");

        // Perform transactions on acc2
        acc2.addIncome(1500.0, "Freelance Project");
        acc2.addExpense(700.0, "Phone and Internet");
        acc2.addExpense(100.0, "Snacks");

        // Perform transactions on acc3
        acc3.addIncome(5000.0, "Bonus");
        acc3.addExpense(2500.0, "Laptop purchase");
        acc3.addExpense(400.0, "Dining out");

        // Display summaries
        System.out.println("=== Initial Summaries ===");
        acc1.displayAccountSummary();
        System.out.println();
        acc2.displayAccountSummary();
        System.out.println();
        acc3.displayAccountSummary();
        System.out.println();

        // Demonstrate static bankName shared across accounts
        System.out.println("Bank name (shared): " + PersonalAccount.getBankName());
        System.out.println("Total accounts created: " + PersonalAccount.getTotalAccounts());
        System.out.println();

        // Change bank name using static method and show that it's reflected across instances
        PersonalAccount.setBankName("National Financials");
        System.out.println("=== After Changing Bank Name ===");
        acc1.displayAccountSummary();
        System.out.println();
        acc2.displayAccountSummary();
        System.out.println();
        acc3.displayAccountSummary();
        System.out.println();

        // Further transactions and show savings calculation
        acc1.addIncome(1000.0, "Gift");
        acc2.addExpense(200.0, "Stationery");
        acc3.addIncome(2000.0, "Investment Return");

        System.out.println("=== Final Summaries ===");
        acc1.displayAccountSummary();
        System.out.println();
        acc2.displayAccountSummary();
        System.out.println();
        acc3.displayAccountSummary();
    }
}

/**
 * PersonalAccount class - models a simple personal finance account
 */
class PersonalAccount {
    // Private instance variables
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    // Static variables
    private static int totalAccounts = 0;
    private static String bankName = "Default Bank";
    private static int accountCounter = 1000; // used to generate account numbers

    // Constructor that takes account holder name and initial deposit
    public PersonalAccount(String accountHolderName, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = Math.max(0.0, initialDeposit);
        this.totalIncome = (initialDeposit > 0.0) ? initialDeposit : 0.0;
        this.totalExpenses = 0.0;
        totalAccounts++;
    }

    // Method to add income
    public void addIncome(double amount, String description) {
        if (amount <= 0) {
            System.out.println("Income amount must be positive. Skipping.");
            return;
        }
        totalIncome += amount;
        currentBalance += amount;
        // Optionally: log description (not stored in this simple model)
        System.out.printf("Income added for %s: %.2f (%s)%n", accountHolderName, amount, description);
    }

    // Method to add expense
    public void addExpense(double amount, String description) {
        if (amount <= 0) {
            System.out.println("Expense amount must be positive. Skipping.");
            return;
        }
        totalExpenses += amount;
        currentBalance -= amount;
        // Do not allow negative balances in this model (or allow depending on requirements)
        // Here we allow currentBalance to go negative to reflect overdraft; if you want to prevent:
        // if (currentBalance < 0) { currentBalance += amount; totalExpenses -= amount; System.out.println("Insufficient funds"); return; }
        System.out.printf("Expense recorded for %s: %.2f (%s)%n", accountHolderName, amount, description);
    }

    // Calculate savings (simple definition: totalIncome - totalExpenses)
    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }

    // Display account summary
    public void displayAccountSummary() {
        System.out.println("Account Summary:");
        System.out.println("----------------");
        System.out.println("Bank: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Current Balance: %.2f%n", currentBalance);
        System.out.printf("Total Income: %.2f%n", totalIncome);
        System.out.printf("Total Expenses: %.2f%n", totalExpenses);
        System.out.printf("Calculated Savings: %.2f%n", calculateSavings());
    }

    // Static setter for bank name
    public static void setBankName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid bank name. Ignoring.");
            return;
        }
        bankName = name.trim();
        System.out.println("Bank name set to: " + bankName);
    }

    // Static getter for bank name
    public static String getBankName() {
        return bankName;
    }

    // Static getter for total accounts
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    // Static method to generate account number
    public static String generateAccountNumber() {
        accountCounter++;
        // Example format: BT-1001 where BT = bank short code from current bankName (first 2 letters uppercased)
        String shortCode = "BK";
        if (bankName != null && bankName.length() >= 2) {
            shortCode = bankName.substring(0, 2).toUpperCase();
        }
        return String.format("%s-%04d", shortCode, accountCounter);
    }

    // Additional getters (if needed)
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }
}
