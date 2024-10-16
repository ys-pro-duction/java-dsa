package org.example.questions;

public class Q1813SentenceSimilarityIII {
    public static void main(String[] args) {
        String s1 = "My name is Haley";
        String s2 = "My name a Haley";

        System.out.println(areSentencesSimilar(s1, s2));
    }

    private static boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");

        if (arr1.length < arr2.length) {
            String[] tmp = arr1;
            arr1 = arr2;
            arr2 = tmp;
        }
        int start = 0, end = 0;
        int sn1 = arr1.length, sn2 = arr2.length;

        while (start < sn2 && arr1[start].equals(arr2[start])) {
            start++;
        }
        while (end < sn2 && arr1[sn1 - end - 1].equals(arr2[sn2 - end - 1])) {
            end++;
        }
        return start + end >= sn2;
    }
}
