package ru.botsner.algorithms;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SetCoverProblem {

    // greedy algorithm
    // finds the minimum set of radio stations covering all the necessary states
    public static Set<String> setCoverProblem(Map<String, Set<String>> stations, Set<String> statesNeeded) {
        Set<String> stationsResultSet = new LinkedHashSet<>();

        while (!statesNeeded.isEmpty()) {
            String bestStation = null;
            Set<String> statesCovered = new HashSet<>();
            for (String station : stations.keySet()) {
                Set<String> states = stations.get(station);
                Set<String> covered = new HashSet<>(states);
                covered.retainAll(statesNeeded);
                if (covered.size() > statesCovered.size()) {
                    bestStation = station;
                    statesCovered = covered;
                }
            }
            statesNeeded.removeAll(statesCovered);
            stationsResultSet.add(bestStation);
        }
        return stationsResultSet;
    }
}
