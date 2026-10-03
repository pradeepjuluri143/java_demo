package inheritance;

/**
 * Superclass (Parent / Base Class) representing a generic Indian Bank Account.
 * Demonstrates how shared attributes and behaviors are defined once.
 */
class BankAccount {
    // Shared state (inherited by all child accounts)
    protected String accountNumber;
    protected String accountHolderName;
    protected double balanceINR;

    // Constructor of Parent class
    public BankAccount(String accountNumber, String accountHolderName, double balanceINR) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balanceINR = balanceINR;
    }

    // Common deposit method reused by all child classes without duplication
    public void deposit(double amountINR) {
        if (amountINR > 0) {
            balanceINR += amountINR;
            System.out.println("₹" + amountINR + " deposited to Account [" + accountNumber + 
                               "]. New Balance: ₹" + balanceINR);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Common withdraw method
    public void withdraw(double amountINR) {
        if (amountINR > 0 && amountINR <= balanceINR) {
            balanceINR -= amountINR;
            System.out.println("₹" + amountINR + " withdrawn from Account [" + accountNumber + 
                               "]. Remaining Balance: ₹" + balanceINR);
        } else {
            System.out.println("Insufficient balance or invalid amount in Account [" + accountNumber + "]!");
        }
    }

    // Common summary display method
    public void displayAccountInfo() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + accountHolderName);
        System.out.println("Balance (INR)  : ₹" + balanceINR);
    }
}

/**
 * Subclass (Child / Derived Class) representing an SBI Savings Bank Account.
 * Inherits all fields and methods from BankAccount using the 'extends' keyword.
 */
class SavingsAccount extends BankAccount {
    // Specific state unique to SavingsAccount
    private double annualInterestRate;

    // Subclass Constructor
    public SavingsAccount(String accountNumber, String accountHolderName, double balanceINR, double annualInterestRate) {
        // 'super' invokes parent constructor to initialize inherited fields
        super(accountNumber, accountHolderName, balanceINR);
        this.annualInterestRate = annualInterestRate;
    }

    // Specific behavior unique to SavingsAccount
    public void addInterest() {
        double interestINR = (balanceINR * annualInterestRate) / 100.0;
        balanceINR += interestINR;
        System.out.println("Annual Interest of ₹" + interestINR + " (" + annualInterestRate + "%) added. New Balance: ₹" + balanceINR);
    }
}

/**
 * Subclass representing an HDFC Current Bank Account for Business.
 * Inherits from BankAccount and adds overdraft functionality.
 */
class CurrentAccount extends BankAccount {
    // Specific state unique to CurrentAccount
    private double overdraftLimitINR;

    public CurrentAccount(String accountNumber, String accountHolderName, double balanceINR, double overdraftLimitINR) {
        super(accountNumber, accountHolderName, balanceINR);
        this.overdraftLimitINR = overdraftLimitINR;
    }

    // Specialized withdraw method utilizing overdraft facility
    public void withdrawWithOverdraft(double amountINR) {
        double maxAvailable = balanceINR + overdraftLimitINR;
        if (amountINR > 0 && amountINR <= maxAvailable) {
            balanceINR -= amountINR;
            System.out.println("Overdraft withdrawal of ₹" + amountINR + " successful from Current Account [" + accountNumber + "].");
            System.out.println("Current Account Balance (may be negative): ₹" + balanceINR);
        } else {
            System.out.println("Withdrawal exceeds overdraft limit of ₹" + overdraftLimitINR + "!");
        }
    }
}

/**
 * Demonstrates What Inheritance Is, Why We Need It, and the Process in Java.
 * 
 * CORE CONCEPTS COVERED:
 * 1. IS-A Relationship: SavingsAccount IS-A BankAccount, CurrentAccount IS-A BankAccount.
 * 2. Code Reusability: Common fields (accountNumber, balanceINR) and methods (deposit, withdraw)
 *    are declared once in BankAccount and automatically inherited by child classes.
 * 3. DRY Principle (Don't Repeat Yourself): Eliminates redundant code writing across related domain objects.
 * 4. Extensibility: Child classes can add specialized attributes (annualInterestRate, overdraftLimitINR)
 *    and specialized methods without altering the superclass code.
 */
public class BasicsAndWhyInheritanceDemo {

    public static void main(String[] args) {
        System.out.println("========================================================================");
        System.out.println("   CONCEPT 1: WHAT IS INHERITANCE & WHY WE NEED IT (INDIAN BANKING SYSTEM)");
        System.out.println("========================================================================");

        // Creating a SavingsAccount object (SBI)
        System.out.println("\n--- Creating Savings Account (SBI) ---");
        SavingsAccount sbiSavings = new SavingsAccount("SBI-SAV-109283", "Rahul Sharma", 50000.0, 3.75);
        
        // Calling INHERITED methods defined in BankAccount parent class
        sbiSavings.displayAccountInfo();
        sbiSavings.deposit(15000.0);

        // Calling SPECIALIZED method defined in SavingsAccount child class
        sbiSavings.addInterest();

        // Creating a CurrentAccount object (HDFC)
        System.out.println("\n--- Creating Current Account (HDFC) ---");
        CurrentAccount hdfcCurrent = new CurrentAccount("HDFC-CUR-882194", "Sharma Traders Pvt Ltd", 100000.0, 50000.0);

        // Calling INHERITED methods
        hdfcCurrent.displayAccountInfo();

        // Calling SPECIALIZED method unique to CurrentAccount
        hdfcCurrent.withdrawWithOverdraft(130000.0); // Uses balance + partial overdraft

        System.out.println("\n========================================================================");
        System.out.println("   KEY TAKEAWAYS FOR STUDENTS:");
        System.out.println("   1. 'extends' creates a Parent-Child (Super-Sub) relationship in Java.");
        System.out.println("   2. Parent class fields/methods are inherited by Child classes automatically.");
        System.out.println("   3. Avoids duplicate code (DRY - Don't Repeat Yourself).");
        System.out.println("   4. Represents an 'IS-A' relationship (e.g., SavingsAccount IS-A BankAccount).");
        System.out.println("========================================================================");
    }
}
