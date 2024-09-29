package org.example.stack;

import static org.example.stack.PushAtBottom.pushAtBottom;
import static org.example.stack.StackWithArrayList.*;

public class ReverseStack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        reverseStack(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static void reverseStack(Stack stack) {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        reverseStack(stack);
        pushAtBottom(stack,top);
    }
}
