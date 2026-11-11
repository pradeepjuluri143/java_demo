package stringHandling;

/**
 * Topic 9: Class StringBuffer
 * 
 * Key Takeaways for Freshers:
 * 1. Unlike String, StringBuffer is MUTABLE (edits happen inside the SAME object!).
 * 2. StringBuffer is THREAD-SAFE because its methods are 'synchronized'.
 *    Use it when multiple threads modify the same text safely.
 * 3. Useful methods:
 *    - append()   : Adds text to the end.
 *    - insert()   : Inserts text at a specific index.
 *    - replace()  : Replaces text between start and end index.
 *    - delete()   : Removes characters between start and end index.
 *    - reverse()  : Reverses the text in-place.
 *    - capacity() : Shows internal memory buffer size (default 16 + initial length).
 */
public class StringBufferDemo {

    public static void main(String[] args) {
        System.out.println("=== 9. CLASS StringBuffer (MUTABLE & THREAD-SAFE) ===\n");

        // Creating a StringBuffer for an IRCTC Train Name
        StringBuffer train = new StringBuffer("Vande Bharat");
        System.out.println("Initial Text    : " + train);
        System.out.println("Length          : " + train.length());
        System.out.println("Capacity        : " + train.capacity()); // 16 + 12 = 28

        // 1. append() - Modifies the same object directly
        train.append(" Express");
        System.out.println("\nAfter append()  : " + train);

        // 2. insert() - Insert text at index 0
        train.insert(0, "IRCTC ");
        System.out.println("After insert()  : " + train);

        // 3. replace() - Replace "IRCTC" (0 to 5) with "Indian Railways"
        train.replace(0, 5, "Indian Railways");
        System.out.println("After replace() : " + train);

        // 4. delete() - Remove "Indian Railways " (0 to 16)
        train.delete(0, 16);
        System.out.println("After delete()  : " + train);

        // 5. reverse() - Quick palindrome check with Indian name "NAMAN"
        StringBuffer name = new StringBuffer("NAMAN");
        String original = name.toString();
        String reversed = name.reverse().toString();
        System.out.println("\nPalindrome Check for \"NAMAN\":");
        System.out.println("  Original : " + original);
        System.out.println("  Reversed : " + reversed);
        System.out.println("  Is Palindrome? : " + original.equals(reversed));
    }
}

