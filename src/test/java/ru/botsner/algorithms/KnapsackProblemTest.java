package ru.botsner.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnapsackProblemTest {
    private final Item item1 = new Item(4, 20);
    private final Item item2 = new Item(3, 18);
    private final Item item3 = new Item(2, 14);

    private final Item[] items = {item1, item2, item3};
    private final int capacity = 7;

    @Test
    void fractionalKnapsackProblem() {
        double expectedValue = 42.0;
        double actualValue = KnapsackProblem.fractionalKnapsackProblem(items, capacity);

        assertEquals(expectedValue, actualValue);
    }
}