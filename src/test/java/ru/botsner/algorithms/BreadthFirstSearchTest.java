package ru.botsner.algorithms;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstSearchTest {

    @Test
    void breadthFirstSearch() {
        Map<String, String[]> peopleGraph = new HashMap<>();
        peopleGraph.put("you", new String[]{"alice", "bob", "claire"});
        peopleGraph.put("bob", new String[]{"anuj", "peggy"});
        peopleGraph.put("alice", new String[]{"peggy"});
        peopleGraph.put("claire", new String[]{"tom", "jonny"});
        peopleGraph.put("anuj", new String[]{});
        peopleGraph.put("peggy", new String[]{});
        peopleGraph.put("tom", new String[]{});
        peopleGraph.put("jonny", new String[]{});


        assertEquals("tom", BreadthFirstSearch.breadthFirstSearch(peopleGraph, "you"));
        assertEquals("", BreadthFirstSearch.breadthFirstSearch(peopleGraph, "bob"));
    }

    @Test
    void personIsSeller() throws Exception {
        Class<BreadthFirstSearch> bfsClass = BreadthFirstSearch.class;
        Method method = bfsClass.getDeclaredMethod("personIsSeller", String.class);
        method.setAccessible(true);

        assertTrue((boolean) method.invoke(bfsClass, "tom"));
        assertFalse((boolean) method.invoke(bfsClass, "tommy"));
    }
}