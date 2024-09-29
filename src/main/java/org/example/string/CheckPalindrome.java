package org.example.string;

public class CheckPalindrome {
    public static void main(String[] args) {
        String s = "noon";
        System.out.println("Palindrome = "+isPalindrome(s));
    }

    /**
     * Check if string is palindrome, mean string same if it reversed.
     * O(n)
     * @param s
     * @return isPalindrome @{@link Boolean}
     */
    private static Boolean isPalindrome(String s){
        int last = s.length();
        int half = last/2;
        for (int i = 0; i < half; i++) {
            if (s.charAt(i) != s.charAt(last-1)) return false;
            last--;
        }
        return true;
    }
}
