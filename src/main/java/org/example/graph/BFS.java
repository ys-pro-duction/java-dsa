package org.example.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        Graph graph = GraphUse.addDummyDataToGraphAndGet();
        breadthFirstSearch(graph);
    }

    public static void breadthFirstSearch(Graph graph) {
        System.out.println();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean visited[] = new boolean[graph.getV()];
        while (!queue.isEmpty()) {
            ArrayList<Graph.Edge> edges = graph.getEdge(queue.remove());
            if (visited[edges.get(0).src()]) continue;
            for (Graph.Edge edge : edges) {
                System.out.print("\n " + edge.src() + " " + edge.dest() + " " + edge.weight());
                queue.add(edge.dest());
            }
            System.out.print("\n++++++++++++++++");
            visited[edges.get(0).src()] = true;
        }
    }
}
