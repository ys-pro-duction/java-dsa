package org.example.questions;

public class PeakElement {
    public static void main(String[] args) {
        int[] num = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(num));
    }

    public static int findPeakElement(int[] nums) {
        int i = 0,j = nums.length-1;
        while (i < j){
            int mid = (i+j)/2;
            try{
                if (nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]){
                    return mid;
                }
            }catch (Exception e){}
            j = mid;
        }
        j = nums.length-1;
        while (i < j){
            int mid = (i+j)/2;
            try{
                if (nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]){
                    return mid;
                }
            }catch (Exception e){}
            i = mid;
        }
        return -1;
    }
}
