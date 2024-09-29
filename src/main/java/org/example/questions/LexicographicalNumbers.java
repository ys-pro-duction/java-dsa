package org.example.questions;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public static void main(String[] args) {
        int num = 15;
        List<Integer> result = lexicalOrder(num);
        result.forEach(System.out::print);
    }

    public static List<Integer> lexicalOrder(int n) {
        ArrayList<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            result.add(String.valueOf(i));
        }
        return result.stream().sorted().map(Integer::parseInt).toList();
    }
}
