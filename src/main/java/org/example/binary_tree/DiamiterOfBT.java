package org.example.binary_tree;

import org.example.binary_tree.BinaryTreeWithNode.Node;

public class DiamiterOfBT {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, 9, -1, -1, -1, 3, -1, 6, -1};
        BinaryTreeWithNode.BinaryTree bt = new BinaryTreeWithNode.BinaryTree();
        Node root = bt.buildBinaryTree(nodes);
        BinaryTreeWithNode.printLevelOrder(root);
        System.out.println();
        int diamete = tuteApproch2Diamter(root).diamter;
        System.out.println(diamete);
    }

    public static int diameter(Node root) {
        int left = findDiameterRecursively(root.leftChild);
        int right = findDiameterRecursively(root.rightChild);
        return left + right + 1;
    }

    public static int findDiameterRecursively(Node root) {
        if (root == null) return 0;
        int left = findDiameterRecursively(root.leftChild);
        int right = findDiameterRecursively(root.rightChild);
        return Math.max(left, right) + 1;
    }

    public static int tuteApproch1Diamter(Node root) {
        if (root == null) return 0;
        int leftDia = tuteApproch1Diamter(root.leftChild);
        int leftHeight = HeightOfTree.treeHeight(root.leftChild);
        int rightDia = tuteApproch1Diamter(root.rightChild);
        int rightHeight = HeightOfTree.treeHeight(root.rightChild);
        int fromRoot = leftHeight + rightHeight + 1;
        return Math.max(fromRoot, Math.max(leftDia, rightDia));
    }

    public static TreeInfo tuteApproch2Diamter(Node root) {
        if (root == null) return new TreeInfo(0, 0);
        TreeInfo leftInfo = tuteApproch2Diamter(root.leftChild);
        TreeInfo rightInfo = tuteApproch2Diamter(root.rightChild);
        int thruRoot = leftInfo.height + rightInfo.height + 1;
        return new TreeInfo(Math.max(leftInfo.height, rightInfo.height) + 1,
                Math.max(thruRoot, Math.max(leftInfo.height, rightInfo.height)));
    }

    record TreeInfo(int height, int diamter) {
    }
}
