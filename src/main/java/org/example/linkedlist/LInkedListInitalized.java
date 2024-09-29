package org.example.linkedlist;

public class LInkedListInitalized {
    private static Node head;
    private static Node tail;
    private static int size;

    public static void main(String[] args) {
        addHead(40);
        addHead(30);
        addHead(10);
        addTail(50);
        addNode(20, 1);
        addNode(60, 5);
        printNode(head);
        removeHead();
        printNode(head);
        removeEnd();
        printNode(head);
        int key = 30;
        System.out.println(key + " found at = " + searchKeyGetPositionI(key));
        System.out.println(key + " found at = " + searchKeyGetPositionR(key, head));
        reverseNode();
        printNode(head);
        removeNthNodeEnd(5);
        printNode(head);
        System.out.println("size = " + size);
    }

    private static void removeNthNodeEnd(int n){
        int sz = 0;
        Node tmp = head;
        while (tmp != null){
            tmp = tmp.next;
            sz++;
        }
        if (sz < n) {
            System.out.println("Linkded list size is "+sz+" but given n is "+n);
            return;
        }
        if (size == n){
            head = head.next;
            return;
        }

        int removeNth = sz - n;
        tmp = head;
        for (int i = 1; i < removeNth; i++) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        size--;
    }
    private static void reverseNode() {
        Node pre = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        head = pre;
    }

    private static int searchKeyGetPositionR(int key, Node node) { // Recursive mathod
        if (node == null) return -1;
        if (node.data == key) return 0;
        int value = searchKeyGetPositionR(key, node.next);
        return (value == -1) ? value : ++value;
    }

    private static int searchKeyGetPositionI(int key) { // Iterative mathod
        int position = 0;
        for (Node i = head; i != null; i = i.next) {
            if (key == i.data) return position;
            position++;
        }
        return -1;
    }

    private static int removeEnd() {
        if (size == 0) {
            System.out.println("Linkded list is empty");
            return Integer.MIN_VALUE;
        }
        size--;
        if (size == 1) {
            int data = head.data;
            head = tail = null;
            return data;
        }
        Node preLast = head;
        for (int i = 0; i < size - 1; i++) {
            preLast = preLast.next;
        }
        int value = preLast.data;
        preLast.next = null;
        tail = preLast;
        return value;
    }

    private static int removeHead() {
        if (size == 0) {
            System.out.println("Linkded list is empty");
            return Integer.MIN_VALUE;
        }
        size--;
        if (size == 1) {
            int data = head.data;
            head = tail = null;
            return data;
        }
        int value = head.data;
        head = head.next;
        return value;
    }

    private static void addNode(int data, int position) {
        if (position == 0) {
            addHead(data);
            return;
        }
        Node preNode = head;
        size++;
        for (int i = 0; i < position - 1; i++) {
            preNode = preNode.next;
        }
        Node nextNode = preNode.next;
        preNode.next = new Node(data, nextNode);
    }

    public static void printNode(Node node) {
        Node tNode = node;
        while (tNode != null) {
            System.out.print(tNode.data + "->");
            tNode = tNode.next;
        }
        System.out.print(tNode + "\n");
    }

    /**
     * Adds a new node with the given data at the head of the linked list.
     * If the list is empty, the new node becomes both the head and tail.
     */
    public static void addHead(int data) {
        head = new Node(data, head);
        size++;
        if (tail == null) {
            tail = head;
        }
    }

    /**
     * Adds a new node with the given data at the tail of the linked list.
     * If the list is empty, the new node becomes both the head and tail.
     */
    public static void addTail(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = head = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }


    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
