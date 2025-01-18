package org.example.binary_tree;

import org.example.binary_tree.BinaryTreeWithNode.BinaryTree;
import org.example.binary_tree.BinaryTreeWithNode.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewOfTree {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1};
        Node mainTree = new BinaryTree().buildBinaryTree(nodes);
        HashMap<Integer, Integer> map = new HashMap<>();
        topView(mainTree, map);
        System.out.println();
        map.values().forEach(System.out::println);
    }

    //           1
    //         2   3
    //       4  5    6
    public static void topView(Node root, HashMap<Integer, Integer> map) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            Node cuNode = queue.remove();
            if (cuNode != null) {
                if (!map.containsKey(cuNode.idx)) map.put(cuNode.idx, cuNode.data);
                if (cuNode.left != null) {
                    cuNode.left.idx = cuNode.idx - 1;
                    min = Math.min(min, cuNode.idx - 1);
                    queue.add(cuNode.left);
                }
                if (cuNode.right != null) {
                    cuNode.right.idx = cuNode.idx + 1;
                    max = Math.max(max, cuNode.idx + 1);
                    queue.add(cuNode.right);
                }
            }
        }
        for (; min <= max; min++) {
            System.out.print(" " + map.get(min));
        }
    }
}
