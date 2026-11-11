package stringHandling;

/**
 * Topic 5: Methods for Comparison of Strings
 * 
 * Methods covered:
 * 1. == vs equals()         : Memory address check vs actual content check!
 * 2. equalsIgnoreCase()     : Content comparison ignoring UPPER/lower case.
 * 3. startsWith() / endsWith(): Checking prefix and suffix (e.g. IFSC code, UPI domain).
 * 4. regionMatches()        : Comparing a specific slice/portion of two Strings.
 * 5. compareTo()            : Dictionary (alphabetical) comparison (returns -, 0, or +).
 */
public class StringComparisonDemo {

    public static void main(String[] args) {
        System.out.println("=== 5. STRING COMPARISON METHODS ===\n");

        // 1. == vs equals() (Most important interview & fresher concept!)
        String s1 = "Mumbai";
        String s2 = new String("Mumbai");

        System.out.println("s1 = \"Mumbai\" (Pool), s2 = new String(\"Mumbai\") (Heap)");
        System.out.println("s1 == s2 (compares memory address) : " + (s1 == s2));      // false!
        System.out.println("s1.equals(s2) (compares text)      : " + s1.equals(s2));   // true!

        // 2. equalsIgnoreCase()
        String cityInput = "mumbai";
        System.out.println("\ns1.equalsIgnoreCase(\"mumbai\")      : " + s1.equalsIgnoreCase(cityInput)); // true

        // 3. startsWith() and endsWith()
        String ifscCode = "SBIN0001234"; // State Bank of India IFSC Code
        String upiId = "priya@okicici";

        System.out.println("\nIFSC Code (" + ifscCode + ") starts with SBIN? : " + ifscCode.startsWith("SBIN"));
        System.out.println("UPI ID (" + upiId + ") ends with @okicici?  : " + upiId.endsWith("@okicici"));

        // 4. regionMatches() - Checks if "HDFC" inside both strings matches
        String branch1 = "IN_HDFC_MUMBAI";
        String branch2 = "HDFC_BANK";
        // Compare 4 chars starting at index 3 of branch1 with index 0 of branch2
        boolean sameBank = branch1.regionMatches(3, branch2, 0, 4);
        System.out.println("\nregionMatches (HDFC in both)       : " + sameBank);

        // 5. compareTo() - Dictionary / Alphabetical comparison
        // Returns: < 0 if first comes before second, 0 if equal, > 0 if after
        String name1 = "Aarav";
        String name2 = "Priya";
        System.out.println("\n\"Aarav\".compareTo(\"Priya\")         : " + name1.compareTo(name2)); // Negative ('A' < 'P')
        System.out.println("\"Priya\".compareTo(\"Aarav\")         : " + name2.compareTo(name1)); // Positive ('P' > 'A')
        System.out.println("\"Aarav\".compareTo(\"Aarav\")         : " + name1.compareTo("Aarav")); // 0 (Equal)
    }
}

