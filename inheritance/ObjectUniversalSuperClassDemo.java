package inheritance;

import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a UPI Payment Transaction in India (e.g. PhonePe / Google Pay / Paytm).
 * Implicitly extends java.lang.Object!
 * Demonstrates overriding toString(), equals(), and hashCode().
 */
class UPITransaction /* extends Object */ {
    private String transactionId; // Unique Txn Ref ID e.g. "TXN-UPI-99201"
    private String senderUpiId;   // e.g. "rahul@okicici"
    private String receiverUpiId; // e.g. "kirana@paytm"
    private double amountINR;

    public UPITransaction(String transactionId, String senderUpiId, String receiverUpiId, double amountINR) {
        this.transactionId = transactionId;
        this.senderUpiId = senderUpiId;
        this.receiverUpiId = receiverUpiId;
        this.amountINR = amountINR;
    }

    // =========================================================================
    // 1. OVERRIDING toString()
    // =========================================================================
    // Default Object.toString() returns "inheritance.UPITransaction@5e265ba4"
    // Overridden toString() provides clean, readable information for logging.
    @Override
    public String toString() {
        return "UPITransaction[" +
               "ID='" + transactionId + '\'' +
               ", Sender='" + senderUpiId + '\'' +
               ", Receiver='" + receiverUpiId + '\'' +
               ", Amount=₹" + amountINR +
               ']';
    }

    // =========================================================================
    // 2. OVERRIDING equals(Object obj) FOR LOGICAL EQUALITY
    // =========================================================================
    // Default Object.equals() compares memory addresses (this == obj).
    // We override it to compare logical transaction content (transactionId & senderUpiId).
    @Override
    public boolean equals(Object obj) {
        // Step 1: Check reference equality (Are they pointing to the exact same Heap memory location?)
        if (this == obj) return true;

        // Step 2: Check null and ensure exact class type match
        if (obj == null || getClass() != obj.getClass()) return false;

        // Step 3: Typecast object to UPITransaction
        UPITransaction otherTxn = (UPITransaction) obj;

        // Step 4: Compare logical primary key fields (transactionId and senderUpiId)
        return Double.compare(otherTxn.amountINR, amountINR) == 0 &&
               Objects.equals(transactionId, otherTxn.transactionId) &&
               Objects.equals(senderUpiId, otherTxn.senderUpiId);
    }

    // =========================================================================
    // 3. OVERRIDING hashCode() TO RESPECT EQUALS-HASHCODE CONTRACT
    // =========================================================================
    // Contract: If two objects are equal according to equals(), they MUST have identical hashCodes!
    @Override
    public int hashCode() {
        return Objects.hash(transactionId, senderUpiId, amountINR);
    }
}

/**
 * Demonstrates Universal Super Class Object & Important Methods in Java.
 * 
 * CORE CONCEPTS COVERED:
 * 1. Universal Root Class : java.lang.Object is the top superclass of ALL classes in Java.
 * 2. toString()           : Overridden to convert object state to human-readable String.
 * 3. '==' vs '.equals()'  : '==' checks reference memory identity; '.equals()' checks logical content equality.
 * 4. equals() Contract    : Reflexive, Symmetric, Transitive, Consistent, Non-null check.
 * 5. hashCode() Contract  : Equal objects MUST generate the same integer hash code!
 */
public class ObjectUniversalSuperClassDemo {

    public static void main(String[] args) {
        System.out.println("========================================================================");
        System.out.println("   CONCEPT 7: UNIVERSAL SUPER CLASS OBJECT & METHODS (UPI PAYMENTS)");
        System.out.println("========================================================================");

        // Creating three transaction objects
        UPITransaction txn1 = new UPITransaction("TXN-2026-991", "priya@okaxis", "zomato@icici", 450.0);
        UPITransaction txn2 = new UPITransaction("TXN-2026-991", "priya@okaxis", "zomato@icici", 450.0); // Duplicate content
        UPITransaction txn3 = new UPITransaction("TXN-2026-992", "rahul@sbi", "swiggy@hdfc", 350.0);

        // --- 1. Testing toString() ---
        System.out.println("\n--- 1. Testing toString() Output ---");
        System.out.println("txn1.toString() -> " + txn1); // Automatically calls toString()
        System.out.println("txn3.toString() -> " + txn3);

        // --- 2. Testing '==' vs 'equals()' ---
        System.out.println("\n--- 2. Comparing Reference (==) vs Logical Content (.equals()) ---");
        System.out.println("txn1 == txn2      : " + (txn1 == txn2) + "  (FALSE: Different memory addresses on Heap)");
        System.out.println("txn1.equals(txn2) : " + txn1.equals(txn2) + "  (TRUE : Identical transactionId & fields)");
        System.out.println("txn1.equals(txn3) : " + txn1.equals(txn3) + " (FALSE: Different transaction details)");

        // --- 3. Testing HashCode & Hash Collections Contract ---
        System.out.println("\n--- 3. Testing HashCode Contract & HashSet Deduplication ---");
        System.out.println("txn1.hashCode() : " + txn1.hashCode());
        System.out.println("txn2.hashCode() : " + txn2.hashCode() + " (Must match txn1 because txn1.equals(txn2) is true)");
        System.out.println("txn3.hashCode() : " + txn3.hashCode());

        // Adding transactions to a HashSet (HashSet relies on hashCode() and equals() to prevent duplicates)
        Set<UPITransaction> transactionSet = new HashSet<>();
        transactionSet.add(txn1);
        transactionSet.add(txn2); // Duplicate! Should be rejected by HashSet
        transactionSet.add(txn3);

        System.out.println("\nHashSet Size after adding 3 items (txn1, txn2 duplicate, txn3): " + transactionSet.size());
        System.out.println("HashSet Elements:");
        for (UPITransaction t : transactionSet) {
            System.out.println("  -> " + t);
        }

        System.out.println("\n========================================================================");
        System.out.println("   OBJECT CLASS SUMMARY:");
        System.out.println("   1. java.lang.Object is implicit parent of every class.");
        System.out.println("   2. Always override toString() for clean log prints.");
        System.out.println("   3. Always override BOTH equals() AND hashCode() together.");
        System.out.println("========================================================================");
    }
}
