package arrays;

import java.util.Arrays;

public class ArraySearchingDemo {
    public static void main(String[] args) {
        int[] numbers = { 12, 18, 25, 33, 45, 58, 72, 89, 94 };
        int target = 45;

        // 1. Custom Linear Search
        int linearIdx = linearSearch(numbers, target);
        System.out.println("Linear Search Index: " + linearIdx);

        // 2. Built-in Arrays.binarySearch()
        int binaryIdx = Arrays.binarySearch(numbers, target);
        System.out.println("Arrays.binarySearch() Index: " + binaryIdx);

        // 3. Searching non-existent value
        int missingIdx = Arrays.binarySearch(numbers, 50);
        System.out.println("Missing element 50 return value: " + missingIdx);
    }

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }
}
