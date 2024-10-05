package org.example.stack;

import org.example.Main;

import java.util.Stack;

public class MaxAreaInHistogram {
    /**
     * This class contains methods to find the maximum area of a rectangle that can be formed
     * with a histogram's bars. The histogram is represented as an array of integers.
     */
    public static void main(String[] args) {
        int[] histogram = {2, 1, 5, 6, 2, 3};
        int[] smallerLeft = new int[histogram.length];
        int[] smallerRight = new int[histogram.length];
        nextSmallerL(histogram, smallerLeft);
        nextSmallerR(histogram, smallerRight);
        int[] areas = new int[histogram.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < histogram.length; i++) {
            int height = histogram[i];
            int width = smallerRight[i] - smallerLeft[i] - 1;
            int area = height*width;
            max = Math.max(max,area);
            areas[i] = area;

        }
        Main.printIntArray(smallerLeft);
        Main.printIntArray(smallerRight);
        Main.printIntArray(areas);
        System.out.println("\nMaximum area rectangle = "+max);

    }

    public static void nextSmallerL(int[] arr, int[] result) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else result[i] = stack.peek();
            stack.push(i);
        }
    }

    public static void nextSmallerR(int[] arr, int[] result) {
//        {2, 1, 5, 6, 2, 3}
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = arr.length;
            } else result[i] = stack.peek();
            stack.push(i);
        }
    }
}
