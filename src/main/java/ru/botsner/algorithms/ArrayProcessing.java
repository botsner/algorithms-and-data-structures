package ru.botsner.algorithms;

public class ArrayProcessing {

    public static int sumItems(int[] arr) {
        int total = 0;
        for (int x : arr) {
            total += x;
        }
        return total;
    }

    public static int recursiveSumItems(int[] arr, int startPos) {
        if (startPos == arr.length) return 0;
        return arr[startPos] + recursiveSumItems(arr, startPos + 1);
    }


    public static int recursiveCountItems(int[] arr, int startPos) {
        if (startPos == arr.length) return 0;
        return 1 + recursiveCountItems(arr, startPos + 1);
    }

    public static int maxItem(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }
        return max;
    }

    public static int recursiveMaxItem(int[] arr, int startPos) {
        if (arr.length - startPos == 2)
            return Math.max(arr[startPos], arr[startPos + 1]);
        int subMax = recursiveMaxItem(arr, startPos + 1);
        return Math.max(arr[startPos], subMax);
    }
}
