package arrays;

import java.util.Arrays;

public class ArraysClassDemo {
    public static void main(String[] args) {
        int[] numbers = { 10, 20, 30, 40, 50 };

        // 1. String formatting
        System.out.println("1. toString(): " + Arrays.toString(numbers));

        // 2. Filling array
        int[] zeros = new int[5];
        Arrays.fill(zeros, 7);
        System.out.println("2. fill(7): " + Arrays.toString(zeros));

        // 3. Array Copying & Expansion
        int[] expanded = Arrays.copyOf(numbers, 7);
        System.out.println("3. copyOf(7): " + Arrays.toString(expanded));

        // 4. Sub-array Slice
        int[] slice = Arrays.copyOfRange(numbers, 1, 4); // index 1 to 3
        System.out.println("4. copyOfRange(1, 4): " + Arrays.toString(slice));

        // 5. Content Equality
        int[] duplicate = { 10, 20, 30, 40, 50 };
        System.out.println("5. equals(): " + Arrays.equals(numbers, duplicate));
    }
}
