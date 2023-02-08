package ru.botsner.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class KnapsackProblem {

    // greedy algorithm
    // items can be divided
    // returns value of the best set
    public static double fractionalKnapsackProblem(Item[] items, int capacity) {
        Arrays.sort(items, Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed());

        double resultValue = 0;

        for (Item item : items) {
            if (capacity == 0) {
                break;
            }
            if (capacity >= item.getWeight()) {
                // take whole object
                resultValue += item.getValue();
                capacity -= item.getWeight();
            } else {
                // take part of object
                resultValue += capacity * item.valuePerUnitOfWeight();
                capacity = 0; // knapsack is full
            }
        }
        return resultValue;
    }
}

class Item {
    private int weight;
    private int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public double valuePerUnitOfWeight() {
        return value / (double) weight;
    }
}
