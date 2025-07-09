package org.example.hashmap;

import kotlin.Pair;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {3,2,4};
        int target = 6;
        Pair<Integer,Integer> result = twoSum(arr,target);
        System.out.println("arr["+result.getFirst()+"]="+arr[result.getFirst()]+" + arr["+result.getSecond()+"]="+arr[result.getSecond()]+
                "   =  target "+(arr[result.getFirst()]+arr[result.getSecond()]));
    }

    private static Pair<Integer, Integer> twoSum(int[] arr, int target) {
        Pair<Integer,Integer> result = null;
        HashMap<Integer,Integer> map = new HashMap<>(); // 1: Value, 2: Index
        for (int i = 0; i < arr.length; i++) {
            int need = target-arr[i];
            if (map.containsKey(need)){
                result = new Pair<>(map.get(need),i);
                break;
            }else map.put(arr[i],i );
        }
        return result;
    }


}
