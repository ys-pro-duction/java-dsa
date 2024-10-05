package org.example.stack;

import java.util.HashMap;
import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {
        String s = "7+5*3/5^1+(3-2)"; //75351^/*32-++
//        String s = "8*(5^4+2)-6^2/(9*3)";//854^2+*62^93*/-
        prefixToPostfix(s);
    }

    private static void prefixToPostfix(String prefixExpression) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> operatorLevel = new HashMap<>();
        operatorLevel.put('+', 0);
        operatorLevel.put('-', 0);
        operatorLevel.put('*', 1);
        operatorLevel.put('/', 1);
        operatorLevel.put('^', 2);
        for (int i = 0; i < prefixExpression.length(); i++) {
            char curr = prefixExpression.charAt(i);
            if (curr >= 48 && curr <= 57) {
                System.out.print(curr);
            } else if (curr == '(') {
                stack.push(curr);
            } else if (curr == ')') {
                char cuChar;
                while ((cuChar = stack.pop()) != '(') {
                    System.out.print(cuChar);
                }
            } else {
                while (!stack.isEmpty() && operatorLevel.containsKey(stack.peek()) && operatorLevel.get(curr) <= operatorLevel.get(stack.peek())) {
                    System.out.print(stack.pop());
                }
                stack.push(curr);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
