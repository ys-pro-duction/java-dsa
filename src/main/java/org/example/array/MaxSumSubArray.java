package org.example.array;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};
//        System.out.println(maxSumOfSubArrays(arr));
        System.out.println(maxSumOfArray_PrefixMethod(arr));
    }

    public static int maxSumOfArray_PrefixMethod(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
            }
            arr[i] = sum;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int sum = arr[j]-arr[(i == 0) ? 0 : i-1];
                System.out.println(sum);
                if (sum > max) max = sum;
            }
        }
        return max;
    }

    /**
     * O(n^3)
     * @param arr
     * @return
     */
    public static int maxSumOfSubArrays(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                int sum = 0;
                for (int i = start; i < end + 1; i++) {
                    sum +=  arr[i];
                }
                if (sum > max) max = sum;
            }
        }
        return max;
    }
}
