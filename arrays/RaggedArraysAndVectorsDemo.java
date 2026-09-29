package arrays;

public class RaggedArraysAndVectorsDemo {
    public static void main(String[] args) {
        // 1. Ragged Array (Uneven rows)
        int[][] ragged = new int[3][];
        ragged[0] = new int[] { 1, 2 };
        ragged[1] = new int[] { 3, 4, 5, 6 };
        ragged[2] = new int[] { 7 };

        System.out.println("=== Ragged Array Rows ===");
        for (int r = 0; r < ragged.length; r++) {
            System.out.print("Row " + r + " (length " + ragged[r].length + "): ");
            for (int val : ragged[r]) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        // 2. Vector Operations
        double[] vecA = { 3.0, 4.0, 0.0 };
        double[] vecB = { 1.0, 2.0, 5.0 };

        double dotProduct = 0;
        for (int i = 0; i < vecA.length; i++) {
            dotProduct += vecA[i] * vecB[i];
        }

        System.out.println("\n=== Vector Math ===");
        System.out.println("Dot Product (a • b): " + dotProduct);
    }
}
