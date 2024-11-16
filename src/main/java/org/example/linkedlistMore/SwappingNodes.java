package org.example.linkedlistMore;

import org.example.linkedlist.LInkedListInitalized.Node;

public class SwappingNodes {
    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node6 = new Node(6, node7);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        int keyOne = 3;
        int keyTwo = 6;
        swapNodes(node1, keyOne, keyTwo);

        for (; node1 != null; node1 = node1.next) {
            System.out.print(node1.data + "->");
        }
        System.out.println();
    }

    private static void swapNodes(Node node, int keyOne, int keyTwo) {
        int i = 1;
        Node oneFirst = node;
        for (; i < keyOne - 1; i++) {
            oneFirst = oneFirst.next;
        }
        Node oneSecond = oneFirst.next;
        Node twoFirst = oneFirst;
        for (; i < keyTwo - 1; i++) {
            twoFirst = twoFirst.next;
        }
        Node twoSecond = twoFirst.next;

        Node twoSecondNext = twoSecond.next;
        Node oneSecondNext = oneSecond.next;
        oneSecond.next = twoSecondNext;
        oneFirst.next = twoSecond;
        twoSecond.next = oneSecondNext;
        twoFirst.next = oneSecond;
    }
}
