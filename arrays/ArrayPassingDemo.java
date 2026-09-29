package arrays;

/**
 * Demonstrates array passing and mutation in Java, covering how both
 * primitive arrays and object arrays behave when their references
 * are passed to methods, including element mutation and reference
 * reassignment.
 */
public class ArrayPassingDemo {

    public static void main(String[] args) {
        int[] original = { 10, 20, 30 };

        System.out.println("Original before method: " + original[0]); // 10

        // 1. Method that modifies array elements
        modifyArrayElements(original);
        System.out.println("Original after modifyArrayElements: " + original[0]); // 99 (MUTATED!)

        // 2. Method that reassigns local reference
        reassignArrayReference(original);
        System.out.println("Original after reassignArrayReference: " + original[0]); // Still 99!
    }

    public static void modifyArrayElements(int[] arr) {
        arr[0] = 99; // Modifies Heap object referenced by original!
    }

    public static void reassignArrayReference(int[] arr) {
        arr = new int[] { 500, 600, 700 }; // Points arr to NEW object; original untouched!
    }
}