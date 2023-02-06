package ru.botsner.algorithms;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SetCoverProblemTest {

    @Test
    void setCoverProblem() {
        // states that need to be covered
        Set<String> statesNeeded = new HashSet<>(Set.of("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));

        // kay - station name, value - abbreviated designations of states
        Map<String, Set<String>> stations = new LinkedHashMap<>() {{
            put("kone", Set.of("id", "nv", "ut"));
            put("ktwo", Set.of("wa", "id", "mt"));
            put("kthree", Set.of("or", "nv", "ca"));
            put("kfour", Set.of("nv", "ut"));
            put("kfive", Set.of("ca", "az"));
        }};

        Set<String> expected = new LinkedHashSet<>(Arrays.asList("kone", "ktwo", "kthree", "kfive"));
        Set<String> actual = SetCoverProblem.setCoverProblem(stations, statesNeeded);

        assertIterableEquals(expected, actual);
    }
}