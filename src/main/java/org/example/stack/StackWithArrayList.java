package org.example.stack;

import java.util.ArrayList;

class StackWithArrayList {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
        System.out.println(stack.pop());
    }

    public static class Stack {
        ArrayList<Integer> arrayList = new ArrayList<>();

        public void push(int data) {
            arrayList.add(data);
        }

        public boolean isEmpty() {
            return arrayList.size() == 0;
        }

        public int pop() {
            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }
            int value = arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
            return value;
        }

        public int peek() {
            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return arrayList.get(arrayList.size() - 1);
        }
    }
}