package org.example.binary_tree;

import org.example.binary_tree.BinaryTreeWithNode.Node;

public class HeightOfTree {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 2};
        BinaryTreeWithNode.BinaryTree bt = new BinaryTreeWithNode.BinaryTree();
        Node root = bt.buildBinaryTree(nodes);
        int height = treeHeight(root);
        System.out.println(height);
        System.out.println();
        BinaryTreeWithNode.printLevelOrder(root);
    }

    public static int treeHeight(Node root) {
        if (root == null) return 0;
        int leftHeight = treeHeight(root.leftChild);
        int rightHeight = treeHeight(root.rightChild);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
