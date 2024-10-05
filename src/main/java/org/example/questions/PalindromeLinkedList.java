package org.example.questions;

import java.util.Stack;

import static org.example.linkedlist.LInkedListInitalized.Node;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Node node = new Node('a', new Node('b', new Node('b', new Node('a'))));
        System.out.println("is palindrome = " + isPalindrome(node));
    }

    /**
     * This function checks if a given linked list is a palindrome.
     * A palindrome is a sequence that reads the same backward as forward.
     */
    private static boolean isPalindrome(Node node) {
        Node slow = node;
        Stack<Character> stack = new Stack<>();
        while (slow != null) {
            stack.push((char) slow.data);
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != node.data) return false;
            node = node.next;
        }
        return true;
    }
}
