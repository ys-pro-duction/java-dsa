package org.example.linkedlistMore;

import org.example.linkedlist.LInkedListInitalized.Node;

public class OddEvenLinkedList {
    /**
     * We have a Linked List of integers, write a function to modify the linked list such that all even
     * numbers appear before all the odd numbers in the modified linked list. Also, keep the order of
     * even and odd numbers same.
     */
    public static void main(String[] args) {
        Node node7 = new Node(6);
        Node node6 = new Node(1, node7);
        Node node5 = new Node(4, node6);
        Node node4 = new Node(5, node5);
        Node node3 = new Node(10, node4);
        Node node2 = new Node(12, node3);
        Node node1 = new Node(8, node2);
        moveOdd(node1);
        for (; node1 != null; node1 = node1.next) {
            System.out.print(node1.data + "->");
        }
        System.out.println();
    }

    private static void moveOdd(Node node) {
        Node evenHeadPre = null;
        Node oddHeadPre = null;
        Node oddHead = null;
        Node oddTail = null;
        while (node != null) {
            if (node.data % 2 == 1) {
                if (oddHead == null) {
                    oddHead = node;
                }
                oddTail = node;
            } else {
                if (oddHead != null) {
                    Node noddNex = oddTail.next;
                    Node evenNext = node.next;
                    oddHeadPre.next = node;
                    oddTail.next = evenNext;
                    node.next = oddHead;
                }
            }
            if (oddHead == null) oddHeadPre = node;
            evenHeadPre = node;
            node = node.next;
        }
    }

}
