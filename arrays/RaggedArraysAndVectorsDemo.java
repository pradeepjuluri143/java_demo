package arrays;

/**
 * ============================================================================
 * SELF-LEARNING GUIDE: RAGGED (JAGGED) ARRAYS & VECTOR MATHEMATICS IN JAVA
 * ============================================================================
 * Concepts Covered:
 * 1. Ragged (Jagged) Arrays:
 *    - A 2D array where each row can have a DIFFERENT number of columns!
 *    - In C/C++, 2D arrays must have uniform column dimensions.
 *    - In Java, because 2D arrays are "Arrays of 1D Array References", each row
 *      reference can point to a 1D array of any length.
 *    - Memory instantiation: `int[][] ragged = new int[3][];` (Leave column bracket empty!)
 * 
 * 2. Vector Math Operations:
 *    - 1D arrays are frequently used to represent mathematical vectors.
 *    - Dot Product: (A • B) = A[0]*B[0] + A[1]*B[1] + ... + A[n-1]*B[n-1]
 * ============================================================================
 */
public class RaggedArraysAndVectorsDemo {

    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println(" DEMO: RAGGED (JAGGED) ARRAYS & VECTOR MATH");
        System.out.println("==================================================================");

        // ----------------------------------------------------------------------
        // 1. Ragged Array Example
        // Scenario: Auto-rickshaw driver trips per day across 3 days
        // Day 1: 2 trips, Day 2: 4 trips, Day 3: 1 trip
        // ----------------------------------------------------------------------
        System.out.println("=== 1. Ragged Array (Uneven Row Lengths) ===");

        // Step 1: Declare 2D array with 3 rows, but leave column dimension unallocated
        int[][] autoDriverTrips = new int[3][];

        // Step 2: Manually allocate 1D arrays with different lengths for each row
        autoDriverTrips[0] = new int[] { 120, 150 };           // Day 1: 2 trips (Fares in INR)
        autoDriverTrips[1] = new int[] { 80, 200, 95, 310 };   // Day 2: 4 trips
        autoDriverTrips[2] = new int[] { 450 };                 // Day 3: 1 trip

        // Traversing ragged array using dynamic `autoDriverTrips[r].length`
        for (int r = 0; r < autoDriverTrips.length; r++) {
            System.out.print("Day " + (r + 1) + " (Trips: " + autoDriverTrips[r].length + ") -> Fares: ");
            int totalDailyEarnings = 0;

            for (int fare : autoDriverTrips[r]) {
                System.out.print("₹" + fare + " ");
                totalDailyEarnings += fare;
            }
            System.out.println("| Daily Total: ₹" + totalDailyEarnings);
        }

        // ----------------------------------------------------------------------
        // 2. Vector Mathematics (Dot Product)
        // ----------------------------------------------------------------------
        System.out.println("\n=== 2. Vector Operations (Dot Product) ===");

        // Vector A and Vector B in 3D Space (X, Y, Z coordinates)
        double[] vecA = { 3.0, 4.0, 0.0 };
        double[] vecB = { 1.0, 2.0, 5.0 };

        // Calculating Dot Product: (3*1) + (4*2) + (0*5) = 3 + 8 + 0 = 11.0
        double dotProduct = 0;
        for (int i = 0; i < vecA.length; i++) {
            dotProduct += vecA[i] * vecB[i];
        }

        System.out.println("Vector A: [" + vecA[0] + ", " + vecA[1] + ", " + vecA[2] + "]");
        System.out.println("Vector B: [" + vecB[0] + ", " + vecB[1] + ", " + vecB[2] + "]");
        System.out.println("Dot Product (A • B): " + dotProduct);
    }
}
