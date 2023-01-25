package ru.botsner.algorithms;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int smallestIndex = findSmallest(arr, i);
            int min = arr[smallestIndex];

            arr[smallestIndex] = arr[i];
            arr[i] = min;
        }
    }

    private static int findSmallest(int[] arr, int startIdx) {
        int smallest = arr[startIdx];
        int smallestIndex = startIdx;

        startIdx += 1;
        for (; startIdx < arr.length; startIdx++) {
            if (arr[startIdx] < smallest) {
                smallest = arr[startIdx];
                smallestIndex = startIdx;
            }
        }
        return smallestIndex;
    }
}
