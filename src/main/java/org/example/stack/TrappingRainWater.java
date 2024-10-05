package org.example.stack;

import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        int water = trappedWater(arr);
        System.out.println("Max water = " + water);
    }

    private static int trappedWater(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                    int popped = arr[stack.pop()];
                    if (stack.isEmpty()) break;
                    int distance = i - stack.peek() - 1;
                    int height = Math.min(arr[stack.peek()], arr[i]) - popped;
                    result += distance * height;
                }
                stack.push(i);
            }
        }
        return result;
    }
}
