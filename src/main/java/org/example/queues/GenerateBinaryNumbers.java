package org.example.queues;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        int n = 1;
        generateBinaryNumbers(10);
    }

    private static void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        while (n-- > 0) {
            String s1 = queue.remove();
            System.out.print(s1);
            queue.add(s1 + "0");
            queue.add(s1 + "1");
            System.out.print(" ");
        }

        System.out.println();
    }
}
