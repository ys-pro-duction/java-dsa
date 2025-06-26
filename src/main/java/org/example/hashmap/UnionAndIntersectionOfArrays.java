package org.example.hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class UnionAndIntersectionOfArrays {
    public static void main(String[] args) {
        int[] arr1 = {7,3,9};
        int[] arr2 = {6,3,9,2,9,4};
        unionAndIntersaction(arr1,arr2);
    }
    private static void unionAndIntersaction(int[] arr1,int[] arr2){
        HashMap<Integer,Integer> hashMap = new HashMap<>(Math.max(arr1.length, arr2.length));
        for (int i :arr1) {
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
        }
        for (int i :arr2) {
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
        }
        ArrayList<Integer> union = new ArrayList<>();
        ArrayList<Integer> intersection = new ArrayList<>();
        for (int key : hashMap.keySet()) {
            int value = hashMap.getOrDefault(key,0);
            if (value >= 1){
                union.add(key);
                if (value > 1) intersection.add(key);
            }
        }
        System.out.println("Union: "+union);
        System.out.println("Intersection: "+intersection);
    }
}
