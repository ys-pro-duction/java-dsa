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
        int left = findDiameterRecursively(root.left);
        int right = findDiameterRecursively(root.right);
        return left + right + 1;
    }

    public static int findDiameterRecursively(Node root) {
        if (root == null) return 0;
        int left = findDiameterRecursively(root.left);
        int right = findDiameterRecursively(root.right);
        return Math.max(left, right) + 1;
    }

    public static int tuteApproch1Diamter(Node root) {
        if (root == null) return 0;
        int leftDia = tuteApproch1Diamter(root.left);
        int leftHeight = HeightOfTree.treeHeight(root.left);
        int rightDia = tuteApproch1Diamter(root.right);
        int rightHeight = HeightOfTree.treeHeight(root.right);
        int fromRoot = leftHeight + rightHeight + 1;
        return Math.max(fromRoot, Math.max(leftDia, rightDia));
    }

    public static TreeInfo tuteApproch2Diamter(Node root) {
        if (root == null) return new TreeInfo(0, 0);
        TreeInfo leftInfo = tuteApproch2Diamter(root.left);
        TreeInfo rightInfo = tuteApproch2Diamter(root.right);
        int thruRoot = leftInfo.height + rightInfo.height + 1;
        return new TreeInfo(Math.max(leftInfo.height, rightInfo.height) + 1,
                Math.max(thruRoot, Math.max(leftInfo.height, rightInfo.height)));
    }

    record TreeInfo(int height, int diamter) {
    }
}
