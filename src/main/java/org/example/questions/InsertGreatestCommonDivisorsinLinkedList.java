package org.example.questions;

import org.example.Main;

import static org.example.questions.Q2326SpiralMatrixIV.ListNode;

public class InsertGreatestCommonDivisorsinLinkedList {
    public static void main(String[] args) {
        int[] arr = {16,16};
        ListNode listNode = new ListNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            listNode = new ListNode(arr[i], listNode);
        }
        Main.printIntArray(arr);
        ListNode ln = insertGreatestCommonDivisors(listNode);
        System.out.println();
        while (ln != null) {
            System.out.print(" " + ln.val);
            ln = ln.next;
        }
    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode result;
        ListNode mHead = head;
        int old = mHead.val;
        mHead = mHead.next;
        result = new ListNode(old);
        while (mHead != null) {
            int max = 0;
            for (int j = 1; j < Math.max(old, mHead.val) / 2; j++) {
                if (old % j == 0 && mHead.val % j == 0) {
                    max = j;
                }
            }
            result = new ListNode(max, result);
            result = new ListNode(mHead.val, result);
            old = mHead.val;
            mHead = mHead.next;
        }
        ListNode result2 = null;
        while (result != null){
            if (result2 == null){
                result2 = new ListNode(result.val);
            }else result2 = new ListNode(result.val,result2);
            result = result.next;
        }
        return result2;
    }
}
