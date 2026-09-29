package arrays;

/**
 * Custom Object class representing a UPI Payment transaction in India.
 */
class UPIPayment {
    String transactionId;
    String senderName;
    double amountINR;
    String status;

    public UPIPayment(String transactionId, String senderName, double amountINR, String status) {
        this.transactionId = transactionId;
        this.senderName = senderName;
        this.amountINR = amountINR;
        this.status = status;
    }

    @Override
    public String toString() {
        return "UPIPayment[ID=" + transactionId + ", Sender=" + senderName + 
               ", Amount=₹" + amountINR + ", Status=" + status + "]";
    }
}

/**
 * Demonstrates Declaration and Initialization of Arrays in Java.
 * Covers both Primitive Type Arrays and Object Arrays with Indian context.
 */
public class ArrayDeclarationInitializationDemo {

    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println(" 1. PRIMITIVE ARRAY DECLARATION AND INITIALIZATION");
        System.out.println("==================================================================");

        // --- Step 1: Declaration (Allocates stack reference, no memory on Heap yet) ---
        int[] iplScores;            // Preferred Java style syntax
        double petrolPricesINR[];   // Alternative C/C++ style syntax (valid but less common in Java)

        // --- Step 2: Instantiation (Allocates memory on Heap with default values) ---
        // Creates an array of 5 integers. Default value for int is 0.
        iplScores = new int[5];

        // Creates an array of 4 doubles. Default value for double is 0.0.
        petrolPricesINR = new double[4];

        System.out.println("Default values after instantiation (Primitive int array):");
        System.out.println("Score at index 0: " + iplScores[0]); // Prints 0

        // --- Step 3: Explicit Assignment by Index ---
        iplScores[0] = 184; // Royal Challengers Bengaluru score
        iplScores[1] = 210; // Chennai Super Kings score
        iplScores[2] = 195; // Mumbai Indians score
        iplScores[3] = 172; // Kolkata Knight Riders score
        iplScores[4] = 205; // Punjab Kings score

        petrolPricesINR[0] = 101.94; // New Delhi
        petrolPricesINR[1] = 104.21; // Mumbai
        petrolPricesINR[2] = 102.63; // Chennai
        petrolPricesINR[3] = 103.94; // Kolkata

        System.out.println("\nAfter explicit index assignment:");
        System.out.println("IPL Score at index 0 (RCB): " + iplScores[0] + " runs");
        System.out.println("Petrol Price in Mumbai: ₹" + petrolPricesINR[1] + "/litre");

        // --- Step 4: Combined Declaration, Instantiation, and Initialization (Array Literals) ---
        // Useful when exact values are known at the time of creation.
        int[] autoFareRates = {30, 45, 60, 75, 90}; // Minimum fare base step rates in INR

        // Anonymous array syntax (useful when returning array from method or passing directly)
        boolean[] isFestivalDiscountActive = new boolean[] {true, false, true, true};

        System.out.println("\nInline initialized array (Auto fare rate at index 2): ₹" + autoFareRates[2]);
        System.out.println("Festival discount active at index 0: " + isFestivalDiscountActive[0]);


        System.out.println("\n==================================================================");
        System.out.println(" 2. OBJECT ARRAY DECLARATION AND INITIALIZATION");
        System.out.println("==================================================================");

        // --- Step 1: Object Array Instantiation with size ---
        // NOTE: This creates an array of references, NOT the actual objects yet!
        // All elements are initialized to 'null' by default.
        String[] metroCities = new String[4];
        
        System.out.println("Default value of uninitialized Object array element: " + metroCities[0]); // Prints null

        // Assigning String object references to indices
        metroCities[0] = "Bengaluru";
        metroCities[1] = "Hyderabad";
        metroCities[2] = "Delhi NCR";
        metroCities[3] = "Mumbai";

        System.out.println("Metro City at index 0: " + metroCities[0]);

        // --- Step 2: Custom Object Array Instantiation ---
        UPIPayment[] upiTransactions = new UPIPayment[3]; // Heap allocates array for 3 UPIPayment references

        // Instantiating individual custom objects into array slots
        upiTransactions[0] = new UPIPayment("UPI98765", "Ramesh Kumar", 450.00, "SUCCESS");
        upiTransactions[1] = new UPIPayment("UPI98766", "Priya Sharma", 1200.50, "SUCCESS");
        upiTransactions[2] = new UPIPayment("UPI98767", "Amit Patel", 85.00, "FAILED");

        System.out.println("\nUPI Transactions list:");
        System.out.println("Transaction 1: " + upiTransactions[0]);
        System.out.println("Transaction 2: " + upiTransactions[1]);
        System.out.println("Transaction 3: " + upiTransactions[2]);

        // --- Step 3: Inline Custom Object Array Initialization ---
        UPIPayment[] quickPayments = {
            new UPIPayment("UPI11111", "Suresh Raina", 500.00, "SUCCESS"),
            new UPIPayment("UPI22222", "Ananya Verma", 2500.00, "SUCCESS")
        };

        System.out.println("\nQuick Inline Payment Object Array length: " + quickPayments.length);
        System.out.println("First Quick Payment: " + quickPayments[0]);
    }
}
