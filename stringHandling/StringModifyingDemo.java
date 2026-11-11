package stringHandling;

/**
 * Topic 6: Methods for Modifying Strings
 * 
 * Remember: Since String is IMMUTABLE, these methods do NOT modify the original String!
 * Instead, they return a brand-new modified String object.
 * 
 * Methods covered:
 * 1. substring(start) / substring(start, end) : Extracts a part of the string.
 * 2. concat(str)                              : Appends another string at the end.
 * 3. replace(old, new)                        : Replaces characters or substrings.
 * 4. toUpperCase() / toLowerCase()            : Changes character casing.
 * 5. trim() / strip()                         : Removes leading and trailing spaces.
 */
public class StringModifyingDemo {

    public static void main(String[] args) {
        System.out.println("=== 6. MODIFYING STRINGS (RETURNS NEW STRINGS) ===\n");

        // 1. substring() - Indian Vehicle Number Plate (Pune MH-12)
        String carNumber = "MH-12-AB-9999";
        String stateCode = carNumber.substring(0, 2); // Index 0 to 1 -> "MH"
        String lastDigits = carNumber.substring(9);   // Index 9 to end -> "9999"

        System.out.println("Vehicle Number : " + carNumber);
        System.out.println("State Code     : " + stateCode);
        System.out.println("Last 4 Digits  : " + lastDigits);

        // 2. concat()
        String first = "Swachh ";
        String second = "Bharat";
        System.out.println("\nconcat()       : " + first.concat(second));

        // 3. replace()
        String menu = "Masala Chai - ₹20";
        String updatedMenu = menu.replace("Chai", "Coffee").replace("20", "40");
        System.out.println("\nOriginal Menu  : " + menu);
        System.out.println("Updated Menu   : " + updatedMenu);

        // 4. toUpperCase() and toLowerCase()
        String panInput = "abcde1234f";
        System.out.println("\ntoUpperCase()  : " + panInput.toUpperCase());
        System.out.println("toLowerCase()  : " + "KOLKATA".toLowerCase());

        // 5. trim() and strip() - Cleaning user input spaces
        String userInput = "   New Delhi   ";
        System.out.println("\nOriginal Input : \"" + userInput + "\"");
        System.out.println("After trim()   : \"" + userInput.trim() + "\"");
        System.out.println("After strip()  : \"" + userInput.strip() + "\" (Java 11+: handles Unicode spaces too)");
    }
}

