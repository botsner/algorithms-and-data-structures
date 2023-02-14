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

    // approximate greedy algorithm
    // items cannot be divided
    public static double discreteKnapsackProblemApprox(final Item[] items, int capacity) {
        Arrays.sort(items, Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed());

        double resultValue = 0;

        for (Item item : items) {
            if (capacity == 0) {
                break;
            }
            if (capacity >= item.getWeight()) {
                // take only whole object
                resultValue += item.getValue();
                capacity -= item.getWeight();
            }
        }
        return resultValue;
    }

    // dynamic programming
    // items cannot be divided
    public static double discreteKnapsackProblemDynamic(final Item[] items, final int capacity) {
        int[][] matrix = new int[items.length + 1][capacity + 1];

        for (int i = 1; i < matrix.length; i++) {
            Item item = items[i - 1];
            for (int j = 1; j < matrix[i].length; j++) {
                if (item.getWeight() > j) {
                    matrix[i][j] = matrix[i - 1][j];
                    continue;
                }
                int p1 = matrix[i - 1][j];
                int p2 = item.getValue() + matrix[i - 1][j - item.getWeight()];
                matrix[i][j] = Math.max(p1, p2);
            }
        }
        return getMaxValueFromMatrix(matrix);
    }

    private static double getMaxValueFromMatrix(int[][] matrix) {
        double maxValue = 0;
        for (int i = matrix[0].length - 1; i >= 0; i--) {
            maxValue = matrix[matrix.length - 1][i];
            if (maxValue != 0) {
                return maxValue;
            }
        }
        return maxValue;
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
