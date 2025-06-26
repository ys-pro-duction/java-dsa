package org.example.heap;

import org.example.Main;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = soluton(arr,k);
        Main.printIntArray(result);
    }

    public static class Pair implements Comparable<Pair>{
        int index;
        int data;
        public Pair(int index,int data){
            this.index = index;
            this.data = data;
        }

        @Override
        public int compareTo(Pair o) {
            return o.data-data;
        }
    }
    private static int[] soluton(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        int start = 0;
        PriorityQueue<Integer[]> pq = new PriorityQueue<>
                ((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < nums.length; i++) {
            Integer[] pair = new Integer[]{i, nums[i]};
            pq.add(pair);
            if (pq.size() < k) continue;
            while (pq.peek()[0] < start) pq.remove();
            result[start++] = pq.peek()[1];
        }
        return result;
    }
}
