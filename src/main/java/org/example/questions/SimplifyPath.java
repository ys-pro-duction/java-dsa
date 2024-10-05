package org.example.questions;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
//        String s = "/a/./b/../../../c/";
//        String s = "/a/./b/../../c/";
//        String s = "/a/./b/../c/";
        String s = "/apnacollege/../hi/";
        System.out.println(simplifyPathTutorApproch(s));
        System.out.println(simplify(s));
//        System.out.println(simplifyPath(s));
    }

    private static String simplifyPathTutorApproch(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String dir = "";
            while (s.charAt(i) == '/') {
                i++;
            }
            while (s.charAt(i) != '/') {
                dir += s.charAt(i);
                i++;
            }
            if (dir.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (dir.equals(".")) {
                continue;
            } else {
                stack.push(dir);
//                stack.push("/");
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }
        return result;
    }

    static String simplify(String A) {
        Stack<String> st = new Stack<String>();
        String res = "";
        res += "/";
        int len_A = A.length();
        for (int i = 0; i < len_A; i++) {
            String dir = "";
            while (i < len_A && A.charAt(i) == '/') i++;
            while (i < len_A && A.charAt(i) != '/') {
                dir += A.charAt(i);
                i++;
            }
            if (dir.equals("..")) {
                if (!st.empty()) st.pop();
            } else if (dir.equals(".")) continue;
            else if (dir.length() != 0) st.push(dir);
        }
        Stack<String> st1 = new Stack<String>();
        while (!st.empty()) {
            st1.push(st.pop());
        }
        while (!st1.empty()) {
            if (st1.size() != 1) res += (st1.pop() + "/");
            else res += st1.pop();
        }
        return res;
    }

    private static String simplifyPath(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder tmp = new StringBuilder();
        boolean dot = false;
        for (int index = 0; index < s.length(); index++) {
            char cuChar = s.charAt(index);
            if (cuChar == '/' || cuChar == '.') {
                if (tmp.length() > 0) {
                    stack.push(tmp.toString());
                    tmp = new StringBuilder();
                }
                if (cuChar == '.') {
                    if (dot) {
                        if (stack.peek().equals("/")) {
                            stack.pop();
                            stack.pop();
                        } else stack.pop();
                        dot = false;
                    } else {
                        dot = true;
                    }
                } else {
                    if (stack.isEmpty()) {
                        stack.push(String.valueOf('/'));
                    } else if (!dot && !stack.peek().equals("/")) stack.push(String.valueOf('/'));
                }
            } else {
                tmp.append(cuChar);
            }
        }
        if (stack.peek().equals("/")) stack.pop();
        if (stack.isEmpty()) stack.push("/");
        if (tmp.length() > 0) {
            stack.push(tmp.toString());
            tmp = new StringBuilder();
        }
        while (!stack.isEmpty()) {
            tmp.insert(0, stack.pop());
        }
        return tmp.toString();
    }
}
