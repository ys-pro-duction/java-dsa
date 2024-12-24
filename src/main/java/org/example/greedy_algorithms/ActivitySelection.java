package org.example.greedy_algorithms;

public class ActivitySelection {
    public static void main(String[] args) {
        /*Activity Selection
You are given n activities with their start and end times. Select the maximum number of activities
that can be performed by a single person, assuming that a person can only work on a single
activity at a time. Activities are sorted according to end time.*/
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        boolean doing[] = new boolean[start.length];
        doing[0] = true;
        int lastWork = 0;
        for (int i = 1; i < start.length; i++) {
            if (start[i] >= end[lastWork]) {
                doing[i] = true;
                lastWork = i;
            }
        }
        for (int i = 0; i < doing.length; i++) {
            if (doing[i]) System.out.println(i + 1 + ". start = " + start[i] + " end = " + end[i]);
        }
    }
}
