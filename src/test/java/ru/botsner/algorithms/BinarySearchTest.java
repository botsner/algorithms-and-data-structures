package ru.botsner.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    @Test
    void binarySearch() {
        int[] arr = {-5, -2, 1, 5, 6, 8, 10, 20};
        int expected = 4;
        int actual = BinarySearch.binarySearch(arr, 6);

        assertEquals(expected, actual);
    }

    @Test
    void binarySearchWhenItemNotFound() {
        int[] arr = {-5, -2, 1, 5, 6, 8, 10, 20};
        int expected = -1;
        int actual = BinarySearch.binarySearch(arr, 30);

        assertEquals(expected, actual);
    }


    @Test
    void binarySearchRecursive() {
        int[] arr = {-5, -2, 1, 5, 6, 8, 10, 20};
        int expected = 4;
        int actual = BinarySearch.binarySearchRecursive(arr, 6, 0, arr.length - 1);

        assertEquals(expected, actual);
    }

    @Test
    void binarySearchRecursiveWhenItemNotFound() {
        int[] arr = {-5, -2, 1, 5, 6, 8, 10, 20};
        int expected = -1;
        int actual = BinarySearch.binarySearchRecursive(arr, 30, 0, arr.length - 1);

        assertEquals(expected, actual);
    }
}