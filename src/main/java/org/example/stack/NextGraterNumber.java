package org.example.stack;

import org.example.Main;

import java.util.Stack;

public class NextGraterNumber {
    public static void main(String[] args) {
        int[] arr = {6,8,0,1,3};
        int[] result = nextGraterNumber(arr);
        Main.printIntArray(result);
    }
    private static int[] nextGraterNumber(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length-1; i >= 0; i--) {
            while (!stack.empty() && arr[stack.peek()] < arr[i]){
                stack.pop();
            }
            if (stack.empty()){
                result[i] = -1;
            }else{
                result[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        return result;
    }
}
