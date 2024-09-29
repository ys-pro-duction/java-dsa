package org.example.two_d_array;

import org.example.Main;

public class DiagonalSum {
    public static void main(String[] args) {
//        int[][] arr = {
//                {1, 2, 5,1},
//                {1, 2, 5,1},
//                {1, 2, 5,1},
//                {1, 2, 5,1}
//        };
        int[][] arr = {
                {1, 2, 5},
                {1, 2, 5},
                {1, 2, 5}
        };
        Main.print2DArr(arr);
        int sum = calculateDiagonalSum(arr);
        System.out.println("Sum = " + sum);
    }

    /**
     * sum of diagonal lines X
     * 1 0 0 1
     * 0 1 1 0
     * 0 1 1 0
     * 1 0 0 1
     * O(n)
     * @param arr
     * @return
     */
    private static int calculateDiagonalSum(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
            sum += arr[arr.length-1-i][i];
        }
//        for (int i = arr.length-1; i >= 0; i--) {
//            sum += arr[arr.length-1-i][i];
//        }
        if (arr.length%2 == 1){
            int mid = arr.length/2;
            sum -= arr[mid][mid];
        }
        return sum;
    }
}
