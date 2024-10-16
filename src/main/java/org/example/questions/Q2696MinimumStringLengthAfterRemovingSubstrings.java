package org.example.questions;

import java.util.Stack;

public class Q2696MinimumStringLengthAfterRemovingSubstrings {
    public static void main(String[] args) {
        String s = "ABFCACDB";
//        String s = "ACBBD";
        System.out.println(minLength(s));
    }

    public static int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == 'A' && c == 'B' || stack.peek() == 'C' && c == 'D') {
                    stack.pop();
                } else stack.push(c);
            }
        }
        int count = 0;
        while (!stack.isEmpty()){
            stack.pop();
            count++;
        }
        return count;
    }
}
