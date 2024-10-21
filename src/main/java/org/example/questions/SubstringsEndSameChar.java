package org.example.questions;

public class SubstringsEndSameChar {
    public static void main(String[] args) {
        String str = "123";
        System.out.println(countSubstrings(str, 0, str.length() - 1, str.length()));
    }

    // Recursive function to count substrings that start and end with the same character
    public static int countSubstrings(String str, int start, int end, int n) {
        if (n <= 1) return n;
        int res = countSubstrings(str, start + 1, end, n - 1)
                + countSubstrings(str, start, end - 1, n - 1)
                -countSubstrings(str,start+1,end+1,n-2);
        if (str.charAt(start) == str.charAt(end)) res++;
        return res;
    }
}
