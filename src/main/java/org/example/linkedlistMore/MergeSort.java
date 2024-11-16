package org.example.linkedlistMore;

import org.example.linkedlist.LInkedListInitalized.Node;

public class MergeSort {
    public static void main(String[] args) {
        Node node6 = new Node(4);
        Node node5 = new Node(88, node6);
        Node node4 = new Node(8, node5);
        Node node3 = new Node(2, node4);
        Node node2 = new Node(6, node3);
        Node node1 = new Node(9, node2);
        Node result = mergeSort(node1);

        for (; result != null; result = result.next) {
            System.out.println(result.data);
        }

    }

    private static Node mergeSort(Node node) {
        if (node.next == null) {
            return node;
        }
        Node slow = getMid(node);
        Node mid = slow.next;
        slow.next = null;
        Node left = mergeSort(node);
        Node right = mergeSort(mid);
        return merge(left, right);
    }

    private static Node getMid(Node node) {
        Node slow = node;
        Node fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node merge(Node left, Node right) {
        Node head = new Node(-1);
        Node tail = head;
        while (left != null && right != null) {
            if (left.data > right.data) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
            tail.next = null;
        }
        if (left != null) {
            tail.next = left;
        }
        if (right != null) {
            tail.next = right;
        }
        return head.next;
    }
}
