package org.example.hashmap;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class AllSets {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("India");
        hashSet.add("China");
        hashSet.add("Pakistan");

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("India");
        linkedHashSet.add("China");
        linkedHashSet.add("Pakistan");

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("India");
        treeSet.add("China");
        treeSet.add("Pakistan");

        System.out.println(hashSet);   //  Unorderd set   O(1)
        System.out.println(linkedHashSet); // Ordered set O(1)
        System.out.println(treeSet); // sorted order set  O(log n)
    }
}
