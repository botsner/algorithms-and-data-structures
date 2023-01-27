package ru.botsner.algorithms;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (arr.length == 0 || low >= high) return;

        int mid = (low + high) / 2;
        int pivot = arr[mid];

        int i = low, j = high;

        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) quickSort(arr, low, j);
        if (high > i) quickSort(arr, i, high);
    }
}
