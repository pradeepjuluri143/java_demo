package arrays;

import java.util.Arrays;

/**
 * ============================================================================
 * SELF-LEARNING GUIDE: JAVA java.util.Arrays UTILITY CLASS
 * ============================================================================
 * The `java.util.Arrays` class provides static helper methods to perform common
 * array operations quickly without writing manual loops:
 * 1. `Arrays.toString()`       : Formats array content into human-readable string.
 * 2. `Arrays.fill()`           : Fills entire array or range with a default value.
 * 3. `Arrays.copyOf()`         : Creates a copy of array with new specified length.
 * 4. `Arrays.copyOfRange()`    : Copies a specific sub-array slice [fromIndex, toIndex).
 * 5. `Arrays.equals()`         : Compares element content equality of two arrays.
 * 6. `Arrays.deepToString()`   : Formats multi-dimensional arrays (2D/3D).
 * ============================================================================
 */
public class ArraysClassDemo {

    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println(" DEMO: java.util.Arrays UTILITY CLASS METHODS");
        System.out.println("==================================================================");

        int[] numbers = { 10, 20, 30, 40, 50 };

        // ----------------------------------------------------------------------
        // 1. String formatting: Arrays.toString()
        // ----------------------------------------------------------------------
        System.out.println("1. Arrays.toString():");
        System.out.println("   Formatted Output: " + Arrays.toString(numbers));

        // ----------------------------------------------------------------------
        // 2. Filling array with default values: Arrays.fill()
        // ----------------------------------------------------------------------
        int[] scores = new int[5];
        Arrays.fill(scores, 7); // Sets every index of array to 7
        System.out.println("\n2. Arrays.fill(scores, 7):");
        System.out.println("   Filled Array: " + Arrays.toString(scores));

        // ----------------------------------------------------------------------
        // 3. Array Copying & Resizing: Arrays.copyOf()
        // ----------------------------------------------------------------------
        // Expands array size from 5 to 7; new extra slots are initialized to 0 default
        int[] expanded = Arrays.copyOf(numbers, 7);
        System.out.println("\n3. Arrays.copyOf(numbers, 7):");
        System.out.println("   Expanded Copy (Length 7): " + Arrays.toString(expanded));

        // Truncates array size from 5 to 3
        int[] truncated = Arrays.copyOf(numbers, 3);
        System.out.println("   Truncated Copy (Length 3): " + Arrays.toString(truncated));

        // ----------------------------------------------------------------------
        // 4. Sub-array Slicing: Arrays.copyOfRange(array, fromIndex, toIndex)
        // ----------------------------------------------------------------------
        // Copies elements from index 1 (inclusive) to index 4 (exclusive) -> indices 1, 2, 3
        int[] slice = Arrays.copyOfRange(numbers, 1, 4);
        System.out.println("\n4. Arrays.copyOfRange(numbers, 1, 4):");
        System.out.println("   Sub-array Slice [index 1 to 3]: " + Arrays.toString(slice));

        // ----------------------------------------------------------------------
        // 5. Content Equality Comparison: Arrays.equals() vs '=='
        // ----------------------------------------------------------------------
        int[] originalArray = { 10, 20, 30, 40, 50 };
        int[] duplicateArray = { 10, 20, 30, 40, 50 };

        // Note: '==' compares reference memory address, NOT content!
        boolean referenceEquals = (originalArray == duplicateArray); // false (different Heap objects)
        boolean contentEquals = Arrays.equals(originalArray, duplicateArray); // true (same elements)

        System.out.println("\n5. Array Equality Comparison:");
        System.out.println("   Reference Equality (originalArray == duplicateArray) : " + referenceEquals);
        System.out.println("   Content Equality   (Arrays.equals(arr1, arr2))      : " + contentEquals);

        // ----------------------------------------------------------------------
        // 6. Multi-dimensional Formatting: Arrays.deepToString()
        // ----------------------------------------------------------------------
        int[][] matrix = { { 1, 2 }, { 3, 4 } };
        System.out.println("\n6. Arrays.deepToString() for 2D Arrays:");
        System.out.println("   2D Matrix output: " + Arrays.deepToString(matrix));
    }
}
