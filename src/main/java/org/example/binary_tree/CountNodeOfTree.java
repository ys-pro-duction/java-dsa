package org.example.binary_tree;

import org.example.binary_tree.BinaryTreeWithNode.Node;

public class CountNodeOfTree {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 2};
        BinaryTreeWithNode.BinaryTree bt = new BinaryTreeWithNode.BinaryTree();
        Node root = bt.buildBinaryTree(nodes);
        int height = countNode(root);
        System.out.println(height);
        System.out.println();
        BinaryTreeWithNode.printLevelOrder(root);
    }

    public static int countNode(Node root) {
        if (root == null) return 0;
        return countNode(root.leftChild) + countNode(root.rightChild) + 1;
    }
}
