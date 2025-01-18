package org.example.graph;

import java.util.ArrayList;

public class Graph {
    private int V;
    private int count;
    private ArrayList<Edge> mGraph[];

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
        return mGraph[idx];
    }

    public record Edge(int src, int dest, int weight) {
    }

}
