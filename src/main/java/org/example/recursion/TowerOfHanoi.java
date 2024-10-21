package org.example.recursion;

import java.util.Stack;

public class TowerOfHanoi {
    static Stack<Integer> aa = new Stack<>();
    static Stack<Integer> bb = new Stack<>();
    static Stack<Integer> cc = new Stack<>();
    static int count = 0;

    public static void main(String[] args) throws StackOverflowError {
        TOH(30, 'A', 'B', 'C');
        aa.push(5);
        aa.push(4);
        aa.push(3);
        aa.push(2);
        aa.push(1);
        TOHwithStack(5, aa, bb, cc);
        System.out.println();
        for (; !cc.isEmpty(); cc.pop()) {
            System.out.print(cc.peek()+" ");
        }
        System.out.println();
        System.out.println(count);
    }

    private static void TOH(int n, char a, char b, char c) {
        if (n > 0) {
            count++;
            TOH(n - 1, a, c, b);
//            System.out.printf("Move disk from %c to %c\n", a, c);
            TOH(n - 1, b, a, c);
        }
    }

    private static void TOHwithStack(int n, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
        if (n > 0) {
            TOHwithStack(n - 1, a, c, b);
            c.push(a.pop());
            TOHwithStack(n - 1, b, a, c);
        }
    }
}
