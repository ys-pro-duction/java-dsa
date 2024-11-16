package org.example.queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BuildInQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.remove();
        }
    }
}
