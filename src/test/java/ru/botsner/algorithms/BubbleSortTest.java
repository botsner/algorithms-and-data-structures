package ru.botsner.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortTest {

    @Test
    public void bubbleSort() {
        int[] expected = {-494, -5, 1, 12, 30, 30, 119, 203, 1039};
        int[] actual = {30, 1039, -5, 30, 12, 119, -494, 1, 203};
        BubbleSort.bubbleSort(actual);
        assertArrayEquals(expected, actual);
    }
}