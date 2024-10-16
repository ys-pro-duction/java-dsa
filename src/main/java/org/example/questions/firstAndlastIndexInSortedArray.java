package org.example.questions;

import org.example.Main;

public class firstAndlastIndexInSortedArray {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] result = searchRange(nums, 8);
        Main.printIntArray(result);
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = recursion(nums, 0, nums.length - 1, target, true);
        result[1] = recursion(nums, 0, nums.length - 1, target, false);
        return result;
    }

    private static int recursion(int[] nums, int start, int end, int target, boolean first) {
        if (start > end) return -1;
        if (start == end) {
            if (target == nums[start]) return start;
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            if (end - start == 1) {
                if (!first && nums[end] == target) {
                    return end;
                } else if (!first) {
                    return mid;
                }
            }
            return recursion(nums, first ? start : mid, first ? mid : end, target, first);
        } else if (nums[mid] < target) {
            return recursion(nums, mid + 1, end, target, first);
        } else return recursion(nums, start, mid - 1, target, first);
    }
}
