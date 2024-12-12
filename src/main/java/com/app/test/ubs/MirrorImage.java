package com.app.test.ubs;

public class MirrorImage {

    public static void main(String[] args) {
        // Example of a binary tree
        // Original:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Original Binary Tree:");
        printInOrder(root);

        // Find the mirror image
        TreeNode mirrorRoot = mirrorImage(root);

        System.out.println("\nMirror Image Binary Tree:");
        printInOrder(mirrorRoot);
    }

    public static TreeNode mirrorImage(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Swap left and right subtrees
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively mirror the left and right subtrees
        mirrorImage(root.left);
        mirrorImage(root.right);

        return root;
    }

    public static void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }
}