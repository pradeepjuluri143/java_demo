package stringHandling;

/**
 * Topic 4: Methods for Extracting Characters from Strings
 * 
 * Methods covered:
 * 1. charAt(index)                   : Extracts a single character at given index.
 * 2. getChars(srcStart, srcEnd, dst, dstStart): Copies multiple characters into a char[].
 * 3. toCharArray()                   : Converts the entire String into a new char[].
 * 4. getBytes()                      : Converts the String into a byte[] (useful for files/networks).
 */
public class StringExtractCharactersDemo {

    public static void main(String[] args) {
        System.out.println("=== 4. EXTRACTING CHARACTERS FROM STRINGS ===\n");

        // Indian PAN Card format: ABCDE1234F
        String panCard = "ABCDE1234F";

        // 1. charAt(int index) - Index starts at 0
        char firstChar = panCard.charAt(0);
        char fourthChar = panCard.charAt(3); // 4th letter in PAN tells holder status (e.g. 'P' = Person, 'D' etc.)
        System.out.println("PAN Card              : " + panCard);
        System.out.println("charAt(0)             : " + firstChar);
        System.out.println("charAt(3)             : " + fourthChar);

        // 2. getChars(srcBegin, srcEnd, dstArray, dstBegin)
        // Extracts characters from index 5 (inclusive) to 9 (exclusive) -> "1234"
        char[] panDigits = new char[4];
        panCard.getChars(5, 9, panDigits, 0);
        System.out.print("getChars(5, 9) digits : ");
        System.out.println(panDigits);

        // 3. toCharArray() - Converts whole String to a character array
        String city = "JAIPUR";
        char[] cityChars = city.toCharArray();
        System.out.print("\ntoCharArray() of JAIPUR: ");
        for (char ch : cityChars) {
            System.out.print(ch + " ");
        }
        System.out.println();

        // 4. getBytes() - Converts String into raw ASCII/UTF-8 byte values
        String code = "UPI";
        byte[] byteData = code.getBytes();
        System.out.print("getBytes() of UPI      : ");
        for (byte b : byteData) {
            System.out.print(b + " "); // U=85, P=80, I=73
        }
        System.out.println();
    }
}

