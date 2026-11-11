package stringHandling;

/**
 * Topic 8: Data Conversion and Miscellaneous String Methods
 * 
 * Methods covered:
 * 1. String.valueOf(...) : Converts numbers, booleans, char[] into String.
 * 2. String.join(...)    : Joins multiple Strings with a separator (e.g. " | ").
 * 3. split(delimiter)    : Splits a String into an array of Strings.
 * 4. String.format(...)  : Creates formatted Strings like printf().
 * 5. repeat(count)       : Repeats a String N times (Java 11+).
 * 6. intern()            : Returns the pooled reference from String Constant Pool.
 */
public class StringDataConversionAndMiscDemo {

    public static void main(String[] args) {
        System.out.println("=== 8. DATA CONVERSION & MISCELLANEOUS METHODS ===\n");

        // 1. String.valueOf() - Converting primitive types to String
        int trainNumber = 12951;      // Mumbai Rajdhani Express
        double ticketFare = 2450.75;
        boolean confirmed = true;

        String trainStr = String.valueOf(trainNumber);
        String fareStr = String.valueOf(ticketFare);
        String statusStr = String.valueOf(confirmed);

        System.out.println("String.valueOf(int)     : " + trainStr);
        System.out.println("String.valueOf(double)  : " + fareStr);
        System.out.println("String.valueOf(boolean) : " + statusStr);

        // 2. String.join() - Joining multiple strings with a delimiter
        String metros = String.join(" -> ", "Delhi", "Jaipur", "Mumbai", "Bengaluru");
        System.out.println("\nString.join() Route     : " + metros);

        // 3. split() - Breaking CSV data into separate fields
        String studentCsv = "Rohit,92,Pune";
        String[] parts = studentCsv.split(",");
        System.out.println("\nsplit() CSV Data:");
        System.out.println("  Name : " + parts[0]);
        System.out.println("  Marks: " + parts[1]);
        System.out.println("  City : " + parts[2]);

        // 4. String.format() - Clean formatting for bills/receipts
        String receipt = String.format("Train #%d | Fare: ₹%.2f | Confirmed: %b",
                trainNumber, ticketFare, confirmed);
        System.out.println("\nString.format() Receipt : " + receipt);

        // 5. repeat() - Drawing decorative borders (Java 11+)
        System.out.println("\nrepeat() Banner         : " + "* ".repeat(10));

        // 6. intern() - Moving Heap String reference into String Constant Pool
        String poolCity = "Chennai";
        String heapCity = new String("Chennai");
        System.out.println("\nBefore intern() (==)    : " + (poolCity == heapCity));          // false
        System.out.println("After intern()  (==)    : " + (poolCity == heapCity.intern())); // true
    }
}

