package org.example.graph;

public class HasPath {

    public static void main(String[] args) {
        Graph graph = GraphUse.addDummyDataToGraphAndGet();
        int to = 6;
        boolean isHasPath = hasPath(graph, to);
        System.out.println();
        System.out.println("Path is " + (isHasPath ? "Exist" : "not Exist"));
    }

    private static boolean hasPath(Graph graph, int to) {
        int start = 0;
        boolean[] visited = new boolean[graph.getV()];
        return isPathExist(start, graph, visited, to);
    }

    private static boolean isPathExist(int start, Graph graph, boolean[] visited, int to) {
        if (start == to) {
            return true;
        }
        visited[start] = true;
        for (Graph.Edge edge : graph.getEdge(start)) {
            if (!visited[edge.dest()] && isPathExist(edge.dest(), graph, visited, to)) {
                System.out.print(edge.dest() + ",");
                return true;
            }
        }
        return false;
    }
}
