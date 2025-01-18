package org.example.graph;

import java.util.ArrayList;

public class GraphUse {
    public static void main(String[] args) {
        int v = 3;
        Graph graph = addDummyDataToGraphAndGet();
        System.out.println(graph);
    }

    public static Graph addDummyDataToGraphAndGet() {
        Graph graph = new Graph(7);
        ArrayList<Graph.Edge> pointZero = new ArrayList<Graph.Edge>();
        ArrayList<Graph.Edge> pointOne = new ArrayList<Graph.Edge>();
        ArrayList<Graph.Edge> pointTwo = new ArrayList<Graph.Edge>();
        ArrayList<Graph.Edge> pointThree = new ArrayList<Graph.Edge>();
        ArrayList<Graph.Edge> pointFour = new ArrayList<Graph.Edge>();
        ArrayList<Graph.Edge> pointFive = new ArrayList<Graph.Edge>();
        ArrayList<Graph.Edge> pointSix = new ArrayList<Graph.Edge>();
        pointZero.add(new Graph.Edge(0, 1, 2));
        pointZero.add(new Graph.Edge(0, 2, 5));

        pointOne.add(new Graph.Edge(1, 0, 2));
        pointOne.add(new Graph.Edge(1, 3, 5));

        pointTwo.add(new Graph.Edge(2, 0, 2));
        pointTwo.add(new Graph.Edge(2, 4, 5));

        pointThree.add(new Graph.Edge(3, 1, 2));
        pointThree.add(new Graph.Edge(3, 4, 5));
        pointThree.add(new Graph.Edge(3, 5, 5));

        pointFour.add(new Graph.Edge(4, 2, 2));
        pointFour.add(new Graph.Edge(4, 3, 5));
        pointFour.add(new Graph.Edge(4, 5, 5));

        pointFive.add(new Graph.Edge(5, 3, 2));
        pointFive.add(new Graph.Edge(5, 4, 5));
        pointFive.add(new Graph.Edge(5, 6, 5));

        pointSix.add(new Graph.Edge(6, 5, 5));
        graph.setEdges(pointZero);
        graph.setEdges(pointOne);
        graph.setEdges(pointTwo);
        graph.setEdges(pointThree);
        graph.setEdges(pointFour);
        graph.setEdges(pointFive);
        graph.setEdges(pointSix);
        return graph;
    }

    public static Graph addDummyDataToDirectedGraphAndGet() {
        Graph graph = new Graph(4);
        ArrayList<Graph.Edge> pointZero = new ArrayList<>();
        ArrayList<Graph.Edge> pointOne = new ArrayList<>();
        ArrayList<Graph.Edge> pointTwo = new ArrayList<>();
        ArrayList<Graph.Edge> pointThree = new ArrayList<>();
        pointZero.add(new Graph.Edge(0, 2, 5));

        pointOne.add(new Graph.Edge(1, 0, 2));

        pointTwo.add(new Graph.Edge(2, 3, 5));

        pointThree.add(new Graph.Edge(3, 0, 5));

        graph.setEdges(pointZero);
        graph.setEdges(pointOne);
        graph.setEdges(pointTwo);
        graph.setEdges(pointThree);
        return graph;
    }

    public static Graph addDummyDataToDirectedGraphAndGetForDijkstra() {
        Graph graph = new Graph(6);
        ArrayList<Graph.Edge> pointZero = new ArrayList<>();
        ArrayList<Graph.Edge> pointOne = new ArrayList<>();
        ArrayList<Graph.Edge> pointTwo = new ArrayList<>();
        ArrayList<Graph.Edge> pointThree = new ArrayList<>();
        ArrayList<Graph.Edge> pointFour = new ArrayList<>();
        ArrayList<Graph.Edge> pointFive = new ArrayList<>();
        pointZero.add(new Graph.Edge(0, 1, 2));
        pointZero.add(new Graph.Edge(0, 2, 4));

        pointOne.add(new Graph.Edge(1, 2, 1));
        pointOne.add(new Graph.Edge(1, 3, 7));

        pointTwo.add(new Graph.Edge(2, 4, 3));

        pointThree.add(new Graph.Edge(3, 5, 1));

        pointFour.add(new Graph.Edge(4, 3, 2));
        pointFour.add(new Graph.Edge(4, 5, 5));

        pointFive.add(new Graph.Edge(5, 5, 0));

        graph.setEdges(pointZero);
        graph.setEdges(pointOne);
        graph.setEdges(pointTwo);
        graph.setEdges(pointThree);
        graph.setEdges(pointFour);
        graph.setEdges(pointFive);
        return graph;
    }
}
