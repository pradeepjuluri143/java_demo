package arrays;

import java.util.Arrays;

/**
 * ============================================================================
 * SELF-LEARNING GUIDE: PASSING PRIMITIVE ARRAYS TO METHODS IN JAVA
 * ============================================================================
 * Key Concept: Java is strictly PASS-BY-VALUE!
 * - When an array is passed to a method, the VALUE being copied is the
 *   ARRAY REFERENCE (the memory address pointing to the array object on Heap).
 * - Therefore:
 *   1. Modifying elements inside the method (e.g. arr[0] = val) DOES affect
 *      the original array because both caller & method point to the SAME Heap array.
 *   2. Reassigning the parameter reference inside the method (e.g. arr = new int[])
 *      ONLY updates the local reference variable inside method stack frame.
 *      It does NOT change where the caller's reference points!
 * ============================================================================
 */
public class ArrayPassingDemo {

    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println(" DEMO: PRIMITIVE ARRAY PASSING & METHOD MUTATION");
        System.out.println("==================================================================");

        // Scores of an Indian cricket team batsman in 3 consecutive matches
        int[] originalScores = { 10, 20, 30 };

        System.out.println("Initial array content: " + Arrays.toString(originalScores));
        System.out.println("Original element at index 0 before method call: " + originalScores[0]);

        // ----------------------------------------------------------------------
        // Case 1: Modifying array elements inside method
        // ----------------------------------------------------------------------
        System.out.println("\n--> Step 1: Passing array to modifyArrayElements()...");
        modifyArrayElements(originalScores);
        
        // RESULT: originalScores[0] IS changed to 99!
        System.out.println("Original array after modifyArrayElements: " + Arrays.toString(originalScores));
        System.out.println("  [MUTATION SUCCESSFUL] Modifying arr[0] changed the Heap object!");

        // ----------------------------------------------------------------------
        // Case 2: Reassigning array reference inside method
        // ----------------------------------------------------------------------
        System.out.println("\n--> Step 2: Passing array to reassignArrayReference()...");
        reassignArrayReference(originalScores);
        
        // RESULT: originalScores remains unchanged!
        System.out.println("Original array after reassignArrayReference: " + Arrays.toString(originalScores));
        System.out.println("  [REFERENCE PRESERVED] Reassigning 'arr = new int[]' only affected method's local copy!");
    }

    /**
     * Modifies the contents of the array passed to it.
     * @param arr Copy of reference pointing to the original Heap array.
     */
    public static void modifyArrayElements(int[] arr) {
        // 'arr' holds a copy of the reference pointing to 'originalScores' on the Heap.
        // Mutating arr[0] directly updates the array object in Heap memory!
        System.out.println("  [Inside modifyArrayElements] Changing index 0 to 99...");
        arr[0] = 99; 
    }

    /**
     * Attempts to reassign the array reference to a new array.
     * @param arr Copy of reference pointing to the original Heap array.
     */
    public static void reassignArrayReference(int[] arr) {
        // 'arr' is local to this method call stack frame.
        // Pointing 'arr' to a NEW array allocates a second array object on Heap,
        // but DOES NOT change the originalScores reference in the caller's stack frame!
        System.out.println("  [Inside reassignArrayReference] Reassigning parameter variable to new int[]{500, 600, 700}...");
        arr = new int[] { 500, 600, 700 };
        
        System.out.println("  [Inside reassignArrayReference] Local arr content now: " + Arrays.toString(arr));
    }
}