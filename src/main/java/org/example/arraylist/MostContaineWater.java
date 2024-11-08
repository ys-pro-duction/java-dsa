package org.example.arraylist;

import java.util.ArrayList;

public class MostContaineWater {
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(height);
        brutForceApproach(height);
        optimizeApproch(height);
    }

    private static void optimizeApproch(ArrayList<Integer> height) {
        int water = 0;
        for (int i = 0, j = height.size() - 1; i < j; ) {
            int h = Math.min(height.get(i), height.get(j));
            int w = j - i;
            water = Math.max(h * w, water);
            if (height.get(i) < height.get(j)) i++;
            else j--;
        }
        System.out.println("Optimized approch = " + water);
    }

    // O(n^2)
    private static void brutForceApproach(ArrayList<Integer> height) {
        int water = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int h = Integer.min(height.get(i), height.get(j));
                int w = j - i;
                water = Integer.max(water, h * w);
            }
        }
        System.out.println("Brut force = " + water);
    }
}
