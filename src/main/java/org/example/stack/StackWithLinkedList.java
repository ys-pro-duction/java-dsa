package org.example.stack;
import static org.example.linkedlist.LInkedListInitalized.Node;

class StackWithLinkedList {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static class Stack {
        Node node = null;

        public void push(int data) {
            if (isEmpty()){
                node = new Node(data);
                return;
            }
            node = new Node(data,node);
        }

        public boolean isEmpty() {
            return node == null;
        }

        public int pop() {
            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }
            int value = node.data;
            node = node.next;
            return value;
        }

        public int peek() {
            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return node.data;
        }
    }
}