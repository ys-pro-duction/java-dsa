package org.example.linkedlistMore;

import org.example.linkedlist.LInkedListInitalized;
import org.example.linkedlist.LInkedListInitalized.Node;

public class DeleteNnodesAfterMnodes {
    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node6 = new Node(6, node7);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        int M = 2;
        int N = 2;
        gotToMandDeleteN(node1, M, N);
        for (; node1 != null; node1 = node1.next) {
            System.out.print(node1.data + "->");
        }
        System.out.println();
    }

    private static void gotToMandDeleteN(Node node, int M, int N) {
        for (int i = 1; i < M; i++) {
            node = node.next;
        }
        Node afterN = node;
        for (int i = 0; i <= N; i++) {
            afterN = afterN.next;
        }
        node.next = afterN;
    }
}
