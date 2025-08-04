package org.example.questions;

public class Q169MajorityElement {
    public static void main(String[] args) {

        int[] arr = new int[]{2, 2, 2, 4, 5, 6};
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {
        return helper(nums, 0, nums[0]);
    }

    static int helper(int[] nums, int si, int ref) {
        int c = 0;
        for (int i = si; i < nums.length; i++) {
            if (nums[i] == ref) c++;
            else c--;
            if (c == -1) return helper(nums, i, nums[i]);
        }
        return ref;
    }

}
