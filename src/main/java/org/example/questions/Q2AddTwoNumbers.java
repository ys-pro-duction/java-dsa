package org.example.questions;

import org.example.questions.Q2326SpiralMatrixIV.ListNode;

public class Q2AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode l2 = new ListNode(9, new ListNode(9));
        ListNode result = addTwoNumbers(l1, l2);
        for (; result != null; result = result.next) {
            System.out.println(result.val);
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        if (l1.val + l2.val > 9) {
            result.val = l1.val + l2.val - 10;
            if (l1.next == null) l1.next = new ListNode(1);
            else l1.next.val++;
        } else result.val = l1.val + l2.val;
        addTwoNum(result, l1.next, l2.next,false);
        return result;
    }

    private static void addTwoNum(ListNode o, ListNode l1, ListNode l2, boolean extra) {
        if (l1 == null && l2 == null && !extra) return;
        int sum = 0;
        if (extra) sum++;
        extra = false;
        if (l1 != null) sum += l1.val;
        if (l2 != null) sum += l2.val;
        if (sum > 9) {
            extra = true;
            sum -= 10;
        }
        o.next = new ListNode(sum);
        addTwoNum(o.next, l1 == null ? null : l1.next, l2 == null ? null : l2.next,extra);
//        return;
//        if (l1 != null && l2 != null) {
//            if (l1.val + l2.val > 9) {
//                o.next = new ListNode(l1.val + l2.val - 10);
//                extra = true;
//            } else o.next = new ListNode(l1.val + l2.val);
//        } else if (l1 != null) {
//            o.next = l1;
//        } else if (l2 != null) {
//            o.next = l2;
//        }
//        if (extra) {
//            if (l1 == null) {
//                l1 = new ListNode(0, new ListNode(1));
//            } else if (l1.next == null) l1.next = new ListNode(1);
//            else l1.next.val++;
//        }
//        if (l1 != null || l2 != null) {
//            addTwoNum(o.next, l1 == null ? null : l1.next, l2 == null ? null : l2.next,extra);
//        }
    }
}
