package stringHandling;

/**
 * Topic 3: Class String (Constructors & Basic Inspection Methods)
 * 
 * Key Takeaways for Freshers:
 * 1. java.lang.String is a 'final' class (no class can inherit from String).
 * 2. String can be created in multiple ways using constructors:
 *    - Empty String: new String()
 *    - From a char array: new String(char[])
 *    - From part of a char array: new String(char[], offset, count)
 *    - From a byte array: new String(byte[])
 *    - From StringBuilder / StringBuffer
 * 3. Basic inspection: length(), isEmpty(), isBlank().
 */
public class StringClassDemo {

    public static void main(String[] args) {
        System.out.println("=== 3. CLASS String (CONSTRUCTORS & BASICS) ===\n");

        // 1. Default Constructor (Empty String)
        String emptyStr = new String();

        // 2. Constructor from a String Literal
        String country = new String("Bharat");

        // 3. Constructor from a char array
        char[] letters = { 'I', 'N', 'D', 'I', 'A' };
        String fullFromChars = new String(letters);
        String shortCode = new String(letters, 0, 3); // Starts at index 0, takes 3 chars -> "IND"

        // 4. Constructor from a byte array (ASCII codes: R=82, B=66, I=73)
        byte[] asciiBytes = { 82, 66, 73 };
        String bankName = new String(asciiBytes);

        // 5. Constructor from StringBuilder
        StringBuilder sb = new StringBuilder("Digital India");
        String fromBuilder = new String(sb);

        System.out.println("Empty String       : \"" + emptyStr + "\"");
        System.out.println("From Literal       : " + country);
        System.out.println("From char[]        : " + fullFromChars);
        System.out.println("Sub-range char[]   : " + shortCode);
        System.out.println("From byte[] (ASCII): " + bankName);
        System.out.println("From StringBuilder : " + fromBuilder);

        // 6. Basic Inspection Methods: length(), isEmpty(), isBlank()
        System.out.println("\n--- Basic Inspection Methods ---");
        String spacesOnly = "   ";

        System.out.println("country.length()     : " + country.length());       // 6 characters
        System.out.println("emptyStr.isEmpty()   : " + emptyStr.isEmpty());     // true (length == 0)
        System.out.println("spacesOnly.isEmpty() : " + spacesOnly.isEmpty());   // false (length is 3)
        System.out.println("spacesOnly.isBlank() : " + spacesOnly.isBlank());   // true (Java 11+: only whitespace)
    }
}

