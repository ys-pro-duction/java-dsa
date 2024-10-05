package org.example.stack;

import java.util.Stack;

public class PostfixExprationEvaluation {
    public static void main(String[] args) {
//        String a = "854^2+*62^93*/-";
        String a = "753*51^/+32-+";
//        String a = "854^2+*62^93*/-";
        int result = postFixEvaluate(a);
        System.out.println(result);
    }

    public static int postFixEvaluate(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i);
            switch (curr) {
                case '+' -> stack.push(stack.pop() + stack.pop());
                case '-' -> {
                    int first = stack.pop();
                    stack.push(stack.pop() - first);
                }
                case '*' -> stack.push(stack.pop() * stack.pop());
                case '/' -> {
                    int first = stack.pop();
                    stack.push(stack.pop() / first);
                }
                case '^' -> {
                    int first = stack.pop();
                    stack.push((int) Math.pow(stack.pop(), first));
                }
                default -> stack.push(curr - '0');
            }
        }
        return stack.pop();
    }
}
