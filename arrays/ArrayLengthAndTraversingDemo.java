package arrays;

import java.util.Arrays;

/**
 * Custom class representing an Indian Railway Train route.
 */
class TrainRoute {
    int trainNumber;
    String trainName;
    String source;
    String destination;

    public TrainRoute(int trainNumber, String trainName, String source, String destination) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return trainNumber + " - " + trainName + " (" + source + " -> " + destination + ")";
    }
}

/**
 * Demonstrates Array Length property and various Array Traversing techniques in Java.
 * Covers both Primitive Type Arrays and Object Arrays with Indian context.
 */
public class ArrayLengthAndTraversingDemo {

    public static void main(String[] args) {

        System.out.println("==================================================================");
        System.out.println(" 1. PRIMITIVE ARRAY LENGTH AND TRAVERSING");
        System.out.println("==================================================================");

        // CBSE Student Marks in 5 subjects (Physics, Chemistry, Maths, English, Computer Science)
        int[] cbseMarks = {88, 92, 95, 84, 98};

        // --- Array Length Property ---
        // NOTE: 'length' is a public final instance variable of an array, NOT a method.
        // Array sizes are fixed at creation time and cannot be resized.
        int totalSubjects = cbseMarks.length;
        System.out.println("Total subjects (Array Length): " + totalSubjects);

        // --- Traversing Technique 1: Standard 'for' loop (Forward) ---
        System.out.println("\n[1] Forward Traversal using standard for loop:");
        int totalMarks = 0;
        for (int i = 0; i < cbseMarks.length; i++) {
            System.out.println("  Subject " + (i + 1) + " Mark: " + cbseMarks[i]);
            totalMarks += cbseMarks[i];
        }
        double percentage = (double) totalMarks / cbseMarks.length;
        System.out.printf("  Total Marks: %d/500 | Percentage: %.2f%%\n", totalMarks, percentage);

        // --- Traversing Technique 2: Standard 'for' loop (Reverse/Backward) ---
        System.out.println("\n[2] Reverse Traversal using standard for loop:");
        for (int i = cbseMarks.length - 1; i >= 0; i--) {
            System.out.println("  Index " + i + " -> Mark: " + cbseMarks[i]);
        }

        // --- Traversing Technique 3: Enhanced 'for-each' loop ---
        // Best for clean read-only iteration over all elements.
        System.out.println("\n[3] Traversal using Enhanced for-each loop:");
        for (int mark : cbseMarks) {
            System.out.print(mark + " ");
        }
        System.out.println();

        // --- Traversing Technique 4: 'while' loop ---
        System.out.println("\n[4] Traversal using while loop:");
        int index = 0;
        while (index < cbseMarks.length) {
            System.out.println("  Index " + index + ": " + cbseMarks[index]);
            index++; // Crucial increment step to avoid infinite loop
        }

        // --- Traversing Technique 5: Arrays.toString() utility ---
        System.out.println("\n[5] Utility Traversal using Arrays.toString():");
        System.out.println("  " + Arrays.toString(cbseMarks));


        System.out.println("\n==================================================================");
        System.out.println(" 2. OBJECT ARRAY LENGTH AND TRAVERSING");
        System.out.println("==================================================================");

        TrainRoute[] expressTrains = {
            new TrainRoute(12627, "Karnataka Express", "Bengaluru City", "New Delhi"),
            new TrainRoute(12951, "Mumbai Rajdhani Express", "Mumbai Central", "New Delhi"),
            new TrainRoute(12759, "Charminar Express", "Chennai Central", "Hyderabad"),
            new TrainRoute(12259, "Sealdah Duronto Express", "Kolkata Sealdah", "New Delhi")
        };

        System.out.println("Total Express Trains in list (Array Length): " + expressTrains.length);

        // --- Object Array Forward Traversal with 'for' loop ---
        System.out.println("\n[1] Object Array Index Traversal (Train Schedules):");
        for (int i = 0; i < expressTrains.length; i++) {
            // Accessing object properties/methods via array index
            System.out.println("  Train #" + (i + 1) + ": " + expressTrains[i]);
        }

        // --- Object Array Traversal with 'for-each' loop ---
        System.out.println("\n[2] Object Array Enhanced for-each Traversal:");
        for (TrainRoute train : expressTrains) {
            // 'train' variable holds reference to each TrainRoute object in heap
            System.out.println("  -> " + train.trainName + " departing from " + train.source);
        }


        System.out.println("\n==================================================================");
        System.out.println(" 3. MULTI-DIMENSIONAL ARRAY (2D ARRAY) TRAVERSING");
        System.out.println("==================================================================");

        // Temperatures (°C) of 3 Indian Cities (Delhi, Mumbai, Bengaluru) across 4 Quarters
        // Rows = Cities (3), Columns = Quarters (4)
        double[][] cityTemperatures = {
            { 15.5, 38.0, 32.5, 20.0 }, // Delhi (Q1, Q2, Q3, Q4)
            { 27.0, 34.5, 30.0, 28.5 }, // Mumbai
            { 21.0, 33.0, 26.5, 22.0 }  // Bengaluru
        };

        String[] cities = {"Delhi", "Mumbai", "Bengaluru"};

        // Outer array length = Number of rows (cities)
        System.out.println("Number of rows (Cities): " + cityTemperatures.length);
        // Inner array length = Number of columns (quarters for row 0)
        System.out.println("Number of columns for Delhi: " + cityTemperatures[0].length);

        // Nested for loop traversal
        System.out.println("\nQuarterly Temperature Summary:");
        for (int i = 0; i < cityTemperatures.length; i++) {
            System.out.print("  " + cities[i] + ": ");
            for (int j = 0; j < cityTemperatures[i].length; j++) {
                System.out.print("Q" + (j + 1) + "=" + cityTemperatures[i][j] + "°C  ");
            }
            System.out.println();
        }
    }
}
