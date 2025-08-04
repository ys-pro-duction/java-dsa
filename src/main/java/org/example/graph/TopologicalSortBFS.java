package org.example.graph;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {
    public static void main(String[] args) {
        int size = 6;
        Graph graph = new Graph(size);
        graph.putVertex(2, 3, 0);
        graph.putVertex(3, 1, 0);
        graph.putVertex(4, 0, 0);
        graph.putVertex(4, 1, 0);
        graph.putVertex(5, 0, 0);
        graph.putVertex(5, 2, 0);
        graph.print();
        topologicalSort(graph);
    }

    public static void topologicalSort(Graph graph) {
        int[] inDegree = new int[graph.getV()];
        for (int i = 0; i < graph.getV(); i++) {
            for (Graph.Edge edge : graph.getEdge(i)) {
                inDegree[edge.dest()]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()){
            int i = queue.remove();
            System.out.print(i+" ");
            for (Graph.Edge e : graph.getEdge(i)) {
                inDegree[e.dest()]--;
                if (inDegree[e.dest()] == 0) queue.add(e.dest());
            }
        }
    }

}
