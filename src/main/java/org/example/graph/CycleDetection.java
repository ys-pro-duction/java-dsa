package org.example.graph;

public class CycleDetection {
    public static void main(String[] args) {
        noneDirectedGraph();
        directedGrapth();
    }

    private static void directedGrapth() {
        Graph directedGraph = GraphUse.addDummyDataToDirectedGraphAndGet();
        boolean[] visited = new boolean[directedGraph.getV()];
        boolean[] stack = new boolean[directedGraph.getV()];
        boolean hasCycle = directedGrapthDFSCycleDetect(0, directedGraph, visited, stack);
        for (int i = 0; i < directedGraph.getV(); i++) {
            if (!visited[i]) {
                if (nonDirectedDFSClicleDetect(i, i, directedGraph, new boolean[directedGraph.getV()])) {
                    hasCycle = true;
                    break;
                }
            }
        }
        System.out.println("Directed graph has cycle " + hasCycle);

    }

    private static boolean directedGrapthDFSCycleDetect(int curr, Graph directedGraph, boolean[] visited, boolean[] stack) {
        visited[curr] = true;
        stack[curr] = true;
        for (Graph.Edge edge : directedGraph.getEdge(curr)) {
            if (stack[edge.dest()]) {
                return true;
            }
            if (!visited[edge.dest()]) {
                boolean hasCycle = directedGrapthDFSCycleDetect(edge.dest(), directedGraph, visited, stack);
                if (hasCycle) return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    private static void noneDirectedGraph() {
        Graph noneDirectedGraph = GraphUse.addDummyDataToGraphAndGet();
        boolean[] visited = new boolean[noneDirectedGraph.getV()];
        boolean hasCycle1 = nonDirectedDFSClicleDetect(0, 0, noneDirectedGraph, visited);
        System.out.println("None directed has cycle " + hasCycle1);
    }

    private static boolean nonDirectedDFSClicleDetect(int current, int parent, Graph noneDirectedGraph, boolean[] visited) {
        if (visited[current]) return true;
        visited[current] = true;
        for (int i = 0; i < noneDirectedGraph.getEdge(current).size(); i++) {
            Graph.Edge edge = noneDirectedGraph.getEdge(current).get(i);
            if (edge.dest() != parent) {
                boolean isCycle = nonDirectedDFSClicleDetect(edge.dest(), current, noneDirectedGraph, visited);
                if (isCycle) return true;
            }
        }
        return false;
    }
}
