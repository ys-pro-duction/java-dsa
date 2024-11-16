package org.example.queues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queues {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            System.out.println(stack.pop());
        }
    }

    static class Stack {
        private final Queue<Integer> one = new LinkedList<>();
        private final Queue<Integer> two = new LinkedList<>();

        public boolean isEmpty() {
            return one.isEmpty() && two.isEmpty();
        }

        public void push(int data) {
            if (!two.isEmpty()) two.add(data);
            else one.add(data);
        }

        public int pop() {
            while (!one.isEmpty()) {
                int end = one.remove();
                if (one.isEmpty()) {
                    return end;
                }
                two.add(end);
            }
            while (!two.isEmpty()) {
                int end = two.remove();
                if (two.isEmpty()) {
                    return end;
                }
                one.add(end);
            }
            return -1;
        }

        public int peek() {
            while (!one.isEmpty()) {
                int end = one.remove();
                two.add(end);
                if (one.isEmpty()) {
                    return end;
                }
            }
            while (!two.isEmpty()) {
                int end = two.remove();
                one.add(end);
                if (two.isEmpty()) {
                    return end;
                }
            }
            return -1;
        }
    }
}
