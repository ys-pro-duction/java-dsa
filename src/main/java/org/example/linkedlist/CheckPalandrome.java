package org.example.linkedlist;

import static org.example.linkedlist.LInkedListInitalized.Node;
import static org.example.linkedlist.LInkedListInitalized.printNode;

public class CheckPalandrome {
    public static void main(String[] args) {
        Node node = new Node(1, new Node(2, new Node(3, new Node(2, new Node(1)))));
        printNode(node);
        System.out.println("is node palindrome = " + isPalindrome(node));
    }

    /**
     * Check if linked list is palindrome
     * O(n)
     *
     * @param head
     */
    private static boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node right = slow;
        right = reverseNodes(right);
        while (right != null) {
            System.out.println(head.data + "-" + right.data);
            if (head.data != right.data) return false;
            head = head.next;
            right = right.next;
        }
        return true;
    }

    private static Node reverseNodes(Node node) {
        Node pre = null;
        Node curr = node;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
