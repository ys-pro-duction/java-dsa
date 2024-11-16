package org.example.linkedlistMore;

import org.example.linkedlist.LInkedListInitalized.Node;

import java.util.LinkedList;

public class DetectAndRemoveCycle {
    public static void main(String[] args) {
        Node node2 = new Node(2);
        Node node5 = new Node(5, node2);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        node2.next = node3;
        Node node1 = new Node(1, node2);

        detectAndRemoveCycle(node1);

        for (; node1 != null; node1 = node1.next) {
            System.out.println(node1.data);
        }
    }

    private static void detectAndRemoveCycle(Node node) {
        Node slow = node;
        Node fast = node;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                fast = fast.next;
            } else fast = fast.next.next;
            if (slow == fast) {
                removeCycle(node, fast);
                return;
            }
        }
    }

    private static void removeCycle(Node slow, Node fast) {
        Node previus = null;
        while (slow != fast) {
            previus = fast;
            slow = slow.next;
            fast = fast.next;
        }
        previus.next = null;
    }
}
