package org.example.heap;

import java.util.PriorityQueue;

public class ConnectNRopes {
    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        int cost = connectNRope(ropes);
        System.out.println("Cost of rope to connect = " + cost);
        System.out.println("Tute approch Cost of rope to connect = " + tuteApproch(ropes));
    }

    /**
     * Given are N ropes of different lengths, the task is to connect these ropes into one rope with
     * minimum cost, such that the cost to connect two ropes is equal to the sum of their lengths.
     * ropes = (4, 3, 2, 6)
     * ans = 29
     */
    private static int connectNRope(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        int cost = 0;
        int size = pq.remove();
        while (!pq.isEmpty()) {
            size += pq.remove();
            cost += size;
        }
        return cost;
    }

    private static int tuteApproch(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int size = pq.remove() + pq.remove();
            cost += size;
            pq.add(size);
        }
        return cost;
    }
}

