package org.example.questions;

import java.util.Stack;

public class validPranthesis {
    public static void main(String[] args) {
        String s= "(])";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cuChar = s.charAt(i);
            if (stack.empty()) {
                stack.push(cuChar);
            } else if (cuChar == '(' || cuChar == '{' || cuChar == '[') {
                stack.push(cuChar);
            } else if ((cuChar == ')' && stack.peek() == '(') ||( cuChar == ']' && stack.peek() == '[')
                    || cuChar == '}' && stack.peek() == '{') {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
