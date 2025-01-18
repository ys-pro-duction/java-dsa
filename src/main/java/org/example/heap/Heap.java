package org.example.heap;

import java.util.Arrays;
import java.util.Comparator;

public class Heap {
    private int[] heap;
    private int lastIdx = -1;

    public Heap(int size) {
        heap = new int[size];
    }

    public boolean isEmpty() {
        return lastIdx < 0;
    }

    public void print() {
        System.out.println(Arrays.toString(heap));
    }

    public void printH() {
        for (int i = 0, j = 0; i < heap.length / 2; i++) {
            if (i == 0) System.out.print(" " + heap[j++]);
            for (int k = 0; k < i * 2; k++) {
                System.out.print(" " + heap[j++]);
            }
            System.out.println();
        }
    }

    public int length() {
        return heap.length;
    }

    public int peak() {
        return heap[0];
    }

    public void insert(int data) {
        heap[++lastIdx] = data;
        int idx = lastIdx;
        int parent = (idx - 1) / 2;
        while (heap[idx] > heap[parent]) {
            swap(parent, idx);
            idx = parent;
            parent = (idx - 1) / 2;
        }
    }

    public int remove() {
        swap(0, lastIdx--);
        heapify(0);
        return heap[lastIdx + 1];
    }

    private void heapify(int i) {
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;
        int swapWith = i;
        if (left <= lastIdx && heap[swapWith] < heap[left]) {
            swapWith = left;
        }
        if (right <= lastIdx && heap[swapWith] < heap[right]) {
            swapWith = right;
        }
        if (swapWith != i) {
            swap(swapWith, i);
            heapify(swapWith);
        }
    }

    public void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}
