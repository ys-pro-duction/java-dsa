package org.example.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ValidAnagram {
    public static void main(String[] args) {
//        Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//                An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
//                typically using all the original letters exactly once.
//        String s = "race", t = "care";
//        String s = "heart", t="earth";
        String s = "tulip", t = "lipid";

        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c : t.toCharArray()) {
            int value = map.getOrDefault(c,0);
            if (value >1){
                map.put(c,value-1);
            }else if (value == 1){
                map.remove(c);
            }else{
                System.out.println("Not a \"Valid Anagram\"");
                return;
            }
        }
        if (map.size() > 0){
            System.out.println("Not a \"Valid Anagram\"");
        }else{
            System.out.println("It's a \"Valid Anagram\"");
        }

    }
}
