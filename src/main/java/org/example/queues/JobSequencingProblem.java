package org.example.queues;

import java.util.ArrayList;

public class JobSequencingProblem {
    /*:
Job Sequencing Problem
We have an array of jobs where every job has a deadline and associated profit if the job is
finished before the deadline. It is also given that every job takes a single unit of time, so the
minimum possible deadline for any job is 1. Maximize the total profit if only one job can be
scheduled at a time.
*/
    public static void main(String[] args) {
        ArrayList<int[]> arraylist = new ArrayList<>();
        arraylist.add(new int[]{'a', 4, 20});
        arraylist.add(new int[]{'b', 1, 10});
        arraylist.add(new int[]{'c', 1, 40});
        arraylist.add(new int[]{'d', 1, 30});

        findJobWithMaxProfit(arraylist);
    }

    private static void findJobWithMaxProfit(ArrayList<int[]> arraylist) {
        arraylist.sort((o1, o2) -> o2[2] - o1[2]);
        arraylist.forEach(ints -> {
            for (int i = 0; i < ints.length; i++) {
                if (i == 0) {
                    System.out.print((char) ints[i] + ".");
                    continue;
                }
                int anInt = ints[i];
                System.out.print(" " + anInt);
            }
            System.out.println();
        });
        int[] deadLine = new int[100];
        int profit = 0;
        System.out.print("\nDo job = ");
        for (int[] job : arraylist) {
            if (deadLine[job[1]] == 0) {
                profit += job[2];
                deadLine[job[1]]++;
                System.out.print((char) job[0] + ", ");
            }
        }
        System.out.println("\nProfit = " + profit);
    }
}
