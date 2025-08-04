package org.example.graph;

import java.util.ArrayList;

public class HasPath {
    public static void main(String[] args) {
        int size = 6;
        ArrayList<Integer>[] graph = new ArrayList[6];
        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(0);
        graph[0].add(3);
        graph[2].add(2);
        graph[2].add(3);
        graph[3].add(3);
        graph[3].add(1);
        graph[4].add(4);
        graph[4].add(0);
        graph[4].add(1);
        graph[5].add(5);
        graph[5].add(0);
        graph[5].add(2);
        int src = 5;
        int dest = 1;
        printAllPathsFromSourceToDes(graph, src, dest, "");
    }

    private static void printAllPathsFromSourceToDes(ArrayList<Integer>[] graph, int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }
        ArrayList<Integer> vertex = graph[src];
        for (int i = 1; i < vertex.size(); i++) {
            printAllPathsFromSourceToDes(graph, vertex.get(i), dest, path + src);
        }
    }
}
