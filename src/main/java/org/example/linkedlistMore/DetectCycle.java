package org.example.linkedlistMore;

import org.example.linkedlist.LInkedListInitalized.Node;

public class DetectCycle {
    public static void main(String[] args) {
//        Node node1 = new Node(1, null);
//        Node node2 = new Node(2, node1);
//        Node node3 = new Node(3, node2);
//        Node node4 = new Node(4, node3);
//        Node node5 = new Node(5, new Node(6, node2));
        Node node2 = new Node(3);
        Node node5 = new Node(5, node2);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        node2.next = node3;
        Node node1 = new Node(1, node2);
        System.out.println("is cycler in node = " + isCycle(node1));
    }

    private static boolean isCycle(Node node) {
        Node slow = node;
        Node fast = node;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else fast = fast.next;
            if (slow == fast) {
                System.out.println("slow = " + slow.data);
                System.out.println("fast = " + fast.data);
                return true;
            }
        }
        return false;
    }
}
