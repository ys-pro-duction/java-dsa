package org.example.hashmap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SortByFrequency {
    public static void main(String[] args) {
        Comparator<Pair> comparator = (o1, o2) -> o2.count() - o1.count() == 0 ? o1.c() - o2.c() : o2.count() - o1.count();
        PriorityQueue<Pair> pq = new PriorityQueue<>(comparator);
        TreeMap<Character, Integer> map = new TreeMap<>();
        String inputSting = "tree";
        for (char c : inputSting.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c: map.keySet()) {
            pq.add(new Pair(c,map.get(c)));
        }
        
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            result.append(String.valueOf(pair.c()).repeat(pair.count()));
        }
        System.out.println(result);
    }
}

record Pair(char c, int count) {
}
