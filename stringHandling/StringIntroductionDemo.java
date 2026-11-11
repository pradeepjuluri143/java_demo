package stringHandling;

/**
 * Topic 1: Introduction to Strings in Java (Indian Context)
 * 
 * Key Takeaways for Freshers:
 * 1. A String represents a sequence of characters (e.g., "Namaste India").
 * 2. String is a class in java.lang package (auto-imported in every Java file).
 * 3. String objects are IMMUTABLE (once created, their value cannot change).
 * 4. Memory: String literals go into the String Constant Pool (SCP) for memory saving,
 *    while 'new String(...)' creates a separate object in Heap memory.
 */
public class StringIntroductionDemo {

    public static void main(String[] args) {
        System.out.println("=== 1. STRING INTRODUCTION DEMO ===\n");

        // 1. Creating String using a String Literal (Stored in String Constant Pool - SCP)
        String city1 = "Bengaluru";
        String city2 = "Bengaluru"; // Reuses the same object from SCP!

        // 2. Creating String using 'new' keyword (Always creates a new object in Heap)
        String city3 = new String("Bengaluru");

        System.out.println("City 1: " + city1);
        System.out.println("City 2: " + city2);
        System.out.println("City 3: " + city3);

        // Comparing memory addresses using ==
        System.out.println("\n--- Memory Reference Check (==) ---");
        System.out.println("city1 == city2 (both in Pool) : " + (city1 == city2)); // true (same object)
        System.out.println("city1 == city3 (Pool vs Heap) : " + (city1 == city3)); // false (different objects)

        // 3. Demonstrating Immutability (Strings cannot be changed in-place)
        System.out.println("\n--- Immutability Check ---");
        String greeting = "Namaste";
        greeting.concat(" India"); // Creates "Namaste India", but we did NOT save it!

        // 'greeting' still prints "Namaste" because Strings are immutable!
        System.out.println("After concat without reassigning: " + greeting);

        // To keep the updated text, we must assign the new String to a variable
        greeting = greeting.concat(" India");
        System.out.println("After reassigning greeting      : " + greeting);
    }
}

