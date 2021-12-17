package com.IT2650;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Graph {
    public Node[] vertex;
    public ArrayList<Integer[]> adjacencyList;
    public boolean targetFound;
    ArrayList<Integer> dfsVisited = new ArrayList<>();
    ArrayList<Integer> bfsVisited = new ArrayList<>();
    int dfsCycleCount, bfsCycleCount, max, numberOfVertices;


    public Graph(int n) {
        targetFound = false;
        vertex = new Node[n];
        max = n;
        numberOfVertices = 0;
        graphPopulator(n);
    }

    public boolean insertVertex(int destinationIndex, Node newNode) {
        if (destinationIndex >= max) return false;
        vertex[destinationIndex] = newNode.deepCopy();
        numberOfVertices++;
        return true;
    }

    public void graphPopulator(int size) {
        int min = 1, max = 100000;
        for (int i = 0; i < size; i++) {
            int value = ThreadLocalRandom.current().nextInt(min, max + 1);
            Node node = new Node(value);
            insertVertex(i, node);
        }
        edgeGenerator();
        adjacencyPopulator(vertex);
    }

    public void edgeGenerator() {
        for (int i = 0; i < numberOfVertices; i++) {
            int numberOfEdges = ThreadLocalRandom.current().nextInt(1, 2);
            for (int j = 0; j < numberOfEdges; j++) {
                int edge = ThreadLocalRandom.current().nextInt(0, numberOfVertices);
                if (edge != i && vertex[i].edgeChecker(edge)) {
                    vertex[i].setEdges(edge);
                    vertex[edge].setEdges(i);
                }
            }
        }
    }

    public void adjacencyPopulator(Node[] g) {
        adjacencyList = new ArrayList<>(g.length);
        int i = 0;
        for (Node node : g) {
            adjacencyList.add(i, node.getAllEdges().toArray(new Integer[0]));
            i++;
        }
    }

    public void showAll() {
        System.out.println("Node List: \n");
        for (int i = 0; i < vertex.length; i++) {
            System.out.println("Node # " + i + ": " + vertex[i].getValue());
            System.out.println("Edges: " + vertex[i].getAllEdges());
        }
    }

    public void breadth(int start, int target){
        System.out.println("\nStart node:  " + start);
        System.out.println("Target node: " + target);
        bfs(start, target);
        if (!targetFound) {
            System.out.println("Nodes not connected.");
        }
    }

    public void bfs(int firstVertex, int target) {
        int currentlyVisiting;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            if (vertex[i] != null) {
                vertex[i].setBfsVisited(false);
            }
        }
        vertex[firstVertex].setBfsVisited(true);
        queue.add(firstVertex);
        bfsVisited.add(firstVertex);
        while (!queue.isEmpty()) {
            currentlyVisiting = queue.remove();
            for (int adjacentNodeIndex = 0; adjacentNodeIndex < adjacencyList.get(currentlyVisiting).length; adjacentNodeIndex++) {
                bfsCycleCount++;
                if (!vertex[adjacencyList.get(currentlyVisiting)[adjacentNodeIndex]].getBfsVisited()) {
                    if(adjacencyList.get(currentlyVisiting)[adjacentNodeIndex] == target){
                        targetFound = true;
                        vertex[currentlyVisiting].setBfsVisited(true);
                        bfsVisited.add(adjacencyList.get(currentlyVisiting)[adjacentNodeIndex]);
                        System.out.println("Found BFS path: " + bfsVisited);
                        System.out.println("Path Length: " + bfsVisited.size());
                        System.out.println("Number of examinations: " + bfsCycleCount);
                        break;
                    }
                    queue.add(adjacencyList.get(currentlyVisiting)[adjacentNodeIndex]);
                    vertex[adjacencyList.get(currentlyVisiting)[adjacentNodeIndex]].setBfsVisited(true);
                    bfsVisited.add(adjacencyList.get(currentlyVisiting)[adjacentNodeIndex]);
                }
            }
        }
    }

    public void depth(int start, int target){
        System.out.println("\nStart node:  " + start);
        System.out.println("Target node: " + target);
        dfs(start, target);
        if(!targetFound){
            System.out.println("Nodes not connected.");
        }
    }

    public void dfs(int currentlyVisiting, int target) {
        dfsCycleCount++;
        if(currentlyVisiting  == target){
            targetFound = true;
            dfsVisited.add(currentlyVisiting);
            vertex[currentlyVisiting].setDfsVisited(true);
            System.out.println("Found DFS path: " + dfsVisited);
            System.out.println("Path Length: " + dfsVisited.size());
            System.out.println("Number of examinations: " + dfsCycleCount);
        }
        if (!vertex[currentlyVisiting].getDfsVisited()) {
            dfsVisited.add(currentlyVisiting);
            vertex[currentlyVisiting].setDfsVisited(true);
            Integer[] adjacentNode = adjacencyList.get(currentlyVisiting);
            for (int j : adjacentNode) {
                dfs(j, target);
            }
        }
    }
}
