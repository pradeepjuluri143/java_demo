package arrays;

import java.util.Arrays;

/**
 * ============================================================================
 * SELF-LEARNING GUIDE: UNDERSTANDING DYNAMIC ARRAYS IN JAVA
 * ============================================================================
 * Problem with Standard Arrays:
 * - Standard Java arrays have a FIXED capacity allocated at instantiation (e.g. new int[5]).
 * - You CANNOT shrink or grow an array once created on the Heap.
 * 
 * Solution - Dynamic Array (How java.util.ArrayList works internally):
 * 1. Start with an initial capacity (e.g. size 2).
 * 2. Track the number of active elements with a `size` counter.
 * 3. When `size == capacity`, allocate a NEW larger array (e.g. 2x growth).
 * 4. Fast-copy existing elements from old array to new array using `System.arraycopy()`.
 * 5. Reassign internal pointer (`data = newArray`) to point to the new Heap memory.
 * ============================================================================
 */
public class DynamicArrayDemo {
    private int[] data; // Internal array reference on Heap
    private int size;   // Number of actual elements currently stored

    /**
     * Constructor initializing the dynamic array with a starting capacity.
     * @param initialCapacity Starting size of internal array.
     */
    public DynamicArrayDemo(int initialCapacity) {
        data = new int[initialCapacity];
        size = 0; // Initially 0 elements stored
    }

    /**
     * Appends an element to the dynamic array.
     * Automatically triggers resizing if capacity limit is reached.
     * @param value Integer value to add.
     */
    public void add(int value) {
        // Step 1: Check if internal array is full
        if (size == data.length) {
            // Trigger 2x growth capacity doubling strategy
            resize(data.length * 2);
        }

        // Step 2: Store element at current size index and post-increment size counter
        data[size] = value;
        size++;

        System.out.println("Added: " + value + " | Current Size: " + size + " | Capacity: " + data.length);
    }

    /**
     * Private helper method to grow the internal array capacity.
     * @param newCapacity New target capacity (e.g., double the current size).
     */
    private void resize(int newCapacity) {
        System.out.println("  [Resize Event] Growing capacity from " + data.length + " -> " + newCapacity);

        // Allocate a new larger array on Heap
        int[] newArray = new int[newCapacity];

        // System.arraycopy(src, srcPos, dest, destPos, length)
        // High-performance native byte copy from old array memory to new array memory
        System.arraycopy(data, 0, newArray, 0, size);

        // Reassign internal pointer to point to newly created array object
        data = newArray;
    }

    /**
     * Gets element at index with bounds checking.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        return data[index];
    }

    /**
     * Returns current number of active elements.
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns current maximum capacity of internal array.
     */
    public int getCapacity() {
        return data.length;
    }

    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println(" DEMO: CUSTOM DYNAMIC ARRAY (HOW ARRAYLIST WORKS INTERNALLY)");
        System.out.println("==================================================================");

        // Instantiate dynamic array tracking sleeper train waiting list numbers with initial capacity of 2
        DynamicArrayDemo waitingListPNC = new DynamicArrayDemo(2);

        System.out.println("Initial Capacity: " + waitingListPNC.getCapacity() + "\n");

        // Adding elements to demonstrate dynamic growth
        waitingListPNC.add(101); // Size: 1, Cap: 2
        waitingListPNC.add(102); // Size: 2, Cap: 2
        
        System.out.println("\n--> Adding 3rd element (Capacity limit reached!)...");
        waitingListPNC.add(103); // Triggers resize to Cap: 4

        waitingListPNC.add(104); // Size: 4, Cap: 4
        
        System.out.println("\n--> Adding 5th element (Capacity limit reached again!)...");
        waitingListPNC.add(105); // Triggers resize to Cap: 8

        System.out.println("\nFinal State:");
        System.out.println("Total Elements (Size): " + waitingListPNC.getSize());
        System.out.println("Internal Array Capacity: " + waitingListPNC.getCapacity());
        System.out.println("Element at index 2: PNR #" + waitingListPNC.get(2));
    }
}
