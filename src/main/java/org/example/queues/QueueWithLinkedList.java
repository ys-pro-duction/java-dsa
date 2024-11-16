package org.example.queues;

import org.example.linkedlist.LInkedListInitalized.Node;

public class QueueWithLinkedList {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.remove();
        }
    }

    static class Queue {
        Node head;
        Node tail;

        public Queue() {

        }

        public boolean isEmpty() {
            return head == null;
        }

        public int peek() {
            return head.data;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        public void remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
            } else if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
        }
    }
}
