package org.example.queues;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingLetter {
    //First non-repeating Letter in a stream of characters.
    public static void main(String[] args) {
        String string = "aabccxb";
        printNonRepeatingLetter(string);
    }

    private static void printNonRepeatingLetter(String string) {
        int frequency[] = new int[26];
        Queue<Character> queue = new LinkedList<>();
        for (char c : string.toCharArray()) {
            frequency[c - 'a']++;
            queue.add(c);
            while (!queue.isEmpty() && frequency[queue.peek() - 'a'] > 1) {
                queue.remove();
            }
            if (queue.isEmpty()) System.out.println(-1);
            else System.out.println(queue.peek());
        }
    }
}
