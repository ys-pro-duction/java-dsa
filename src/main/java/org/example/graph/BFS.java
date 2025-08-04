package org.example.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {

        int size = 7;
        Graph graph = new Graph(size);
        graph.putVertex(0, 1, 0);
        graph.putVertex(0, 2, 0);
        graph.putVertex(1, 0, 0);
        graph.putVertex(1, 3, 0);
        graph.putVertex(3, 1, 0);
        graph.putVertex(3, 4, 0);
        graph.putVertex(3, 5, 0);
        graph.putVertex(5, 3, 0);
        graph.putVertex(5, 4, 0);
        graph.putVertex(5, 6, 0);
        graph.putVertex(6, 5, 0);
        graph.putVertex(2, 0, 0);
        graph.putVertex(2, 4, 0);
        graph.putVertex(4, 2, 0);
        graph.putVertex(4, 3, 0);
        graph.putVertex(4, 5, 0);
        graph.print();
        printBSF(graph);
    }

    public static void printBSF(Graph graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(-1);

        boolean[] visited = new boolean[graph.getV()];

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int src = queue.remove();
            if (src == -1) {
                System.out.println();
                if (!queue.isEmpty()) queue.add(-1);
                continue;
            }
            if (!visited[src]) {
                visited[src] = true;
                System.out.print(src + " ");
                for (Graph.Edge e : graph.getEdge(src)) {
//                if (!visited[e.dest()])
                    queue.add(e.dest());
                }
            }
        }
        System.out.println(count);

    }
}
