package ru.botsner.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortTest {

    @Test
    void quickSort() {
        int[] expectedArr = {-7, -5, 12, 12, 30, 35, 50};
        int[] actualArr = {35, 12, -5, 30, 12, -7, 50};

        QuickSort.quickSort(actualArr, 0, actualArr.length - 1);

        assertArrayEquals(expectedArr, actualArr);
    }
}