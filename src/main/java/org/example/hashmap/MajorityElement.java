package org.example.hashmap;

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i :nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int cap = nums.length/3; // n/3 time occur
        for (Integer key : map.keySet()) {
            int value = map.get(key);
            if (value > cap) {
                System.out.print(" "+key);
            }
        }
    }
}
