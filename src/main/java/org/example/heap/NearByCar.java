package org.example.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NearByCar {
    public static void main(String[] args) {
        Coardinate c1 = new Coardinate(3, 3);
        Coardinate c2 = new Coardinate(5, -1);
        Coardinate c3 = new Coardinate(-2, 4);

        Coardinate[] coardinates = {c1, c2, c3};
        Heap h = new Heap(coardinates.length);
        Arrays.stream(coardinates).toList().forEach(coardinate -> {
            h.insert((coardinate.x * coardinate.x) + (coardinate.y * coardinate.y));
        });

        // Farest
        nearByCar(h, coardinates);
        // Nearest
        solveWithTute();
    }

    private static void solveWithTute() {
        int[][] co = {{3, 3}, {5, -1}, {-2, 4}};
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < co.length; i++) {
            Point p = new Point(co[i][0],co[i][1]);
            pq.add(p);
        }
        System.out.println("Nearest = "+pq.remove());

    }

    private static void nearByCar(Heap h, Coardinate[] coardinates) {
        while (!h.isEmpty()) {
            int distance = h.remove();
            System.out.println(distance);
            for (Coardinate c : coardinates) {
                if (distance == (c.x * c.x) + (c.y * c.y)) {
                    System.out.println("Nearest = " + c);
                    return;
                }
            }
        }
    }

    record Coardinate(int x, int y) {

    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            distance = (x * x) + (y * y);
        }

        @Override
        public int compareTo(Point o) {
            return distance-o.distance;
        }

        @Override
        public String toString() {
            return "x="+x+", y="+y+", distance="+distance;
        }
    }
}
