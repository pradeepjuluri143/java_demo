package stringHandling;

/**
 * Topic 2: Interface CharSequence
 * 
 * Key Takeaways for Freshers:
 * 1. CharSequence is an interface in java.lang representing a readable sequence of char values.
 * 2. It is implemented by 3 major Java classes: String, StringBuffer, and StringBuilder.
 * 3. It provides 4 basic methods: length(), charAt(), subSequence(), and toString().
 * 4. Useful for writing generic methods that accept String, StringBuffer, or StringBuilder!
 */
public class CharSequenceDemo {

    public static void main(String[] args) {
        System.out.println("=== 2. INTERFACE CharSequence DEMO ===\n");

        // All three classes implement the CharSequence interface
        CharSequence upiId = "aarav@okaxis";                    // String
        CharSequence pnrNumber = new StringBuffer("PNR-452189"); // StringBuffer
        CharSequence aadhaarMask = new StringBuilder("XXXX-1234");// StringBuilder

        // Pass all 3 different objects to the same helper method!
        printSequenceDetails("String (UPI ID)", upiId);
        printSequenceDetails("StringBuffer (IRCTC PNR)", pnrNumber);
        printSequenceDetails("StringBuilder (Aadhaar)", aadhaarMask);
    }

    /**
     * Because the parameter is 'CharSequence', this single method works for
     * String, StringBuffer, and StringBuilder without needing separate overloads!
     */
    public static void printSequenceDetails(String label, CharSequence seq) {
        System.out.println("--- " + label + " ---");
        System.out.println("  Full Text (toString)   : " + seq.toString());
        System.out.println("  Length (length)        : " + seq.length());
        System.out.println("  First Char (charAt 0)  : " + seq.charAt(0));
        System.out.println("  SubSequence (0 to 4)   : " + seq.subSequence(0, 4));
        System.out.println();
    }
}

