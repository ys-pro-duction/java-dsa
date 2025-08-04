package org.example.graph;

public class DFS {
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
        boolean[] visited = new boolean[size];
        printDFS(graph, visited, 0);
    }

    private static void printDFS(Graph graph, boolean[] visited, int i) {
        visited[i] = true;
        System.out.print(i + " ");
        for (Graph.Edge e : graph.getEdge(i)) {
            if (!visited[e.dest()]) printDFS(graph, visited, e.dest());
        }
    }
}
