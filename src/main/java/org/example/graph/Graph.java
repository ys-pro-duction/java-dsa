package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private final int V;
    private final ArrayList<Edge>[] mGraph;
    private int count;

    public Graph(int V) {
        this.V = V;
        count = 0;
        mGraph = new ArrayList[this.V];
    }

    public int getV() {
        return V;
    }

    public void setEdges(ArrayList<Edge> edges) {
        mGraph[count++] = edges;

    }

    public void setEdgesAt(int idx, ArrayList<Edge> edges) {
        mGraph[idx] = edges;
    }

    public ArrayList<Edge> getEdge(int idx) {
        return mGraph[idx] != null ? mGraph[idx] : new ArrayList<>();
    }

    public void putVertex(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        if (mGraph[src] == null) {
            ArrayList<Edge> arr = new ArrayList<>();
            mGraph[src] = arr;
        }
        mGraph[src].add(edge);
    }

    public void print() {
        System.out.println(Arrays.toString(mGraph));
    }

    public record Edge(int src, int dest, int weight) {
    }

}
