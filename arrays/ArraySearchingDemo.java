package arrays;

import java.util.Arrays;

/**
 * ============================================================================
 * SELF-LEARNING GUIDE: ARRAY SEARCHING ALGORITHMS IN JAVA
 * ============================================================================
 * Search Techniques:
 * 1. Linear Search:
 *    - Sequentially checks each element from index 0 to length - 1.
 *    - Works on ANY array (Unsorted or Sorted).
 *    - Time Complexity: O(N)
 * 
 * 2. Binary Search (java.util.Arrays.binarySearch):
 *    - Uses Divide-and-Conquer strategy (compares target with middle element).
 *    - PREREQUISITE: The array MUST be sorted prior to binary search!
 *    - Time Complexity: O(log N)
 *    - Return Value Behavior:
 *      * If found: Returns index (>= 0).
 *      * If NOT found: Returns `-(insertion point) - 1` (a negative number).
 * ============================================================================
 */
public class ArraySearchingDemo {

    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println(" DEMO: LINEAR SEARCH VS BINARY SEARCH IN ARRAYS");
        System.out.println("==================================================================");

        // Sorted array of Indian PIN codes or roll numbers
        int[] rollNumbers = { 12, 18, 25, 33, 45, 58, 72, 89, 94 };
        int target = 45;

        System.out.println("Array Data: " + Arrays.toString(rollNumbers));
        System.out.println("Target Search Key: " + target + "\n");

        // ----------------------------------------------------------------------
        // 1. Custom Linear Search
        // ----------------------------------------------------------------------
        int linearIdx = linearSearch(rollNumbers, target);
        System.out.println("1. Linear Search Result:");
        System.out.println("   Target " + target + " found at Index: " + linearIdx);

        // ----------------------------------------------------------------------
        // 2. Built-in Arrays.binarySearch() on Existing Element
        // ----------------------------------------------------------------------
        int binaryIdx = Arrays.binarySearch(rollNumbers, target);
        System.out.println("\n2. Arrays.binarySearch() Result (Existing Key):");
        System.out.println("   Target " + target + " found at Index: " + binaryIdx);

        // ----------------------------------------------------------------------
        // 3. Built-in Arrays.binarySearch() on Missing Element
        // ----------------------------------------------------------------------
        int missingTarget = 50;
        int missingIdx = Arrays.binarySearch(rollNumbers, missingTarget);
        
        System.out.println("\n3. Arrays.binarySearch() Result (Missing Key: " + missingTarget + "):");
        System.out.println("   Returned Index Value: " + missingIdx);
        
        // Decoding the negative return value: -(insertion point) - 1
        int expectedInsertionPoint = -missingIdx - 1;
        System.out.println("   Explanation: Element " + missingTarget + " was not found.");
        System.out.println("   If inserted to maintain sorted order, it belongs at Index: " + expectedInsertionPoint);
    }

    /**
     * Performs a Linear Search over an array to find target key.
     * @param arr Array to search (sorted or unsorted).
     * @param key Target value to look for.
     * @return 0-based index if found; -1 if key does not exist.
     */
    public static int linearSearch(int[] arr, int key) {
        // Iterate through every element in array sequentially
        for (int i = 0; i < arr.length; i++) {
            // Compare current element with key
            if (arr[i] == key) {
                return i; // Target found, return index immediately
            }
        }
        return -1; // Target not found after checking all elements
    }
}
