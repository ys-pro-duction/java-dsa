package org.example.string;

import java.util.Arrays;

public class CheckAnagrams {
    public static void main(String[] args) {
        System.out.println(anagram("badec","abedc"));
    }
    private static boolean anagram(String str1, String str2){
        byte[] b1 = str1.getBytes();
        Arrays.sort(b1);
        System.out.println(new String(b1));
        byte[] b2 = str2.getBytes();
        Arrays.sort(b2);
        System.out.println(new String(b2));
        return Arrays.equals(b1,b2);
    }
}
