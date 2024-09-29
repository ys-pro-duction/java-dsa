package org.example.questions;

public class StringToIntToString {
    public static void main(String[] args) {
        System.out.println(getLucky("leetcode", 1));
//        ((int) 'a')%32
    }

    static public int getLucky(String s, int k) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result += (((int) s.charAt(i)) % 32);
        }
        String result2 = result;
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (int j = 0; j < result2.length(); j++) {
                sum += Integer.parseInt(String.valueOf(result2.charAt(j)));
            }
            result2 = String.valueOf(sum);
        }
        return Integer.parseInt(result2);
    }
}
