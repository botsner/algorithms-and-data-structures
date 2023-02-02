package ru.botsner.algorithms;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class DijkstraTest {

    @Test
    void calculateShortestPathFromSource() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addNeighbor(nodeB, 10);
        nodeA.addNeighbor(nodeC, 15);

        nodeB.addNeighbor(nodeD, 12);
        nodeB.addNeighbor(nodeF, 15);

        nodeC.addNeighbor(nodeE, 10);

        nodeD.addNeighbor(nodeE, 2);
        nodeD.addNeighbor(nodeF, 1);

        nodeF.addNeighbor(nodeE, 5);

        Dijkstra.calculateShortestPathFromSource(nodeA);

        List<Node> shortestPathNodeE = new LinkedList<>();
        shortestPathNodeE.add(nodeA);
        shortestPathNodeE.add(nodeB);
        shortestPathNodeE.add(nodeD);

        List<Node> shortestPathNodeC = new LinkedList<>();
        shortestPathNodeC.add(nodeA);

        assertIterableEquals(shortestPathNodeE, nodeE.getShortestPath());
        assertIterableEquals(shortestPathNodeC, nodeC.getShortestPath());

        assertEquals(0, nodeA.getCost());
        assertEquals(10, nodeB.getCost());
        assertEquals(15, nodeC.getCost());
        assertEquals(22, nodeD.getCost());
        assertEquals(24, nodeE.getCost());
        assertEquals(23, nodeF.getCost());
    }
}