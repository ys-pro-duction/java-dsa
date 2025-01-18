package org.example.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DijkstraAlgo {
    public static void main(String[] args) {
        Graph graph = GraphUse.addDummyDataToDirectedGraphAndGetForDijkstra();
        boolean[] visited = new boolean[graph.getV()];

        int src = 0;
        int[] distance = new int[graph.getV()];
        for (int i = 0; i < distance.length; i++) {
            if (src != i) distance[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>(visited.length);
        priorityQueue.add(new Pair(src, distance[src]));
        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.remove();
            if (visited[pair.i]) continue;
            visited[pair.i] = true;
            for (Graph.Edge edge : graph.getEdge(pair.i)) {
                if ((distance[edge.src()] + edge.weight()) < distance[edge.dest()]) {
                    distance[edge.dest()] = distance[edge.src()] + edge.weight();
                    priorityQueue.add(new Pair(edge.dest(), distance[edge.dest()]));
                }
            }
        }
        System.out.println(Arrays.toString(distance));
    }

    public static class Pair implements Comparable<Pair> {
        int i;
        int distance;

        public Pair(int i, int distance) {
            this.i = i;
            this.distance = distance;
        }


        @Override
        public int compareTo(Pair o) {
            return this.distance - o.distance;
        }
    }
}
