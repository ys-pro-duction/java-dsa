package org.example.questions;

import org.example.Main;

public class Q88MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {5, 6, 7, 0, 0, 0};
        int m = 3;
        int[] nums2 = {5, 8, 9};
        int n = 3;
        merge2(nums1, m, nums2, n);
        Main.printIntArray(nums1);
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1, j = n - 1, lstIdx = nums1.length - 1; lstIdx >= 0; lstIdx--) {
            if (i >= 0) {
                if (j >= 0) {
                    if (nums1[i] > nums2[j]) {
                        nums1[lstIdx] = nums1[i--];
                    } else {
                        nums1[lstIdx] = nums2[j--];
                    }
                } else {
                    nums1[lstIdx] = nums1[i--];
                }
            } else {
                nums1[lstIdx] = nums2[j--];
            }
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = 0; i < m && j < n; i++) {
            if (nums1[i] > nums2[j]) {
                int tmp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = tmp;
            }
            for (int jj = 0; jj < n - 1; jj++) {
                if (nums2[jj] > nums2[jj + 1]) {
                    int tmp = nums2[jj];
                    nums2[jj] = nums2[jj + 1];
                    nums2[jj + 1] = tmp;
                } else {
                    break;
                }
            }
        }
        if (nums1.length - m >= 0) System.arraycopy(nums2, m - m, nums1, m, nums1.length - m);
    }
}
