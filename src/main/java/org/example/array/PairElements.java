package org.example.array;

public class PairElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
//        printPairs(arr);
        printSubArrayPair(arr);
    }

    /**
     * O(n^3)
     *
     * @param arr
     */
    public static void printSubArrayPair(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.println();
                for (int k = i; k < j + 1; k++) {
                    System.out.print(arr[k]);
                }
            }
            System.out.println();
        }
    }

    /**
     * O(n^2),
     * total pair = n(n-1)/2
     *
     * @param arr
     */
    public static void printPairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ")");
            }
            System.out.println();
        }
    }
}
