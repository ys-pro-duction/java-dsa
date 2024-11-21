package org.example.queues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumOfAllSubarrays {
    /*
     * Maximum of all subarrays of size k
     * We have an array arr[] of size N and an integer K. Find the maximum for each and every
     * contiguous subarray of size K.*/
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        Queue<Integer> queue = new LinkedList<>();
        Arrays.stream(arr).forEach(queue::add);
        int N = 9;
        int K = 3;
        Queue<Integer> result = maximumOfAllSubarr(queue, N, K);
        while (!result.isEmpty()) System.out.print(" ," + result.remove());
    }

    private static Queue<Integer> maximumOfAllSubarr(Queue<Integer> queue, int n, int k) {
        Queue<Integer> tmp = new LinkedList<>();
        Queue<Integer> MAX = new LinkedList<>();
        for (int i = 0; i < k; i++, n--) {
            tmp.add(queue.remove());
        }
        for (int i = 0; i <= n; i++) {
            int max = 0;
            for (int i1 = 0; i1 < k; i1++) {
                int tmpi = tmp.remove();
                if (tmpi > max) max = tmpi;
                tmp.add(tmpi);
            }
            MAX.add(max);
            if (queue.isEmpty()) break;
            tmp.remove();
            tmp.add(queue.remove());
        }
        return MAX;
    }
}
