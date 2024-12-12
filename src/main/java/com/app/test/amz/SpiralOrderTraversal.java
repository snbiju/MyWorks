package com.app.test.amz;

import java.util.*;
/*

Given a binary tree and the task is to find the spiral order traversal of the tree.

Spiral order Traversal mean: Starting from level 0 for root node, for all the even levels we print the node's value from right to left and for all the odd levels we print the node's value from left to right.

For below tree, function should return 1, 2, 3, 4, 5, 6, 7.
Example 1:

Input:
      1
    /   \
   3     2
Output:1 3 2

Example 2:

Input:
           10
         /     \
        20     30
      /    \
    40     60
Output: 10 20 30 60 40
 */


public class SpiralOrderTraversal {
    public static List<Integer> spiralOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        boolean leftToRight = true; // flag to alternate direction

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                if (leftToRight) {
                    TreeNode node = deque.pollFirst();
                    levelNodes.add(node.val);
                    if (node.right != null)
                        deque.addLast(node.right);
                    if (node.left != null)
                        deque.addLast(node.left);
                } else {
                    TreeNode node = deque.pollLast();
                    levelNodes.add(node.val);
                    if (node.left != null)
                        deque.addFirst(node.left);
                    if (node.right != null)
                        deque.addFirst(node.right);
                }
            }
            result.addAll(levelNodes);
            leftToRight = !leftToRight; // alternate direction for next level
        }

        return result;
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        List<Integer> result1 = spiralOrder(root1);
        System.out.println("Example 1 Output: " + result1);

        // Example 2
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(20);
        root2.right = new TreeNode(30);
        root2.left.left = new TreeNode(40);
        root2.left.right = new TreeNode(60);
        List<Integer> result2 = spiralOrder(root2);
        System.out.println("Example 2 Output: " + result2);

    }
}
