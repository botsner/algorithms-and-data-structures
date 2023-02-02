package ru.botsner.algorithms;

import java.util.*;

public class Dijkstra {

    public static void calculateShortestPathFromSource(Node source) {
        source.setCost(0);

        Set<Node> processed = new HashSet<>();
        Set<Node> unprocessed = new HashSet<>();

        unprocessed.add(source);

        while (unprocessed.size() != 0) {
            Node currentNode = getLowestCostNode(unprocessed);
            unprocessed.remove(currentNode);
            for (Map.Entry<Node, Integer> neighborPair : currentNode.getNeighbors().entrySet()) {
                Node neighbor = neighborPair.getKey();
                int edgeCost = neighborPair.getValue();
                if (!processed.contains(neighbor)) {
                    calculateMinCost(neighbor, edgeCost, currentNode);
                    unprocessed.add(neighbor);
                }
            }
            processed.add(currentNode);
        }
    }

    private static Node getLowestCostNode(Set<Node> nodes) {
        Node lowestCostNode = null;
        int lowestCost = Integer.MAX_VALUE;
        for (Node node : nodes) {
            int cost = node.getCost();
            if (cost < lowestCost) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }

    private static void calculateMinCost(Node evaluationNode, int edgeCost, Node sourceNode) {
        int newCost = sourceNode.getCost() + edgeCost;
        if (newCost < evaluationNode.getCost()) {
            evaluationNode.setCost(newCost);
            List<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}

class Node {
    private String name;
    private int cost = Integer.MAX_VALUE;
    private List<Node> shortestPath = new LinkedList<>();
    private Map<Node, Integer> neighbors = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public void addNeighbor(Node node, int cost) {
        neighbors.put(node, cost);
    }

    public Map<Node, Integer> getNeighbors() {
        return neighbors;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}';
    }
}
