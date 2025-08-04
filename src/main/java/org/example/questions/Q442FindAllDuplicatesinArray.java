package org.example.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q442FindAllDuplicatesinArray {

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(new Q442FindAllDuplicatesinArray().findDuplicates(arr));
    }
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] frequency = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            frequency[nums[i]]++;
            if (frequency[nums[i]] > 1) result.add(nums[i]);
        }
        return result;
    }
}
