package org.example.queues;

public class CircularQueueWithArray {
    public static void main(String[] args) {
        Queue queue = new Queue(4);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.remove();
        queue.add(5);
        queue.add(6);
        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.remove();
        }
    }

    static class Queue {
        private final int size;
        private final int[] arr;
        private int rear = -1;
        private int head = 0;

        public Queue(int size) {
            this.size = size;
            arr = new int[size];
        }

        public int peek() {
            return arr[head % (size)];
        }

        public void add(int data) {
            if (arr[(rear + 1) % (size)] != 0) {
                System.out.println("Queue is full.");
                return;
            }
            arr[++rear % size] = data;
        }

        public void remove() {
            if (rear == -1 || head > rear) {
                System.out.println("Queue is empty.");
                return;
            }
            arr[head++ % size] = 0;
        }

        public boolean isEmpty() {
            return rear == -1 || head > rear;
        }
    }
}
