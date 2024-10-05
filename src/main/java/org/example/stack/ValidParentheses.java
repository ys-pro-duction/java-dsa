package org.example.stack;

import java.util.Stack;

class ValidParentheses {
    public static void main(String[] args) {
        String s = "()({[]})()";
        System.out.println(s + " has valid parantheses = " + isParentheses(s));
    }

    private static boolean isParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cuchar = s.charAt(i);
            if (cuchar == '(' || cuchar == '[' || cuchar == '{') {
                stack.push(cuchar);
            } else {
                if (stack.empty()) {
                    stack.push(cuchar);
                } else {
                    if ((stack.peek() == '(' && cuchar == ')') || (stack.peek() == '[' && cuchar == ']') || (stack.peek() == '{' && cuchar == '}')) {
                        stack.pop();
                    } else return false;
                }
            }
        }
        return stack.empty();
    }
}
