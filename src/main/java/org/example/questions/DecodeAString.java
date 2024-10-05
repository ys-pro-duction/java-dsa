package org.example.questions;

import java.util.Stack;

public class DecodeAString {
    public static void main(String[] args) {
        String s = "2[yogesh]2[swami]";
        System.out.println("Decoded string = " + decodeString(s));
    }

    private static String decodeString(String s) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<Character> stringStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            String temp = "";
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                while (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                    count = (count * 10) + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                integerStack.push(count);
            } else if (s.charAt(i) == '[') {
                if (s.charAt(i - 1) >= 48 && s.charAt(i - 1) <= 57) stringStack.push(s.charAt(i));
                else {
                    stringStack.push(s.charAt(i));
                    integerStack.push(1);
                }
            } else if (s.charAt(i) == ']') {
                String cuName = "";
                while (!stringStack.isEmpty() && stringStack.peek() != '[') {
                    temp = stringStack.pop() + temp;
                }
                stringStack.pop();
                for (int j = 0; j < integerStack.peek(); j++) {
                    cuName = temp + cuName;
                }
                integerStack.pop();
                for (int j = 0; j < cuName.length(); j++) {
                    stringStack.push(cuName.charAt(j));
                }
            } else {
                stringStack.push(s.charAt(i));
            }
        }
        String result = "";
        while (!stringStack.isEmpty()) {
            result = stringStack.pop() + result;
        }
        return result;
    }
}
