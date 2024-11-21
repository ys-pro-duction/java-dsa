package org.example.queues;

import java.util.PriorityQueue;

public class ConnectNRopes {
    /*Connect n ropes with minimum cost
      Given are N ropes of different lengths, the task is to connect these ropes into one rope with
      minimum cost, such that the cost to connect two ropes is equal to the sum of their lengths*/
    public static void main(String[] args) {
        int arr[] = {4, 2, 3, 5};
        int minimumCost = getMinimumCost(arr);
        System.out.println("Min cost = " + minimumCost);
    }

    private static int getMinimumCost(int[] arr) {
        int minCost = 0;
        int current = minCost;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : arr) {
            priorityQueue.add(i);
        }
        System.out.println(priorityQueue);
        current += priorityQueue.remove();
        while (!priorityQueue.isEmpty()) {
            System.out.println("Element = " + priorityQueue.peek());
            current += priorityQueue.remove();
            minCost += current;
        }
        return minCost;
    }

}
