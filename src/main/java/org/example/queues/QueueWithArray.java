package org.example.queues;

public class QueueWithArray {
    public static void main(String[] args) {
        Queue queue = new Queue(4);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.remove();
        queue.add(5);

        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.remove();
        }
    }

    static class Queue {
        private final int size;
        private final int[] arr;
        private int rear = -1;

        public Queue(int size) {
            this.size = size;
            arr = new int[size];
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        public int peek() {
            return arr[0];
        }

        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full.");
                return;
            }
            arr[++rear] = data;
        }

        public void remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return;
            }
            for (int i = 1; i <= rear; i++) {
                arr[i - 1] = arr[i];
            }
            rear--;
        }
    }
}
