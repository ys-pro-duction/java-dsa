package org.example.string;

public class StringCompression {
    public static void main(String[] args) {
        String str = "fffffffiiiiieeekkkvmmmfuuuu";
        String compressed = compress(str);
        System.out.println(compressed);
        System.out.println(deCompress("fe9"));
    }

    private static String compress(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); ) {
            char ch = str.charAt(i);
            int count = 0;
            while (i < str.length() && ch == str.charAt(i)) {
                count++;
                i++;
            }
            sb.append(ch);
            if (count > 1) sb.append(count);
        }
        return sb.toString();
    }

    private static String deCompress(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c <= 57 && c >= 49) {
                int count = Integer.parseInt(String.valueOf(c));
                char lastChar = str.charAt(i - 1);
                while (count > 0) {
                    sb.append(lastChar);
                    count--;
                }
            }
        }
        return sb.toString();
    }
}
