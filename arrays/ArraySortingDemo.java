package arrays;

import java.util.Arrays;
import java.util.Collections;

public class ArraySortingDemo {
    public static void main(String[] args) {
        int[] numbers = { 64, 34, 25, 12, 22, 11, 90 };

        // 1. Custom Bubble Sort (Ascending)
        bubbleSort(numbers);
        System.out.println("Bubble Sorted: " + Arrays.toString(numbers));

        // 2. Custom Selection Sort (Ascending)
        int[] selectionData = { 64, 25, 12, 22, 11 };
        selectionSort(selectionData);
        System.out.println("Selection Sorted: " + Arrays.toString(selectionData));

        // 3. Built-in Arrays.sort()
        int[] data = { 9, 3, 7, 1, 5 };
        Arrays.sort(data);
        System.out.println("Arrays.sort(): " + Arrays.toString(data));

        // 4. Descending Order using Collections.reverseOrder()
        Integer[] boxedData = { 9, 3, 7, 1, 5 };
        Arrays.sort(boxedData, Collections.reverseOrder());
        System.out.println("Descending Sort: " + Arrays.toString(boxedData));
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
