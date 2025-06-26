package org.example.hashmap;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.IntConsumer;

public class SubarraySumEqualToK {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int k = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = -1, right = -1;
        for (int i = 0, sum = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                left = map.get(sum)+1;
                right = i;
            } else {
                map.put(sum, i);
            }
        }

        int[] list = Arrays.copyOfRange(arr,left,right+1);
        Arrays.stream(list).forEach(value -> System.out.print(value+", "));
    }
}
/***
 *    int[] arr = {10, 2, -2, -20, 10};
 *         int k = -10;
 *
 *         HashMap<Integer, Integer> hashMap = new HashMap<>();
 *         int count = 0;
 *         int sum = 0;
 *         hashMap.put(0, 1);
 *         for (int j : arr) {
 *             sum += j;
 *             if (hashMap.containsKey(sum - k)) {
 *                 count += hashMap.get(sum - k);
 *             }
 *             hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
 *         }
 *         System.out.println(count);
 */