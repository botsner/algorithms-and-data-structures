package ru.botsner.algorithms;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectionSortTest {

    @Test
    void selectionSort() {
        int[] expected = {-494, -5, 1, 12, 30, 30, 119, 203, 1039};
        int[] actual = {30, 1039, -5, 30, 12, 119, -494, 1, 203};
        SelectionSort.selectionSort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void findSmallest() throws Exception {
        Class<SelectionSort> selectionSorClass = SelectionSort.class;
        Method method = selectionSorClass.getDeclaredMethod("findSmallest", int[].class, int.class);
        method.setAccessible(true);

        int[] arr = {30, -5, 1039, 30, 12, 1, 119, 203};

        int expected = 5;
        int actual = (int) method.invoke(selectionSorClass, arr, 2);

        assertEquals(expected, actual);
    }
}