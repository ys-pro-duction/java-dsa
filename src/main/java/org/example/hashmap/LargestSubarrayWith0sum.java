package org.example.hashmap;

import java.util.HashMap;

public class LargestSubarrayWith0sum {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10};
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int sum = 0;
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if (hashMap.containsKey(sum)){
                len = Math.max(len,i - hashMap.get(sum));
                System.out.println("new len: "+len);
            }else{
                hashMap.put(sum,i );
            }
        }

    }
}
