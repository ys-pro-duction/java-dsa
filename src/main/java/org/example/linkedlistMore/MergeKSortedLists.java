package org.example.linkedlistMore;

import org.example.linkedlist.LInkedListInitalized.Node;

public class MergeKSortedLists {
    //We have K sorted linked lists of size N each, merge them and print the sorted output.
    public static void main(String[] args) {
        Node n1 = new Node(1, new Node(3));
        Node n2 = new Node(6, new Node(8));
        Node n3 = new Node(9, new Node(10));
        Node[] list = {n1, n2, n3};

        Node result = mergeNodes(list);
        for (; result != null; result = result.next) {
            System.out.print(result.data + "->");
        }
        System.out.println();
    }

    private static Node mergeNodes(Node[] nodes) {
        Node tmp;
        Node tmptail;
        for (int i = 1; i < nodes.length; i++) {
            tmp = new Node(-1);
            tmptail = tmp;
            Node one = nodes[0];
            Node two = nodes[i];
            while (one != null || two != null) {
                if (one == null) {
                    tmptail.next = two;
                    two = null;
                } else if (two == null) {
                    tmptail.next = one;
                    one = null;
                } else {
                    if (one.data < two.data) {
                        tmptail.next = one;
                        tmptail = tmptail.next;
                        Node tone = one.next;
                        one.next = null;
                        one = tone;
                    } else {
                        tmptail.next = two;
                        tmptail = tmptail.next;
                        Node ttwo = two.next;
                        two.next = null;
                        two = ttwo;
                    }
                }
            }
            nodes[0] = tmp.next;
        }
        return nodes[0];
    }
}
