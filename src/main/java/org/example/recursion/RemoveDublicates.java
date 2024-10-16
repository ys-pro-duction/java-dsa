package org.example.recursion;

public class RemoveDublicates {
    static boolean[] chars = new boolean[26];

    public static void main(String[] args) {
        String s = "appanacollege";
        String uniqe = findUniqeCharacter(s);
        chars = new boolean[26];
        String uniqeR = findUniqeCharacterR(s,0);
        System.out.println(uniqeR);
        System.out.println(uniqe);
    }

    private static String findUniqeCharacterR(String s,int i) {
        if (i == s.length()) return "";
        if (!chars[s.charAt(i)-'a']){
            chars[s.charAt(i)-'a'] = true;
            return s.charAt(i)+findUniqeCharacterR(s, ++i);
        }
        return findUniqeCharacterR(s, ++i);
    }
    private static String findUniqeCharacter(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char cuchar = s.charAt(i);
            if (!chars[cuchar - 'a']) {
                result += cuchar;
                chars[cuchar - 'a'] = true;
            }
        }
        return result;
    }
}
