package org.example.linkedlistMore;

import org.example.linkedlistMore.DublyLL.*;

public class ReverseDublyLL {
    public static void main(String[] args) {
        DublyLL dlist = new DublyLL();
        dlist.addFirst(1);
        dlist.addFirst(2);
        dlist.addFirst(3);
        Node result = reverseDll(dlist);
        for (; result != null; result = result.next) {
            System.out.print(result.data + " ");
        }
        System.out.println();
    }

    private static Node reverseDll(DublyLL dll) {
        Node head = DublyLL.head;
        Node tail = DublyLL.tail;
        Node prev = null;
        Node curr = head;
        Node next = curr.next;
        while (next != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        return tail;
    }
}
