package ru.botsner.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayProcessingTest {

    @Test
    void sumItems() {
        int[] arr = {1, 2, 3, 4, 5};

        int expected = 15;
        int actual = ArrayProcessing.sumItems(arr);

        assertEquals(expected, actual);
    }

    @Test
    void recursiveSumItems() {
        int[] arr = {1, 2, 3, 4, 5};

        int expected = 15;
        int actual = ArrayProcessing.recursiveSumItems(arr, 0);

        assertEquals(expected, actual);
    }

    @Test
    void recursiveCountItems() {
        int[] arr = {1, 2, 3, 4, 5};

        int expected = 5;
        int actual = ArrayProcessing.recursiveCountItems(arr, 0);

        assertEquals(expected, actual);
    }

    @Test
    void maxItem() {
        int[] arr = {1, 3, 5, -5, 10, 6, 2};

        int expected = 10;
        int actual = ArrayProcessing.maxItem(arr);

        assertEquals(expected, actual);
    }

    @Test
    void recursiveMaxItem() {
        int[] arr = {1, 3, 5, -5, 10, 6, 2};

        int expected = 10;
        int actual = ArrayProcessing.recursiveMaxItem(arr, 0);

        assertEquals(expected, actual);
    }
}