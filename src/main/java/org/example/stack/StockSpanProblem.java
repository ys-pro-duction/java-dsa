package org.example.stack;

import org.example.Main;

import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] stocks = {100, 80, 60, 70, 60, 85, 100};
        int[] spans = stockSpanFind(stocks);
        Main.printIntArray(spans);
    }

    private static int[] stockSpanFind(int[] stock) {
        int[] spansOfStock = new int[stock.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < stock.length; i++) {
            while (!stack.empty() && stock[stack.peek()] <= stock[i]) {
                stack.pop();
            }
            if (stack.empty()) {
                spansOfStock[i] = i + 1;
            } else {
                spansOfStock[i] = i-stack.peek();
            }
            stack.push(i);
        }
        return spansOfStock;
    }

}
