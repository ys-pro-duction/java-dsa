package org.example.queues;

import java.util.Stack;

public class QueueUsing2Stacks {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.remove();
        }
    }

    static class Queue<T> {
        private final Stack<T> one = new Stack<>();
        private final Stack<T> two = new Stack<>();

        public boolean isEmpty() {
            return one.isEmpty();
        }

        public void add(T data) {
            while (!one.isEmpty()) {
                two.push(one.pop());
            }
            one.push(data);
            while (!two.isEmpty()) {
                one.push(two.pop());
            }
        }

        public T peek() {
            return one.peek();
        }

        public void remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return;
            }
            one.pop();
        }
    }
}
