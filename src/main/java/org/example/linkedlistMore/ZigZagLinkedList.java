package org.example.linkedlistMore;

import org.example.linkedlist.LInkedListInitalized.*;

public class ZigZagLinkedList {
    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node6 = new Node(6, node7);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        Node result = zigZaging(node1);

        for (; result != null; result = result.next) {
            System.out.print(result.data + " ");
        }
        System.out.println();
    }

    private static Node zigZaging(Node node) {
        Node first = node;
        Node secondReversed = reversedMid(node);
        Node result = new Node(-1);
        Node tail = result;
        while (secondReversed != null) {
            tail.next = first;
            first = first.next;
            tail.next.next = secondReversed;
            secondReversed = secondReversed.next;
            tail = tail.next.next;
        }
        if (first != null) {
            tail.next = first;
        }
        return result.next;
    }

    private static Node reversedMid(Node node) {
        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node result = slow.next;
        slow.next = null;
        return reversed(result);
    }

    private static Node reversed(Node node) {
        Node curr = node;
        Node next = node.next;
        Node prev = null;
        while (next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }
}
