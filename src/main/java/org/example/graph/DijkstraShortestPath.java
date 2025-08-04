package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DijkstraShortestPath {
    record Edge(int src,int dest,int weight,int distance){}
    public static void main(String[] args) {
        int size = 6;
        ArrayList<Edge>[] graph = new ArrayList[6];
        for (int i = 0; i < graph.length ; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2,0));
        graph[0].add(new Edge(0,2,4,0));
        graph[1].add(new Edge(1,2,1,Integer.MAX_VALUE));
        graph[1].add(new Edge(1,3,7,Integer.MAX_VALUE));
        graph[2].add(new Edge(2,4,3,Integer.MAX_VALUE));
        graph[3].add(new Edge(3,5,1,Integer.MAX_VALUE));
        graph[4].add(new Edge(4,3,2,Integer.MAX_VALUE));
        graph[4].add(new Edge(4,5,5,Integer.MAX_VALUE));
        int[] distances = new int[size];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

        int src = 0;
        int dest = 5;
        findShortestPath(graph, src,dest,distances, "");
    }

    private static void findShortestPath(ArrayList<Edge>[] graph, int src, int dest, int[] distances,String path) {
        if (src == dest){
            System.out.println(Arrays.toString(distances));
            System.out.println(path+dest);
            return;
        }
        ArrayList<Edge> edges = graph[src];
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            if (distances[src]+edge.weight < distances[edge.dest]){
                distances[edge.dest] = distances[src]+edge.weight;
                findShortestPath(graph, edge.dest, dest, distances, path+src);
            }
        }
    }
}
