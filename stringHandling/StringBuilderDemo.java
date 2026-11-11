package stringHandling;

/**
 * Topic 10: Class StringBuilder
 * 
 * Key Takeaways for Freshers:
 * 1. StringBuilder is MUTABLE (just like StringBuffer).
 * 2. Difference from StringBuffer:
 *    - StringBuilder is NOT synchronized (NOT thread-safe).
 *    - Because it has no locking overhead, StringBuilder is FASTER!
 * 3. Rule of thumb for choosing:
 *    - String        -> Text doesn't change (Immutable).
 *    - StringBuilder -> Text changes frequently in a SINGLE thread (Most common!).
 *    - StringBuffer  -> Text changes frequently across MULTIPLE threads (Thread-safe).
 */
public class StringBuilderDemo {

    public static void main(String[] args) {
        System.out.println("=== 10. CLASS StringBuilder (MUTABLE & FASTEST) ===\n");

        // Building a Dhaba Bill Receipt efficiently inside a single thread
        StringBuilder bill = new StringBuilder();

        // 1. Chaining append() calls (possible because append() returns 'this')
        bill.append("--- APNA PUNJABI DHABA ---\n")
            .append("1. Paneer Butter Masala : ₹240\n")
            .append("2. Butter Naan (x2)     : ₹80\n")
            .append("3. Masala Chai          : ₹30\n");

        System.out.println(bill.toString());

        // 2. insert() - Adding GST line before the end
        bill.append("Total Bill              : ₹350");
        System.out.println("After adding Total:\n" + bill);

        // 3. deleteCharAt() & reverse() quick demo
        StringBuilder code = new StringBuilder("UPI-1234X");
        code.deleteCharAt(code.length() - 1); // Removes 'X' at the end
        System.out.println("\nCleaned UPI Code        : " + code);

        // 4. Converting StringBuilder back to normal String using toString()
        String finalBillString = bill.toString();
        System.out.println("Final String length     : " + finalBillString.length() + " chars");
    }
}

