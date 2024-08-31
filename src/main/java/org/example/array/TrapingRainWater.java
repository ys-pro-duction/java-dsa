package org.example.array;

import java.util.Arrays;

public class TrapingRainWater {
    public static void main(String[] args) {
        int[] arr = {4,2,0,6,3,2,5};
        System.out.println("Water = "+rainWater(arr));
    }
    /**
     * Find the volume of traped rain water between bars of array
     * e.g. int[] a = {2,0,1,3};
     *       ##
     * ##----##
     * ##--####
     *
     * -- => water
     * ## => bar
     * water = 3
     */
    public static int rainWater(int[] arr) {
        int arrLength = arr.length;
        if (arrLength <= 2) return 0;
        int[] leftMax = new int[arrLength];
        int[] rightMax = new int[arrLength];
        leftMax[0] = arr[0];
        rightMax[arrLength-1] = arr[arrLength-1];
        for (int i = 1; i < arrLength; i++) {
            leftMax[i] = Math.max(leftMax[i-1],arr[i]);
        }
        for (int i = arrLength-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1],arr[i]);
        }
        int water = 0;
        for (int i = 1; i < arrLength-1; i++) {
            int min = Math.min(leftMax[i-1],rightMax[i+1]);
            int waterLevel = min - arr[i];
            if (waterLevel > 0) water += waterLevel;
        }
        return water;
    }
}
