package ru.botsner.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreedyAlgorithmsTest {

    @Test
    void maxNumberFromDigits() {
        String expected = "997531";
        String actual = GreedyAlgorithms.maxNumberFromDigits(new int[] {3, 1, 7, 9, 9, 5});
        assertEquals(expected, actual);
    }

    @Test
    void minStops() {
        int expected = 2;
        int actual = GreedyAlgorithms.minStops(new int[] {0, 200, 375, 550, 750, 950, 1150}, 400);
        assertEquals(expected, actual);
    }

    @Test
    void minStopsWithDistanceOverCapacity() {
        int expected = -1;
        int actual = GreedyAlgorithms.minStops(new int[] {0, 1000, 2000}, 400);
        assertEquals(expected, actual);
    }
}