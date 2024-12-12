package com.app.codes.amz;
/*
Time Complexity:

In the worst case, the algorithm explores all nodes in the binary tree.
Let N be the number of nodes in the tree.
The time complexity is O(N).
Space Complexity:

The space complexity is determined by the recursive calls and the maximum depth of the call stack.
In the worst case, the maximum depth of the call stack is equal to the height of the binary tree.
Let H be the height of the tree.
The space complexity is O(H).
In the worst case, when the binary tree is highly unbalanced (skewed), the space complexity approaches O(N).

Note: In a balanced tree, the height is approximately log(N)

 */
public class MinDepthOfBinaryTree {

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // If the current node has no left child, calculate the minimum depth of the right subtree
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        // If the current node has no right child, calculate the minimum depth of the left subtree
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        // If the current node has both left and right children, calculate the minimum depth
        // by choosing the minimum depth of the two subtrees
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // If the node is a leaf, return 1
        if (root.left == null && root.right == null) {
            return 1;
        }

        // If one of the children is null, consider only the non-null child
        int leftDepth = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
        int rightDepth = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;

        // Return the minimum depth of the subtree rooted at the current node
        return 1 + Math.min(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);




        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        int minDepth = minDepth1(root);
        System.out.println("Minimum Depth: " + minDepth);

        int minDepth1 = minDepth(root1);
        System.out.println("Minimum Depth-1: " + minDepth1);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}