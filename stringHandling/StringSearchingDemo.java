package stringHandling;

/**
 * Topic 7: Methods for Searching Strings
 * 
 * Methods covered:
 * 1. contains(str)          : Returns true if the substring exists inside the String.
 * 2. indexOf(ch / str)      : Finds the FIRST index of character/substring (returns -1 if not found).
 * 3. indexOf(str, fromIndex): Searches starting from a given index.
 * 4. lastIndexOf(ch / str)  : Finds the LAST index of character/substring (searches backwards).
 */
public class StringSearchingDemo {

    public static void main(String[] args) {
        System.out.println("=== 7. SEARCHING INSIDE STRINGS ===\n");

        String route = "Mumbai to Pune via Mumbai-Pune Expressway";
        System.out.println("Route Text: \"" + route + "\"\n");

        // 1. contains() - Simple true/false check
        System.out.println("Contains \"Pune\"?         : " + route.contains("Pune"));    // true
        System.out.println("Contains \"Delhi\"?        : " + route.contains("Delhi"));   // false

        // 2. indexOf() - Returns first position (index starts at 0)
        int firstMumbai = route.indexOf("Mumbai");
        int firstLetterP = route.indexOf('P');
        int notFound = route.indexOf("Chennai");

        System.out.println("\nindexOf(\"Mumbai\")        : " + firstMumbai);   // 0
        System.out.println("indexOf('P')             : " + firstLetterP);  // 10
        System.out.println("indexOf(\"Chennai\")       : " + notFound);      // -1 (Not found!)

        // 3. indexOf(str, fromIndex) - Finding the SECOND occurrence
        int secondMumbai = route.indexOf("Mumbai", firstMumbai + 1);
        System.out.println("2nd indexOf(\"Mumbai\")    : " + secondMumbai);  // 19

        // 4. lastIndexOf() - Finds the last occurrence from the right
        int lastPune = route.lastIndexOf("Pune");
        System.out.println("lastIndexOf(\"Pune\")      : " + lastPune);      // 26
    }
}

