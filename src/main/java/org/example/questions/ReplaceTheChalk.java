package org.example.questions;

// 1894. Find the Student that Will Replace the Chalk
public class ReplaceTheChalk {
    public static void main(String[] args) {
        int[] arr1 = {5,1,5};
        int[] arr2 = {3,4,1,2};
        System.out.println("Expect: 0 got: "+chalkReplacer(arr1,22));
        System.out.println("Expect: 1 got: "+chalkReplacer(arr2,25));
    }
    public static int chalkReplacer(int[] chalk, int k) {
        int kk = k;
        while (true) {
            for (int i = 0; i < chalk.length; i++) {
                if (kk >= chalk[i]) {
                    kk -= chalk[i];
                } else {
                    return i;
                }
            }
        }
    }
}
