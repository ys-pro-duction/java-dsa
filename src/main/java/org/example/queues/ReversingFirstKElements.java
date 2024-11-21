package org.example.queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ReversingFirstKElements {
    /*Reversing the first K elements of a Queue
        We have an integer k and a queue of integers, we need to reverse the order of the first k
        elements of the queue, leaving the other elements in the same relative order.*/
    public static void main(String[] args) {
        int[] element = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        Deque<Integer> queue = new LinkedList<>();
        for (int i : element) queue.add(i);
        int K = 5;

//        reverseFirstKwithQueue(queue, K);
        reverseFirstKwithDoublyQueue(queue, K);

        while (!queue.isEmpty()) System.out.print(queue.remove() + ", ");
    }

    private static void reverseFirstKwithDoublyQueue(Deque<Integer> queue, int k) {
        Queue<Integer> tmp = new LinkedList<>();
        for (int i = 0; i < k; i++) tmp.add(queue.remove());
        while (!tmp.isEmpty()) queue.addFirst(tmp.remove());
    }

    private static void reverseFirstKwithQueue(Queue<Integer> queue, int k) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> reversed = new LinkedList<>();
        for (int i = 0; i < k; i++) queue1.add(queue.remove());
        for (int i = 0; i < k; i++) {
            for (int j = 0; 0 < k - i - j - 1; j++) {
                queue1.add(queue1.remove());
            }
            reversed.add(queue1.remove());
        }
        while (!queue.isEmpty()) reversed.add(queue.remove());
        while (!reversed.isEmpty()) queue.add(reversed.remove());
    }
}
