package org.example.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class AllMaps {
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("India",10);
        hashMap.put("China",100);
        hashMap.put("Pakistan",2);

        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("India",10);
        linkedHashMap.put("China",100);
        linkedHashMap.put("Pakistan",2);

        TreeMap<String,Integer> treeMap = new TreeMap<>();
        treeMap.put("India",10);
        treeMap.put("China",100);
        treeMap.put("Pakistan",2);

        System.out.println(hashMap); // Set unordered     O(1)
        System.out.println(linkedHashMap);// Set ordered  O(1)
        System.out.println(treeMap); // Set in Sorted     O(log n)
    }
}
