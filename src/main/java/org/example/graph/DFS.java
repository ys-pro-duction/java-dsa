package org.example.graph;

public class DFS {
    public static void main(String[] args) {
        Graph graph = GraphUse.addDummyDataToGraphAndGet();
        depthFirstSearch(graph);
    }

    public static void depthFirstSearch(Graph graph) {
        boolean[] visited = new boolean[graph.getV()];
        performDfs(0, graph, visited);
    }

    private static void performDfs(int idx, Graph graph, boolean[] visited) {
        if (visited[idx]) return;
        visited[idx] = true;
        for (Graph.Edge edge : graph.getEdge(idx)) {
            if (visited[edge.dest()]) continue;
            System.out.print("\nSrc " + edge.src() + " Dec " + edge.dest() + " weight " + edge.weight());
            performDfs(edge.dest(), graph, visited);
        }
    }
}
