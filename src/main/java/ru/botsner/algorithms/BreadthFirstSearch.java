package ru.botsner.algorithms;

import java.util.*;

public class BreadthFirstSearch {

    // returns sellers name if seller is found
    public static String breadthFirstSearch(Map<String, String[]> graph, String start) {
        Deque<String> searchQueue = new ArrayDeque<>();
        Arrays.stream(graph.get(start)).forEach(searchQueue::offer);
        List<String> searched = new ArrayList<>();

        while (!searchQueue.isEmpty()) {
            String person = searchQueue.poll();
            if (!searched.contains(person)) {
                if (personIsSeller(person)) {
                    return person;
                } else {
                    Arrays.stream(graph.get(person)).forEach(searchQueue::offer);
                    searched.add(person);
                }
            }
        }
        return "";
    }

    // returns true if name ends with m
    private static boolean personIsSeller(String name) {
        return name.endsWith("m");
    }
}
