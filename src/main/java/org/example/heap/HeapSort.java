package org.example.heap;

import java.util.ArrayList;

public class HeapSort {
    private static final ArrayList<Integer> heap = new ArrayList<>();
    private static int lastIdx = -1;

    public static void main(String[] args) {
        heap.add(90);
        lastIdx++;
        heap.add(40);
        lastIdx++;
        heap.add(80);
        lastIdx++;
        heap.add(10);
        lastIdx++;
        heap.add(30);
        lastIdx++;
        heap.add(20);
        lastIdx++;
        heap.add(2);
        lastIdx++;
        System.out.println(heap);
        heapSort(heap);
        System.out.println(heap);
    }

    public static void heapSort(ArrayList<Integer> h) {
        for (int i = lastIdx; i > 0; i--) {
            int temp = h.get(0);
            h.set(0, h.get(i));
            h.set(i, temp);
            lastIdx--;
            heapify(0);
        }
    }

    private static void heapify(int i) {
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;
        int swapWith = i;
        if (left <= lastIdx && heap.get(swapWith) < heap.get(left)) {
            swapWith = left;
        }
        if (right <= lastIdx && heap.get(swapWith) < heap.get(right)) {
            swapWith = right;
        }
        if (swapWith != i) {
            int tmp = heap.get(swapWith);
            int tmp2 = heap.get(i);
            heap.set(i, tmp);
            heap.set(swapWith, tmp2);
            heapify(swapWith);
        }
    }
}
