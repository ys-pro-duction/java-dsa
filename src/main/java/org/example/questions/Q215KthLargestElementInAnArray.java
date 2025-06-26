package org.example.questions;

import org.example.Main;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q215KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("Kth larger element = " + findKthLargest(nums, k));
        System.out.println("Kth larger element = " + findKthLargestWithQuickSort(nums,k));
        System.out.println("Kth larger element = " + findKthLargestMostOptimized(nums,k));
    }

    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        for (int i = 0; i < k; i++) {
            if (k == i + 1) return pq.remove();
            pq.remove();
        }
        return 0;
    }

    private static int findKthLargestWithQuickSort(int[] nums, int k) {
        qsort(nums,0,nums.length-1, nums.length-k);
        Main.printIntArray(nums);
        return nums[nums.length-k];
    }

    private static void qsort(int arr[],int st,int en,int k){
        int indx = partitioning(arr,st,en);
        if (indx == k) return;
        if (indx < k){
            qsort(arr, indx+1, en, k);
        }else{
            qsort(arr, st, indx-1, k);
        }
    }

    private static int partitioning(int[] arr, int st, int en) {
        int pivote = arr[en];
        int j = st - 1;
        for (int i = st; i < en; i++) {
            if (arr[i] < pivote) {
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        j++;
        arr[en] = arr[j];
        arr[j] = pivote;
        return j;
    }

    private static int findKthLargestMostOptimized(int[] nums, int k) {
        int[] count = new int[20001];

        for (int num : nums)
            count[num +1000]++;

        for (int i = count.length - 1; i >= 0; i--)
            if (count[i] > 0) {
                k -= count[i];
                if (k <= 0) return i-1000 ;
            }

        return -1;
    }

}
