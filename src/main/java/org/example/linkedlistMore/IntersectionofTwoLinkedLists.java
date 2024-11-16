package org.example.linkedlistMore;

import org.example.linkedlist.LInkedListInitalized.Node;

public class IntersectionofTwoLinkedLists {
    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node6 = new Node(6, node7);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);

        Node node3 = new Node(3, node6);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        /////////////////////////
        // its a Y shape linked list we find intersaction of it
        // so connect one end to last to make it cyclic
        node7.next = node1;
        findIntersaction(node4);
    }

    private static void findIntersaction(Node node) {
        Node slow = node.next;
        Node fast = node;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        System.out.println(slow.data);
    }
}
