package org.example.linkedlistMore;

public class DublyLL {
    public static Node head;
    public static Node tail;
    public static int size;

    public static void main(String[] args) {
        DublyLL dlist = new DublyLL();
        dlist.addFirst(1);
        dlist.addFirst(2);
        dlist.addFirst(3);
        dlist.removeFirst();
        dlist.addLast(4);
        dlist.addLast(5);
        dlist.removeLast();
        Node result = head;
        for (; result != null; result = result.next) {
            System.out.print(result.data + " ");
        }
        System.out.println();
        System.out.println(size);
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        size++;
        if (head == null) {
            head = tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    public Node removeFirst() {
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        return tmp;
    }

    public Node removeLast() {
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        return tmp;
    }

    public void addLast(int data) {
        Node node = new Node(data);
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }

    public static class Node {
        Node prev;
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
