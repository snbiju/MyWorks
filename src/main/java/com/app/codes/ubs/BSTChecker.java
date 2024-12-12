package com.app.codes.ubs;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class BSTChecker {

    public static void main(String[] args) {
        // Example of a binary search tree
        //        2
        //       / \
        //      1   3
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(1);

        if (isBST(root1)) {
            System.out.println("The binary tree is a Binary Search Tree (BST).");
        } else {
            System.out.println("The binary tree is NOT a BST.");
        }
    }

    public static boolean isBST(TreeNode root) {
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTHelper(TreeNode node, int minValue, int maxValue) {
        if (node == null) {
            return true; // An empty tree is a BST
        }

        // Check if the current node's value is within the valid range
        if (node.val < minValue || node.val > maxValue) {
            return false;
        }

        // Recursively check the left and right subtrees
        return isBSTHelper(node.left, minValue, node.val - 1) &&
                isBSTHelper(node.right, node.val + 1, maxValue);
    }
}

