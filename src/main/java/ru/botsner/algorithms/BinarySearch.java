package ru.botsner.algorithms;

public class BinarySearch {

    public static int binarySearch(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int currentIem = arr[mid];

            if (currentIem == item)
                return mid;
            if (currentIem > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int item, int low, int high) {
        int mid = (low + high) / 2;
        int currentIem = arr[mid];

        if (currentIem == item)
            return mid;

        if (low == high)
            return -1;

        if (currentIem > item) {
            return binarySearchRecursive(arr, item, low, mid - 1);
        } else {
            return binarySearchRecursive(arr, item, mid + 1, high);
        }
    }
}
