package arrays;

import java.util.Arrays;
import java.util.Collections;

/**
 * ============================================================================
 * SELF-LEARNING GUIDE: ARRAY SORTING ALGORITHMS IN JAVA
 * ============================================================================
 * Concepts Covered:
 * 1. Bubble Sort: Repeatedly compares adjacent elements and swaps them if in wrong order.
 *    - Time Complexity: O(N^2)
 *    - In-place sorting algorithm.
 * 2. Selection Sort: Finds the minimum element from unsorted portion and moves it to start.
 *    - Time Complexity: O(N^2)
 *    - Minimizes number of swaps.
 * 3. Arrays.sort() (Primitive int[]): Uses Dual-Pivot Quicksort.
 *    - Time Complexity: O(N log N)
 * 4. Arrays.sort() with Comparator (Objects / Integer[]): Uses TimSort.
 *    - Demonstrates descending order sorting using Collections.reverseOrder().
 * ============================================================================
 */
public class ArraySortingDemo {

    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println(" DEMO: ARRAY SORTING ALGORITHMS & UTILITIES");
        System.out.println("==================================================================");

        // --- 1. Custom Bubble Sort ---
        int[] iplPlayerRuns = { 64, 34, 25, 12, 22, 11, 90 };
        System.out.println("1. BUBBLE SORT DEMO");
        System.out.println("  Original Scores: " + Arrays.toString(iplPlayerRuns));
        
        bubbleSort(iplPlayerRuns);
        System.out.println("  Ascending Sorted Scores (Bubble Sort): " + Arrays.toString(iplPlayerRuns));

        // --- 2. Custom Selection Sort ---
        int[] studentRanks = { 64, 25, 12, 22, 11 };
        System.out.println("\n2. SELECTION SORT DEMO");
        System.out.println("  Original Ranks: " + Arrays.toString(studentRanks));
        
        selectionSort(studentRanks);
        System.out.println("  Ascending Sorted Ranks (Selection Sort): " + Arrays.toString(studentRanks));

        // --- 3. Built-in Arrays.sort() ---
        int[] temperaturesInC = { 38, 27, 42, 19, 31 };
        System.out.println("\n3. BUILT-IN Arrays.sort() DEMO (Dual-Pivot Quicksort)");
        System.out.println("  Unsorted Temperatures (°C): " + Arrays.toString(temperaturesInC));
        
        Arrays.sort(temperaturesInC); // Sorts array in-place in Ascending order
        System.out.println("  Sorted Temperatures (°C): " + Arrays.toString(temperaturesInC));

        // --- 4. Descending Order Sorting ---
        // NOTE: Collections.reverseOrder() requires Object wrapper types (Integer[]), NOT primitive int[].
        Integer[] goldPricesINR = { 7200, 6950, 7450, 7100, 7300 };
        System.out.println("\n4. DESCENDING SORT DEMO (Arrays.sort + Collections.reverseOrder)");
        System.out.println("  Unsorted Gold Prices: " + Arrays.toString(goldPricesINR));
        
        Arrays.sort(goldPricesINR, Collections.reverseOrder());
        System.out.println("  Descending Sorted Gold Prices: " + Arrays.toString(goldPricesINR));
    }

    /**
     * Sorts an array using Bubble Sort algorithm in Ascending order.
     * @param arr Primitive int array to sort in-place.
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // Outer loop for passes (N-1 passes needed)
        for (int i = 0; i < n - 1; i++) {
            // Inner loop compares adjacent pairs (n - i - 1 elements remaining)
            for (int j = 0; j < n - i - 1; j++) {
                // If left element is greater than right element, swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Sorts an array using Selection Sort algorithm in Ascending order.
     * @param arr Primitive int array to sort in-place.
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        // Outer loop moves boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i; // Assume current index holds minimum value

            // Inner loop finds index of smallest element in remaining unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j; // Found new minimum index
                }
            }

            // Swap smallest found element with element at boundary index i
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
