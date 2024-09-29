package org.example.array;

import java.util.Arrays;

public class BuySellStocks {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Profit: " + buyAndSellStockProfit(prices));
    }

    /**
     * Buy stock at lowest price and sell next at highest price for max profit
     *
     * @param arr
     * @return max profit from trade
     */
    public static int buyAndSellStockProfit(int[] arr) {
        int buy = arr[0];
        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            buy = Math.min(arr[i], buy);
            maxProfit = Math.max(maxProfit, arr[i] - buy);
        }
        System.out.println("Buy at: " + buy + " Sell at: " + (buy + maxProfit));
        return maxProfit;
    }
}
