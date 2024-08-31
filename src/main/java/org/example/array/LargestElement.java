package org.example.array;

public class LargestElement {
    public static void main(String[] args) {
        int[] arr = {654, 65, 4132, 1, 687, 46, 13, 4, 765, 1, 321, 474, 98, 65};
        int largest = getLargest(arr);
        int smallest = getSmallest(arr);
        System.out.println("Largest integer int arr: " + largest);
        System.out.println("Largest smallest int arr: " + smallest);
    }

    public static int getLargest(int[] arr) {
        int large = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > large) large = i;
        }
        return large;
    }

    public static int getSmallest(int[] arr) {
        int large = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i < large) large = i;
        }
        return large;
    }
}
