package org.example.stack;

import java.util.Stack;

public class DublicatePrantheses {
    public static void main(String[] args) {
        String s = "((a+b)+((a+b+c)))";
        System.out.println(s + " hs dublicate prantheses = " + isDublicatePrintheses(s));
    }

    private static boolean isDublicatePrintheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == ')') {
                if (stack.empty()) {
                    stack.push(currChar);
                    continue;
                }
                int count = 0;
                while (stack.pop() != '(') {
                    count++;
                }
                if (count == 0) return true;
            } else {
                stack.push(currChar);
            }
        }
        return false;
    }
}
