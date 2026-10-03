package inheritance;

/**
 * Superclass representing Reserve Bank of India (RBI) Banking Regulatory Policy.
 */
class RBIBankingRegulation {
    // 1. FINAL VARIABLE (CONSTANT): Immutable rate defined by RBI monetary policy committee.
    public static final double MINIMUM_CRASH_RESERVE_RATIO_CRR = 4.5; // Percentage
    public static final double REPO_RATE_PERCENT = 6.5;                // Percentage

    protected String bankName;
    protected String ifscPrefix;

    public RBIBankingRegulation(String bankName, String ifscPrefix) {
        this.bankName = bankName;
        this.ifscPrefix = ifscPrefix;
    }

    // 2. FINAL METHOD: CANNOT BE OVERRIDDEN BY ANY COMMERCIAL BANK SUBCLASS!
    // Ensures that core RBI compliance check logic cannot be tampered with or altered by banks.
    public final void verifyRBICompliance(double currentCRRBalancePercentage) {
        System.out.println("--- RBI Compliance Verification for [" + bankName + "] ---");
        System.out.println("Required CRR Floor Rate : " + MINIMUM_CRASH_RESERVE_RATIO_CRR + "%");
        System.out.println("Bank's Maintained CRR   : " + currentCRRBalancePercentage + "%");

        if (currentCRRBalancePercentage >= MINIMUM_CRASH_RESERVE_RATIO_CRR) {
            System.out.println("Result: PASSED. Bank [" + bankName + "] is compliant with RBI CRR guidelines.");
        } else {
            System.out.println("Result: VIOLATION DETECTED! RBI penalty imposed on " + bankName + "!");
        }
    }

    // Normal non-final method: Commercial banks CAN override this to customize customer services
    public void calculateHomeLoanInterest(double loanAmountINR, int tenureYears) {
        double interestRate = REPO_RATE_PERCENT + 2.5; // Base 9.0%
        System.out.println("[" + bankName + "] Generic Home Loan Rate: " + interestRate + "%");
    }
}

/**
 * Subclass representing SBI (State Bank of India).
 * Demonstrates overriding normal methods while respecting final methods and final variables.
 */
class StateBankOfIndia extends RBIBankingRegulation {

    public StateBankOfIndia() {
        super("State Bank of India (SBI)", "SBIN0001024");
    }

    // Overriding normal method to offer SBI-specific concession
    @Override
    public void calculateHomeLoanInterest(double loanAmountINR, int tenureYears) {
        // SBI uses REPO_RATE_PERCENT (final constant) + 1.75% margin
        double sbiRate = REPO_RATE_PERCENT + 1.75; // 8.25%
        double annualInterest = (loanAmountINR * sbiRate) / 100.0;
        System.out.println("[SBI Custom Rate] Home Loan Interest Rate: " + sbiRate + 
                           "% | Annual Interest on ₹" + loanAmountINR + " is ₹" + annualInterest);
    }

    /*
     * UNCOMMENTING THE METHOD BELOW WILL CAUSE A COMPILATION ERROR:
     * 
     * @Override
     * public void verifyRBICompliance(double currentCRRBalancePercentage) {
     *     System.out.println("SBI trying to bypass RBI compliance!");
     * }
     * 
     * Error: verifyRBICompliance(double) in StateBankOfIndia cannot override 
     *        verifyRBICompliance(double) in RBIBankingRegulation; overridden method is final.
     */
}

// ============================================================================
// 3. FINAL CLASS: Cannot be extended by any subclass!
// ============================================================================
/**
 * Highly secure class representing the RBI Central Database Vault.
 * Marked 'final' to prevent any unauthorized class from extending and tampering with vault security.
 */
final class RBISecureDatabaseVault {
    private String vaultKey;

    public RBISecureDatabaseVault(String vaultKey) {
        this.vaultKey = vaultKey;
    }

    public void accessCentralLedger() {
        System.out.println("[RBI Central Vault] Accessing encrypted national interbank clearing ledger.");
    }
}

/*
 * UNCOMMENTING THE CLASS BELOW WILL CAUSE A COMPILATION ERROR:
 * 
 * class HackedVault extends RBISecureDatabaseVault {
 *     // Compiler Error: Cannot inherit from final 'inheritance.RBISecureDatabaseVault'
 * }
 */

/**
 * Demonstrates Final Keyword Impact on Inheritance in Java.
 * 
 * CORE RULES COVERED:
 * 1. Final Variables : Cannot be reassigned once initialized (Acts as constant).
 * 2. Final Methods   : Cannot be overridden by subclasses (Prevents alteration of security/business rules).
 * 3. Final Classes   : Cannot be extended/subclassed at all (e.g. String, Math, Integer, System).
 * 4. Rationale       : Immutability, Security enforcement, & JIT compiler optimization (Inlining).
 */
public class FinalKeywordInheritanceDemo {

    public static void main(String[] args) {
        System.out.println("========================================================================");
        System.out.println("   CONCEPT 6: FINAL KEYWORD IMPACT ON INHERITANCE (RBI BANKING RULES)");
        System.out.println("========================================================================");

        // 1. Demonstrating Final Variables (Constants)
        System.out.println("\n--- 1. Final Variables (RBI Monetary Constants) ---");
        System.out.println("RBI Repo Rate (Constant) : " + RBIBankingRegulation.REPO_RATE_PERCENT + "%");
        System.out.println("RBI Minimum CRR Floor    : " + RBIBankingRegulation.MINIMUM_CRASH_RESERVE_RATIO_CRR + "%");

        // Trying to reassign final variable will fail:
        // RBIBankingRegulation.REPO_RATE_PERCENT = 7.0; // COMPILER ERROR!

        // 2. Instantiating Subclass (SBI) and testing Final Method
        System.out.println("\n--- 2. Final Method Enforcement ---");
        StateBankOfIndia sbi = new StateBankOfIndia();
        
        // SBI calls inherited final method (verifyRBICompliance) - Execution is guaranteed to follow RBI rules!
        sbi.verifyRBICompliance(4.8); // Compliant (4.8% >= 4.5%)
        sbi.verifyRBICompliance(3.9); // Non-compliant warning

        // 3. Testing Overridden Normal Method
        System.out.println("\n--- 3. Overridden Normal Method ---");
        sbi.calculateHomeLoanInterest(5000000.0, 20); // ₹50 Lakh loan

        // 4. Demonstrating Final Class usage
        System.out.println("\n--- 4. Final Class Usage ---");
        RBISecureDatabaseVault centralVault = new RBISecureDatabaseVault("KEY-RBI-MUMBAI-9901");
        centralVault.accessCentralLedger();

        System.out.println("\n========================================================================");
        System.out.println("   FINAL KEYWORD SUMMARY:");
        System.out.println("   - Final Variable : Prevents reassignment (Constant state).");
        System.out.println("   - Final Method   : Prevents method overriding (Locked behavior).");
        System.out.println("   - Final Class    : Prevents inheritance completely (Locked hierarchy).");
        System.out.println("========================================================================");
    }
}
