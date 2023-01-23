package ru.botsner.algorithms;

import java.util.Arrays;
import java.util.Collections;

public class GreedyAlgorithms {

    public static String maxNumberFromDigits(int[] digits) {
        return String.join("", Arrays.stream(digits).boxed()
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .toArray(String[]::new));
    }

    // this method calculates the min number of stops for refueling
    public static int minStops(int[] stations, int capacity) {
        int result = 0;
        int currentStop = 0;

        for (int i = 0; i < stations.length; i++) {
            if (capacity - (stations[i] - stations[currentStop]) < 0) {
                result++;
                currentStop = i - 1;
            }
            if (stations[currentStop + 1] - stations[currentStop] > capacity) {
                return -1;
            }
        }
        return result;
    }
}
