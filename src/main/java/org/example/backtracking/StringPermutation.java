package org.example.backtracking;

public class StringPermutation {
    public static void main(String[] args) {
        String src = "abc";
        permutation(src, "");
    }

    private static void permutation(String src, String result) {
        if (src.length() == 0) {
            System.out.println(result);
        } else {
            for (int i = 0; i < src.length(); i++) {
                String tmp = src.substring(0, i) + src.substring(i + 1);
                permutation(tmp, result + src.charAt(i));
            }
        }
    }
}
