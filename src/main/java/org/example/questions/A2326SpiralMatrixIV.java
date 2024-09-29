package org.example.questions;

import org.example.Main;

public class A2326SpiralMatrixIV {
    public static void main(String[] args) {
        ListNode ln = null;
        for (int i = 0; i < 9; i++) {
            if (ln == null) {
                ln = new ListNode(i, null);
            } else ln = new ListNode(i, ln);

        }
        int[][] result = spiralMatrix(3, 1, ln);
        Main.print2DArr(result);
    }

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = -1;
            }
        }
        int start = 0;
        int end = n - 1;
        int top = 0;
        int bottom = m - 1;
        ListNode mHead = head;
        while (start <= end && top <= bottom) {
            for (int i = start; i <= end; i++) {
                if (mHead == null) break;
                arr[top][i] = mHead.val;
                mHead = mHead.next;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                if (mHead == null) break;
                arr[i][end] = mHead.val;
                mHead = mHead.next;
            }
            end--;
            for (int i = end; i >= start; i--) {
                if (mHead == null) break;
                arr[bottom][i] = mHead.val;
                mHead = mHead.next;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                if (mHead == null) break;
                arr[i][start] = mHead.val;
                mHead = mHead.next;
            }
            start++;
        }
        return arr;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
