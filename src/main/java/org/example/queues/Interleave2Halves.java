package org.example.queues;

import java.util.LinkedList;
import java.util.Queue;

public class Interleave2Halves {
    //    Interleave 2 Halves of a Queue (even length)
    // before 1,2,3,4,5,6,7,8,9,10
    //  after 1,6,2,7,3,8,4,9,5,10
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);
        interLeaveHalve(queue);
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    private static void interLeaveHalve(Queue<Integer> queue) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = queue.size();
        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(queue.remove());
        }
        while (!firstHalf.isEmpty()) {
            queue.add(firstHalf.remove());
            queue.add(queue.remove());
        }
    }

}
