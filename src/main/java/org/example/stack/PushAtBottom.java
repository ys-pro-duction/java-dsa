package org.example.stack;


import static org.example.stack.StackWithArrayList.Stack;

public class PushAtBottom {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        pushAtBottom(stack,99);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void pushAtBottom(Stack stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int old = stack.pop();
        pushAtBottom(stack, data);
        stack.push(old);
    }
}
